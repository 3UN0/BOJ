import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Boj_9370 {
	public static int n, m, t, s, g, h;
	public static int[] dis;	// �ִܰŸ� ����
	public static boolean[] visit;	// �湮 üũ
	public static StringBuilder sb = new StringBuilder();
	public static ArrayList<Node9370>[] list;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int j=0;j<T;j++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			n = Integer.parseInt(st.nextToken());	// ������ ����
			m = Integer.parseInt(st.nextToken());	// ������ ����
			t = Integer.parseInt(st.nextToken());	// ������ �ĺ��� ����
			list = new ArrayList[n+1];	// 1~N ����
			
			st = new StringTokenizer(br.readLine(), " ");
			s = Integer.parseInt(st.nextToken());	// ���������� �����
			g = Integer.parseInt(st.nextToken());	// ������ ������ 1
			h = Integer.parseInt(st.nextToken());	// ������ ������ 2 (1-2 ���� ���� ������)
			
			for(int i=1;i<=n;i++) {
				list[i] = new ArrayList<Node9370>();
			}
			
			// 1 - v1 - v2 - n ������ ��� (=> 1 - v2 - v1 - n)
			for(int i=0;i<m;i++) {
				st = new StringTokenizer(br.readLine(), " ");
				// ���� ����
				int a = Integer.parseInt(st.nextToken());	// start
				int b = Integer.parseInt(st.nextToken());	// end
				int d = Integer.parseInt(st.nextToken());	// �Ÿ� (weight)
				
				// �����
				list[a].add(new Node9370(b, d));	
				list[b].add(new Node9370(a, d));	
			}
			
			// �������� ������������ (���� �ͺ���) �����ϱ� ���� �켱���� ť ���� (���� �߰�)
			PriorityQueue<Integer> q = new PriorityQueue<>();
			for(int i=0;i<t;i++) {
				int x = Integer.parseInt(br.readLine());	// ������ ���
				
				// 1. h(g)~g(h) ������ �Ÿ�
				// 2. s~h(g) ������ �Ÿ�
				// 3. x~g(h) ������ �Ÿ�
				// s~x ������ �ִ� �Ÿ� (g, h ����) = min (ans1, ans2) �� ��� ���信 �߰��� 
				long ans1 = dijkstra(s, h) + dijkstra(h, g) + dijkstra(g, x);
				long ans2 = dijkstra(s, g) + dijkstra(g, h) + dijkstra(h, x);
				long ans3 = dijkstra(s, x);
				
				if(Math.min(ans1, ans2) == ans3) {
					q.add(x);
				}
			}
			while(!q.isEmpty()) {
				int end = q.poll();
				sb.append(end + " ");
			}
			sb.append("\n");
				
		}
		System.out.println(sb);
	}
	
	// ���ͽ�Ʈ�� �˰���
	// ���� ����� ��忡�� �̾��� ��� �� �ϴ� �湮�Ͽ� �Ÿ� ����Ͽ� ���� ��
	// ���ο� ���� ���ο� �������� �߰��Ǹ� ������ �� �ִ� �ִܰŸ� �ٽ� ����Ͽ� �Ÿ� ����
	public static long dijkstra(int start, int end) {
		// ����ġ ���� ������� �����ϱ� ���ؼ� �켱���� ť ���
		PriorityQueue<Node9370> queue = new PriorityQueue<Node9370>();
		// �湮 �迭 �ʱ�ȭ (�Լ� ���� �� ȣ���ϹǷ�)
		visit = new boolean[n+1];	// 1~V ����
		dis = new int[n+1];
		// ���� ��� �߰�
		queue.add(new Node9370(start, 0));
		// dis �迭 �ʱ�ȭ (�Լ� ���� �� ȣ���ϹǷ�)
		Arrays.fill(dis, Integer.MAX_VALUE);

		// �ִ� �Ÿ� �Է�
		dis[start] = 0;
		
		// ť�� ���� ������ (�� ������ ���� �ִ� ��� �˻�)
		while(!queue.isEmpty()) {
			// ���� ��ġ�� �ִ� ��� ����
			Node9370 nowNode = queue.poll();
			// ���� -> �� (���ϴ� ��)
			int now = nowNode.end;
			
			// ���� ��带 �湮�ߴٸ� continue (�ڱ� �ڽ�)
			if(visit[now])
				continue;
			visit[now] = true;
			
			// ���� ��忡�� ����� ���� ���� �ִܰŸ� ���
			for(Node9370 node : list[now]) {
				if(dis[node.end] > dis[now] + node.weight) {
					dis[node.end] = dis[now] + node.weight;
					queue.add(new Node9370(node.end, dis[node.end]));
				}
			}
		}
		return dis[end];
	}
}

class Node9370 implements Comparable<Node9370>{
	int end;
	int weight;
	
	public Node9370(int end, int weight) {
		this.end = end;
		this.weight = weight;
	}
	// weight ������ ����
	@Override
	public int compareTo(Node9370 o) {
		return weight-o.weight;
	}
	
	
}
