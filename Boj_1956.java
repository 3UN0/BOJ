import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj_1956 {
	public static int V, E;
	public static long[][] dis;	// 최단거리 저장
	public static boolean[] visit;	// 방문 체크
	public static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		V = Integer.parseInt(st.nextToken());	// 정점의 개수
		E = Integer.parseInt(st.nextToken());	// 간선의 개수

		dis = new long[V+1][V+1];	// 1~N 까지
		
		for(long[] a : dis) {
			Arrays.fill(a, Integer.MAX_VALUE);
		}
			
		// 1 - v1 - v2 - n 까지의 경로 (=> 1 - v2 - v1 - n)
		for(int i=0;i<E;i++) {
			st = new StringTokenizer(br.readLine(), " ");
			// 간선 정보
			int a = Integer.parseInt(st.nextToken());	// start
			int b = Integer.parseInt(st.nextToken());	// end
			int c = Integer.parseInt(st.nextToken());	// 거리 (weight)
			
			dis[a][b] = Math.min(dis[a][b], c);
		}
		
		floyd();

		long ans = Integer.MAX_VALUE;
		for(int i=1;i<=V;i++) {
			// 갈 수 없는 마을 (초기화 값 그대로인 곳) (경로 x)
			ans = Math.min(ans, dis[i][i]);
		}	
		
		if(ans == Integer.MAX_VALUE) {
			System.out.println("-1");
		} else {
			System.out.println(ans);
		}
	}
	
	// 플로이드 알고리즘
	public static void floyd() {
		// i ~ j 까지의 최단거리 : i ~ k + k ~ j (각 최단 거리의 합) : 두 가지 비교하여 min 저장
		// 모든 노드들을 한번씩 거쳐가는 k를 기준으로 함
		for(int k=1;k<=V;k++) {
			// 출발하는 노드
			for(int i=1;i<=V;i++) {
				// 도착하는 노드
				for(int j=1;j<=V;j++) {
					dis[i][j] = Math.min(dis[i][j], dis[i][k] + dis[k][j]);
					
				}
			}
		}
	}
	
	
}
