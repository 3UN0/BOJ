import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_1707 {
	public static int K, V, E;
	public static int[] number;
	public static ArrayList<ArrayList<Integer>> graph;
	// 0��° ����Ʈ�� ���� 1�� ������ �������� ��ȣ�� �Էµ� ... 
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int K = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		// map�� �ش� ��ǥ �� �Է�
		for(int t=0;t<K;t++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			V = Integer.parseInt(st.nextToken());	// ������ ����
			E = Integer.parseInt(st.nextToken());	// ������ ����
			number = new int[V+1];	// 1~V �����Ƿ�
			
			graph = new ArrayList<>();
			for(int i=0;i<=V;i++) {
				graph.add(new ArrayList<>());
			}
			
			for(int i=0;i<E;i++) {
				st = new StringTokenizer(br.readLine(), " ");
				// ���� ����
				int a = Integer.parseInt(st.nextToken());	
				int b = Integer.parseInt(st.nextToken());	
				graph.get(a).add(b);
				graph.get(b).add(a);
			}
			boolean flag = true;
			
			// ����׷����� �ƴ� ���� �����Ƿ� Ž������ ���� ��� ��� Ž��
			for(int i=1;i<=V;i++) {
				if(number[i] == 0) {	// �湮 x
					// ������ ����� �̺б׷��� ������ ���ϸ�
					// �ٸ� ��� Ž���� �ʿ� x
					if(!bfs(i)) {
						flag = false;
						break;
					}
				}
			}
			
			if(flag) {
				sb.append("YES\n");
			} else {
				sb.append("NO\n");
			}
			
		}
		System.out.println(sb);

	}
	
	// �ʺ� �켱 Ž�� (ť)
	public static boolean bfs(int start) {
		Queue<Integer> queue = new LinkedList<>();
		// ���� ��ǥ �߰�
		queue.add(start);
		// �湮 ǥ��
		number[start] = 1;
		
		// ť�� ���� ������
		while(!queue.isEmpty()) {
			// ���� ��ġ�� �ִ� �� ����
			int now = queue.poll();
			for(int next : graph.get(now)) {
				// 1-2-3 ó�� ����Ǿ� �ִٸ� 1-2-1 ó�� ��ȣ�� �ű�
				// �̹湮 -> ���� ���� ���Ͽ� ���� ����� ��ȣ �ű� (�ڽŰ� �ٸ� ��ȣ)
				if(number[next] == 0) {
					// ������ �湮�� ��ǥ �߰�
					queue.add(next);
					if(number[now] == 1)
						number[next] = 2;
					else
						number[next] = 1;
				}
				// ���� ���� ���� ��� ��ȣ ���ٸ� �̺б׷��� x
				if(number[now] == number[next])
					return false;
			}
		}
		return true;
	}
}