import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_1932_2 {
	public static StringBuilder sb = new StringBuilder();
	public static int[][] dp;	// 누적합
	public static int[][] tri;	// 비용
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		dp = new int[N][N];
		tri = new int[N][N];
		
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for(int j=0;j<i+1;j++) {
				tri[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=0;i<N;i++) {
			dp[N-1][i] = tri[N-1][i];
		}

		for(int i=N-1;i>0;i--) {
			for(int j=0;j<i;j++) {
				dp[i-1][j] = Math.max(dp[i][j], dp[i][j+1]) + tri[i-1][j];
			}
		}
		
		
		System.out.println(dp[0][0]);
		
	}
	
	
	/*public static int dp(int N, int num) {
		
		if(dp[N][num] == null) {
			dp[N][num] = Math.max(dp(N+1, num), dp(N+1, num+1)) + tri[N][num]; 
		}
		
		return dp[N][num];
		
	}*/
	
}
