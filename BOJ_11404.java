import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_11404 {
	public static int n, m, a, b, c;
	public static long[][] dis;	// 최단거리 저장
	public static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());	// 도시 개수
		m = Integer.parseInt(br.readLine());	// 버스 개수
		
		dis = new long[n+1][n+1];	// 1~N 까지
		
		for(long[] a : dis) {
			Arrays.fill(a, Integer.MAX_VALUE);
		}
			
		StringTokenizer st;
		for(int i=0;i<m;i++) {
			st = new StringTokenizer(br.readLine(), " ");
			// 간선 정보
			int a = Integer.parseInt(st.nextToken());	// start
			int b = Integer.parseInt(st.nextToken());	// end
			int c = Integer.parseInt(st.nextToken());	// 비용 (cost)

			dis[a][b] = Math.min(dis[a][b], c);
		}
		
		floyd();

		for(int i=1;i<=n;i++) {
			for(int j=1;j<=n;j++) {
				// 시작 도시 = 도착 도시 or 갈 수 없는 도시 (초기화 값 그대로인 곳)
				if(i == j || dis[i][j] >= Integer.MAX_VALUE) {
					sb.append("0 ");
				} else {
					sb.append(dis[i][j] + " ");
				}
			}
			sb.append("\n");
		}
		
		System.out.println(sb);
	}
	
	// 플로이드 알고리즘
	public static void floyd() {
		// i ~ j 까지의 최단거리 : i ~ k + k ~ j (각 최단 거리의 합) : 두 가지 비교하여 min 저장
		// 모든 노드들을 한번씩 거쳐가는 k를 기준으로 함
		for(int k=1;k<=n;k++) {
			// 출발하는 노드
			for(int i=1;i<=n;i++) {
				// 도착하는 노드
				for(int j=1;j<=n;j++) {
					dis[i][j] = Math.min(dis[i][j], dis[i][k] + dis[k][j]);
					
				}
			}
		}
	}
}
