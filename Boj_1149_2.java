import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_1149_2 {
	public static StringBuilder sb = new StringBuilder();
	public static int[][] dp;	// 누적합
	public static int[][] cost;	// 비용
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		dp = new int[N][3];
		cost = new int[N][3];
		
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for(int j=0;j<3;j++) {	// 빨, 초, 파 비용 저장
				cost[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 첫번째 집이 red . green . blue 일 때
		dp[0][0] = cost[0][0];	// red
		dp[0][1] = cost[0][1];	// green
		dp[0][2] = cost[0][2];	// blue
		
		/* 배열 점화식 사용
		for(int i=1;i<N;i++) {
			cost[i][0] = Math.min(cost[i-1][1], cost[i-1][2])+cost[i][0];
			cost[i][1] = Math.min(cost[i-1][0], cost[i-1][2])+cost[i][1];
			cost[i][2] = Math.min(cost[i-1][0], cost[i-1][1])+cost[i][2];
		}
		*/
//		System.out.println(Math.min(Math.min(cost[N-1][0], cost[N-1][1]), cost[N-1][2]));
		System.out.println(Math.min(Math.min(dp(N-1, 0), dp(N-1, 1)), dp(N-1, 2)));

	}
	
	
	public static int dp(int N, int color) {
		
		if(dp[N][color] == 0) {
			// red
			if(color == 0) {
				dp[N][0] = Math.min(dp(N-1, 1), dp(N-1, 2)) + cost[N][0];
			}
			
			// green
			else if (color == 1) {
				dp[N][1] = Math.min(dp(N-1, 0), dp(N-1, 2)) + cost[N][1];
			}
			
			// blue
			else if (color == 2) {
				dp[N][2] = Math.min(dp(N-1, 0), dp(N-1, 1)) + cost[N][2];				
			}
		}
		
		return dp[N][color];
	}
	
}
