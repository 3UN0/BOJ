import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_1904 {
	public static StringBuilder sb = new StringBuilder();
	public static int[] dp = new int[1000001];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		dp[0] = 0;
		dp[1] = 1;
		dp[2] = 2;
		
		for(int i=0;i<dp.length;i++) {
			dp[i] = -1;
		}
		
		int N = Integer.parseInt(br.readLine());
		
		System.out.println(dp(N));
	}
	
	public static int dp(int n) {
		if(dp[n] == -1) {
			dp[n] = (dp(n-1) + dp(n-2))%15746;
		}
		return dp[n];
	}
}
