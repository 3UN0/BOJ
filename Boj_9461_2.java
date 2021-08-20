import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_9461_2 {
	public static StringBuilder sb = new StringBuilder();
	public static long[] dp = new long[101];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		
		dp[0] = 0;
		dp[1] = 1;
		dp[2] = 1;

		for(int i=3;i<dp.length;i++) {
			dp[i] = -1;
		}
		
		for(int i=0;i<T;i++) {
			int N = Integer.parseInt(br.readLine());
			sb.append(dp(N) + "\n");
		}
		
		System.out.println(sb);
	}
	
	public static long dp(int n) {
		if(dp[n] == -1) {
			dp[n] = dp(n-3) + dp(n-2);
		}
		return dp[n];
	}
}
