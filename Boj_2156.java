import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_2156 {
	public static int[] arr;
	public static Integer[] dp;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		arr = new int[N+1];
		dp = new Integer[N+1];
		
		// 포도주 양
		for(int i=1;i<=N;i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		dp[0] = 0;
		dp[1] = arr[1];
		
		if(N > 1) {
			dp[2] = arr[1] + arr[2];
		}
		System.out.println(dp(N));
		
	}
	
	public static int dp(int n) {
		if(dp[n] == null) {	
			dp[n] = Math.max(Math.max(dp(n- 2), dp(n - 3) + arr[n - 1])+arr[n], dp(n-1));
			
		}
		return dp[n];
	}
	
	
}
		