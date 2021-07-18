import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Boj_1753 {
	public static int K, V, E;
	public static int[] dis;	// �ִܰŸ� ����
	public static boolean[] visit;	// �湮
	public static ArrayList<Node>[] list;
	// 0��° ����Ʈ�� ���� 1�� ������ �������� ��ȣ�� �Էµ� ... 
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		V = Integer.parseInt(st.nextToken());	// ������ ����
		E = Integer.parseInt(st.nextToken());	// ������ ����
		K = Integer.parseInt(br.readLine());

		dis = new int[V+1];	// 1~V �����Ƿ�	
		list = new ArrayList[V+1];	// 1~V �����Ƿ�
		visit = new boolean[V+1];	// 1~V ����
		Arrays.fill(dis, Integer.MAX_VALUE);	// dis �迭 �ϰ� �ʱ�ȭ
		
		for(int i=1;i<=V;i++) {
			list[i] = new ArrayList<Node>();
		}

		for(int i=0;i<E;i++) {
			st = new StringTokenizer(br.readLine(), " ");
			// ���� ����
			int u = Integer.parseInt(st.nextToken());	// start
			int v = Integer.parseInt(st.nextToken());	// end
			int w = Integer.parseInt(st.nextToken());	// weight
			
			list[u].add(new Node(v, w));
		}
		
		StringBuilder sb = new StringBuilder();
		
		dijkstra(K);
		
		for(int i=1;i<=V;i++) {
			if(dis[i] == Integer.MAX_VALUE) {
				sb.append("INF\n");
			} else {
				sb.append(dis[i] + "\n");
			}
		}

		System.out.println(sb);

	}
	
	// ���ͽ�Ʈ�� �˰���
	// ���� ����� ��忡�� �̾��� ��� �� �ϴ� �湮�Ͽ� �Ÿ� ����Ͽ� ���� ��
	// ���ο� ���� ���ο� �������� �߰��Ǹ� ������ �� �ִ� �ִܰŸ� �ٽ� ����Ͽ� �Ÿ� ����
	public static void dijkstra(int start) {
		// ����ġ ���� ������� �����ϱ� ���ؼ� �켱���� ť ���
		PriorityQueue<Node> queue = new PriorityQueue<Node>();
		// ���� ��ǥ �߰�
		queue.add(new Node(start, 0));
		// �ִ� �Ÿ� �Է�
		dis[start] = 0;
		
		// ť�� ���� ������ (�� ������ ���� �ִ� ��� �˻�)
		while(!queue.isEmpty()) {
			// ���� ��ġ�� �ִ� ��� ����
			Node nowNode = queue.poll();
			// ���� -> �� (���ϴ� ��)
			int now = nowNode.end;
			
			// ���� ��带 �湮�ߴٸ� continue (�ڱ� �ڽ�)
			if(visit[now])
				continue;
			visit[now] = true;
			
			// ���� ��忡�� ����� ���� ���� �ִܰŸ� ���
			for(Node node : list[now]) {
				if(dis[node.end] > dis[now] + node.weight) {
					dis[node.end] = dis[now] + node.weight;
					queue.add(new Node(node.end, dis[node.end]));
				}
			}
		}
	}
}

class Node implements Comparable<Node>{
	int end;
	int weight;
	
	public Node(int end, int weight) {
		this.end = end;
		this.weight = weight;
	}
	// weight ������ ����
	@Override
	public int compareTo(Node o) {
		return weight-o.weight;
	}
	
	
}
