import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_1003 {
	public static int[][] dp = new int[41][2];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
		int T = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < dp.length; i++) {
			dp[i][0] = -1;
			dp[i][1] = -1;
		}
		
		dp[0][0] = 1;	// fib(0) = 0
		dp[0][1] = 0;
		dp[1][0] = 0;	
		dp[1][1] = 1;	// fib(1) = 1
		
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<T;i++) {
			int N = Integer.parseInt(br.readLine());
			fib(N);
			sb.append(dp[N][0] + " " + dp[N][1] + "\n");
		}
		System.out.println(sb);
		
	}
	
	public static int[] fib(int n) {
		//n에 대하여 해당 값이 없을 때
		if(dp[n][0] == -1 || dp[n][1] == -1) {
			dp[n][0] = fib(n-1)[0]+fib(n-2)[0];
			dp[n][1] = fib(n-1)[1]+fib(n-2)[1];
		}
		return dp[n];
	}
	
	
}
		