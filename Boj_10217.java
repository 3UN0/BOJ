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
	public static long[][] dp;	// 최저 소요시간 저장 (i노드까지 j비용으로 갈 수 있는 최소시간)
	public static StringBuilder sb = new StringBuilder();
	public static ArrayList<Node10217>[] list;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int j=0;j<T;j++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());	// 공항의 수
			M = Integer.parseInt(st.nextToken());	// 총 지원 비용
			K = Integer.parseInt(st.nextToken());	// 티켓정보의 수
			dp = new long[N+1][M+1];
			list = new ArrayList[N+1];	// 1~N 까지
			
			for(int i=1;i<=N;i++) {
				list[i] = new ArrayList<Node10217>();
				Arrays.fill(dp[i], Integer.MAX_VALUE);
			}
			
			for(int i=0;i<K;i++) {
				st = new StringTokenizer(br.readLine(), " ");
				u = Integer.parseInt(st.nextToken());	// 출발 공항 (인천:1번, LA:N번)
				v = Integer.parseInt(st.nextToken());	// 도착 공항
				c = Integer.parseInt(st.nextToken());	// 비용
				d = Integer.parseInt(st.nextToken());	// 소요시간
				
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
	
	// 다익스트라 알고리즘
	// 현재 연결된 노드에서 이어진 모든 곳 일단 방문하여 거리 계산하여 저장 후
	// 새로운 노드와 새로운 간선들이 추가되면 도달할 수 있는 최단거리 다시 계산하여 거리 저장
	public static int dijkstra() {
		// 가중치 적은 순서대로 저장하기 위해서 우선순위 큐 사용
		PriorityQueue<Node10217> queue = new PriorityQueue<Node10217>();
		// 시작 노드 1
		queue.add(new Node10217(1, 0, 0));
		dp[1][0] = 0;

		// 큐에 값이 있으면 (각 노드까지 가는 최단 경로 검사)
		while(!queue.isEmpty()) {
			// 현재 위치에 있는 노드 저장
			Node10217 nowNode = queue.poll();
			// 시작 -> 끝 (향하는 곳)
			int node = nowNode.end;
			
			// 목표 공항 도착하면 종료
			if(node == N)
				break;
			
			// dp에 저장된 값이 더 작으면 (최소) 반복문 밖으로
			if(dp[node][nowNode.cost] < nowNode.time)
				continue;
			
			// 현재 노드에서 연결된 노드로 가는 최소시간 계산
			for(Node10217 next : list[node]) {
				int sumCost = nowNode.cost + next.cost;
				// 비용 초과 시 반복문 밖으로
				if(sumCost > M) {
					continue;
				}
				int sumTime = nowNode.time + next.time;
				if(dp[next.end][sumCost] > sumTime) {
					dp[next.end][sumCost] = sumTime;
					// 불필요한 push 막기 위해선
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
		// 시간 순으로 정렬하되, 시간 같으면 비용 순으로 정렬 (저 -> 고)
		if(this.time == o.time) {
			return cost - o.cost;
		} else {
			return time-o.time;
		}
		
	}
	
	
}
