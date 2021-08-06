import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_4803 {
	public static StringBuilder sb = new StringBuilder();
	public static ArrayList<ArrayList<Integer>> graph;
	public static boolean[] visit;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int testcase = 1;

		while(true) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());	// ����
			int m = Integer.parseInt(st.nextToken());	// ����
			
			if(n==0 && m==0) {
				break;
			}
			
			// �׷��� �ʱ�ȭ
			graph = new ArrayList<>();
			for(int i=0;i<=n;i++) {
				graph.add(new ArrayList<>());
			}
			
			// �׷��� ���� �Է�
			for(int i=0;i<m;i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				graph.get(a).add(b);
				graph.get(b).add(a);
			}
			
			visit = new boolean[n+1];
			
			int count = 0;
			// ���� Ʈ�� ������ �� ����->��� ��� �˻�
			for(int i=1;i<=n;i++) {
				if(!visit[i]) {
					count += Tree(i);
				}
			}
			
			if(count == 0) {
				sb.append("Case " + testcase++ + ": No trees.");
			} else if(count == 1) {
				sb.append("Case " + testcase++ + ": There is one tree.");
			} else {
				sb.append("Case " + testcase++ + ": A forest of " + count + " trees.");
			}
			sb.append("\n");
		}
		
		System.out.println(sb);
		
	}
	
	// Ʈ�� �´��� �˻�
	// Ʈ�� -> ��� ���� = ���� ���� +1;
	// ����� ���� �׷��� => ���  = (����/2)+1 => Ʈ��
	public static int Tree(int start) {
		Queue<Integer> queue = new LinkedList<>();
		// ���� ��� �߰�
		queue.add(start);
		int node = 0;
		int edge = 0;
		
		while(!queue.isEmpty()) {
			int now = queue.poll();
			// ��� ������ +1
			node += 1;
			visit[now] = true;
			
			for(int next : graph.get(now)) {
				// �׷��� ���� ��忡�� ����� ���� ������
				edge += 1;
				if(!visit[next]) {
					queue.add(next);
				}
			}
		}
		// Ʈ�� ������ 1, �ƴϸ� 0
		return node == (edge/2) + 1 ? 1 : 0;
	}
	
}


