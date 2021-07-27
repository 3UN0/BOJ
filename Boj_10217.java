import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Boj_10217 {
	public static int N, M, K, u, v, c, d;
	public static int answer = Integer.MAX_VALUE;
	public static long[][] dp;	// ���� �ҿ�ð� ���� (i������ j������� �� �� �ִ� �ּҽð�)
	public static StringBuilder sb = new StringBuilder();
	public static ArrayList<Node10217>[] list;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int j=0;j<T;j++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());	// ������ ��
			M = Integer.parseInt(st.nextToken());	// �� ���� ���
			K = Integer.parseInt(st.nextToken());	// Ƽ�������� ��
			dp = new long[N+1][M+1];
			list = new ArrayList[N+1];	// 1~N ����
			
			for(int i=1;i<=N;i++) {
				list[i] = new ArrayList<Node10217>();
				Arrays.fill(dp[i], Integer.MAX_VALUE);
			}
			
			for(int i=0;i<K;i++) {
				st = new StringTokenizer(br.readLine(), " ");
				u = Integer.parseInt(st.nextToken());	// ��� ���� (��õ:1��, LA:N��)
				v = Integer.parseInt(st.nextToken());	// ���� ����
				c = Integer.parseInt(st.nextToken());	// ���
				d = Integer.parseInt(st.nextToken());	// �ҿ�ð�
				
				list[u].add(new Node10217(v, c, d));	
			}
			
			answer = dijkstra();
			if(answer == Integer.MAX_VALUE) {
				sb.append("Poor KCM\n");
			} else {
				sb.append(answer + "\n");
			}
			
		}
		System.out.println(sb);
	}
	
	// ���ͽ�Ʈ�� �˰���
	// ���� ����� ��忡�� �̾��� ��� �� �ϴ� �湮�Ͽ� �Ÿ� ����Ͽ� ���� ��
	// ���ο� ���� ���ο� �������� �߰��Ǹ� ������ �� �ִ� �ִܰŸ� �ٽ� ����Ͽ� �Ÿ� ����
	public static int dijkstra() {
		// ����ġ ���� ������� �����ϱ� ���ؼ� �켱���� ť ���
		PriorityQueue<Node10217> queue = new PriorityQueue<Node10217>();
		// ���� ��� 1
		queue.add(new Node10217(1, 0, 0));
		dp[1][0] = 0;

		// ť�� ���� ������ (�� ������ ���� �ִ� ��� �˻�)
		while(!queue.isEmpty()) {
			// ���� ��ġ�� �ִ� ��� ����
			Node10217 nowNode = queue.poll();
			// ���� -> �� (���ϴ� ��)
			int node = nowNode.end;
			
			// ��ǥ ���� �����ϸ� ����
			if(node == N)
				break;
			
			// dp�� ����� ���� �� ������ (�ּ�) �ݺ��� ������
			if(dp[node][nowNode.cost] < nowNode.time)
				continue;
			
			// ���� ��忡�� ����� ���� ���� �ּҽð� ���
			for(Node10217 next : list[node]) {
				int sumCost = nowNode.cost + next.cost;
				// ��� �ʰ� �� �ݺ��� ������
				if(sumCost > M) {
					continue;
				}
				int sumTime = nowNode.time + next.time;
				if(dp[next.end][sumCost] > sumTime) {
					dp[next.end][sumCost] = sumTime;
					// ���ʿ��� push ���� ���ؼ�
					// for(int i=sumCost; i<=M;i++){
					//		if(dp[next.end][i] > sumTime) dp[next.end][i]=sumTime;
					queue.add(new Node10217(next.end, sumCost, sumTime));
				}
			}
		}
		int result = Integer.MAX_VALUE;
		
		for(int i=1;i<=M;i++)
			result = (int) Math.min(result, dp[N][i]);
		
		return result;
	}
}

class Node10217 implements Comparable<Node10217>{
	int end;
	int cost;
	int time;
	
	public Node10217(int end, int cost, int time) {
		this.end = end;
		this.cost= cost;
		this.time = time;
	}
 
	@Override
	public int compareTo(Node10217 o) {
		// �ð� ������ �����ϵ�, �ð� ������ ��� ������ ���� (�� -> ��)
		if(this.time == o.time) {
			return cost - o.cost;
		} else {
			return time-o.time;
		}
		
	}
	
	
}
