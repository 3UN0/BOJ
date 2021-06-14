import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_1149 {
	public static int[][] cost;	// 각 색상의 비용
	public static int[][] dp;	// 누적합 저장할 dp
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		cost = new int[N][3];
		dp = new int[N][3];
		
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for(int j=0;j<3;j++) {
				cost[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		// dp의 첫번째 값은 각 색상 비용의 첫번째 값으로 초기화
		dp[0][0] = cost[0][0];	//RED
		dp[0][1] = cost[0][1];	//GREEN
		dp[0][2] = cost[0][2];	//BLUE
		
		
		System.out.println(Math.min(Paint(N-1, 0), Math.min(Paint(N-1, 1), Paint(N-1, 2))));
		
	}
	public static int Paint(int N, int color) {
		// 탐색x 배열
		if(dp[N][color] == 0) {
			// color 에 따라 이전 집과 서로 다른 색을 재귀호출하여 최솟값+현재 집 비용 계산하여 dp 저장
/*			Red일 경우
			Cost[N][0] = min( Cost[N-1][1], Cost[N-1][2] ) + Cost[N][0]

			Green일 경우
			Cost[N][1] = min( Cost[N-1][0], Cost[N-1][2] ) + Cost[N][1]

			Blue일 경우
			Cost[N][2] = min( Cost[N-1][0], Cost[N-1][1] ) + Cost[N][2]
*/		
			
			if(color == 0) {	//RED
				return dp[N][0] = Math.min(Paint(N-1, 1), Paint(N-1, 2)) + cost[N][0];
			}
		
			else if(color == 1) {	//GREEN
				return dp[N][1] = Math.min(Paint(N-1, 0), Paint(N-1, 2)) + cost[N][1];
			}
		
			else if(color == 2) {	//BLUE
				return dp[N][2] = Math.min(Paint(N-1, 0), Paint(N-1, 1)) + cost[N][2];
			}
		}
		return dp[N][color];
	}
	
	
	
}
		