import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_2579 {
	public static int[] arr;
	public static Integer[] dp;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		arr = new int[N+1];
		dp = new Integer[N+1];
		
		dp[0] = 0;
		dp[1] = 0;
		dp[2] = 1;
		
		
/*		if(N>=2) {	// 두 번째 계단은 무조건 첫 계단->두 번째 계단 이므로 (첫 값 + 두 번째 값)
			dp[2] = arr[1] + arr[2];
		}
*/		
		// BOTTOM-UP 방식일 때 -> for문으로 작은문제부터 큰문제로 풀이
		/*for(int i=3;i<=N;i++) {
			dp[i] = Math.max(dp[i-2], dp[i-3] + arr[i-1]) + arr[i];
		}*/
		
		
		System.out.println(one(N));
		
	}
	
	
	public static int one(int n) {
		if(dp[n] == null) {
			if(n/6 == 0) {	// 6으로 나눠지는 경우
				dp[n] = Math.min(one(n-1), Math.min(one(n/3), one(n/2)));
			}
			else if(n/3 == 0) {	// 3으로만 나눠지는 경우
				dp[n] = Math.min(one(n/3), one(n-1));
			} else if(n/2 == 0) {	// 2로만 나눠지는 경우
				dp[n] = Math.min(one(n/2), one(n-1));
			} else	// 그외
				dp[n] = one(n-1);
		}
		return dp[n];
	}
	
	
}
		