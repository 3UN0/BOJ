import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Boj_1504 {
	public static int N, E;
	public static int[] dis;	// �ִܰŸ� ����
	public static boolean[] visit;	// �湮 üũ
	public static ArrayList<Node1504>[] list;
	// 0��° ����Ʈ�� ���� 1�� ������ �������� ��ȣ�� �Էµ� ... 
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());	// ������ ����
		E = Integer.parseInt(st.nextToken());	// ������ ����

		dis = new int[N+1];	// 1~N ����	
		list = new ArrayList[N+1];	// 1~N ����
		// visit = new boolean[N+1];	// 1~V ����
		//Arrays.fill(dis, Integer.MAX_VALUE);	// dis �迭 �ϰ� �ʱ�ȭ

		for(int i=1;i<=N;i++) {
			list[i] = new ArrayList<Node1504>();
		}

		// 1 - v1 - v2 - n ������ ��� (=> 1 - v2 - v1 - n)
		for(int i=0;i<E;i++) {
			st = new StringTokenizer(br.readLine(), " ");
			// ���� ����
			int a = Integer.parseInt(st.nextToken());	// start
			int b = Integer.parseInt(st.nextToken());	// end
			int w = Integer.parseInt(st.nextToken());	// �Ÿ� (weight)
			
			// �����
			list[a].add(new Node1504(b, w));	
			list[b].add(new Node1504(a, w));	
		}
		
		st = new StringTokenizer(br.readLine(), " ");
		int v1 = Integer.parseInt(st.nextToken());	// �ʼ� �湮 ����
		int v2 = Integer.parseInt(st.nextToken());	// �ʼ� �湮 ����
		
		
		StringBuilder sb = new StringBuilder();

		// 1. v1(v2)~v2(v1) ������ �Ÿ�
		// 2. 1~v1(v2) ������ �Ÿ�
		// 3. n~v1(v2) ������ �Ÿ�
		long ans1 = dijkstra(1, v1) + dijkstra(v1, v2) + dijkstra(v2, N);
		long ans2 = dijkstra(1, v2) + dijkstra(v2, v1) + dijkstra(v1, N);
		
		if(Math.min(ans1, ans2) >= Integer.MAX_VALUE) {
			System.out.println(-1);
		} else {
			System.out.println(Math.min(ans1, ans2));
		}

	}
	
	// ���ͽ�Ʈ�� �˰���
	// ���� ����� ��忡�� �̾��� ��� �� �ϴ� �湮�Ͽ� �Ÿ� ����Ͽ� ���� ��
	// ���ο� ���� ���ο� �������� �߰��Ǹ� ������ �� �ִ� �ִܰŸ� �ٽ� ����Ͽ� �Ÿ� ����
	public static long dijkstra(int start, int end) {
		// ����ġ ���� ������� �����ϱ� ���ؼ� �켱���� ť ���
		PriorityQueue<Node1504> queue = new PriorityQueue<Node1504>();
		// �湮 �迭 �ʱ�ȭ (�Լ� ���� �� ȣ���ϹǷ�)
		visit = new boolean[N+1];	// 1~V ����
		// ���� ��� �߰�
		queue.add(new Node1504(start, 0));
		// dis �迭 �ʱ�ȭ (�Լ� ���� �� ȣ���ϹǷ�)
		Arrays.fill(dis, Integer.MAX_VALUE);

		// �ִ� �Ÿ� �Է�
		dis[start] = 0;
		
		// ť�� ���� ������ (�� ������ ���� �ִ� ��� �˻�)
		while(!queue.isEmpty()) {
			// ���� ��ġ�� �ִ� ��� ����
			Node1504 nowNode = queue.poll();
			// ���� -> �� (���ϴ� ��)
			int now = nowNode.end;
			
			// ���� ��带 �湮�ߴٸ� continue (�ڱ� �ڽ�)
			if(visit[now])
				continue;
			visit[now] = true;
			
			// ���� ��忡�� ����� ���� ���� �ִܰŸ� ���
			for(Node1504 node : list[now]) {
				if(dis[node.end] > dis[now] + node.weight) {
					dis[node.end] = dis[now] + node.weight;
					queue.add(new Node1504(node.end, dis[node.end]));
				}
			}
		}
		return dis[end];
	}
}

class Node1504 implements Comparable<Node1504>{
	int end;
	int weight;
	
	public Node1504(int end, int weight) {
		this.end = end;
		this.weight = weight;
	}
	// weight ������ ����
	@Override
	public int compareTo(Node1504 o) {
		return weight-o.weight;
	}
	
	
}
