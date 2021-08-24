import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_10844_2 {
	final static long m = 1000000000;
	public static Long[][] dp;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		dp = new Long[N+1][10];
		
		for(int i=0;i<10;i++) {
			dp[1][i] = (long) 1;
		}
		
		long result = 0;
		
		
		for(int i=2;i<=N;i++) {
			for(int j=0;j<10;j++) {
				if(j == 0) {
					dp[i][j] = dp[i-1][j+1];
				} else if (j == 9) {
					dp[i][j] = dp[i-1][j-1];
				} else {
					dp[i][j] = dp[i-1][j-1] + dp[i-1][j+1];
				}
				dp[i][j] %= m;
			}
		}

		// N 번째 자리수가 i 값일 경우 모두 합함
		for(int i=1;i<=9;i++) {
			result += dp[N][i];
		}
		
		System.out.println(result % m);
		
	}
	
	// n : 자릿수 , value : 자릿값 (n=1, value= 1, 2, 3 ... 9)
	public static long dp(int n, int value) {
		// 첫째자리수에 도달하면 탐색X
		if(n == 1) {
			return dp[n][value];
		}
				
		if(dp[n][value] == null) {
			if(value == 0) {
				dp[n][value] = dp(n-1, 1);
			} else if (value == 9) {
				dp[n][value] = dp(n-1, 8);
			} else {
				dp[n][value] = dp(n-1, value-1) + dp(n-1, value+1);
			}
		}
		return dp[n][value] % m;
	}
	
	
}
		