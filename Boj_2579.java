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
		
		for(int i=1;i<=N;i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		dp[0] = arr[0];	// 0
		dp[1] = arr[1];	// 계단 1개일 경우 무조건 1-> dp[1] = 첫 계단에 입력된 값
		
		if(N>=2) {	// 두 번째 계단은 무조건 첫 계단->두 번째 계단 이므로 (첫 값 + 두 번째 값)
			dp[2] = arr[1] + arr[2];
		}
		
		// BOTTOM-UP 방식일 때 -> for문으로 작은문제부터 큰문제로 풀이
		/*for(int i=3;i<=N;i++) {
			dp[i] = Math.max(dp[i-2], dp[i-3] + arr[i-1]) + arr[i];
		}*/
		
		System.out.println(dp(N));
		
	}
	public static int dp(int n) {
		// 두 칸 전(n - 2)의 '메모이제이션 값'과 첫 칸 전(n - 1)의 값 + 셋 째칸 전(n - 3)의 '메모이제이션 값' 중 큰 값을 현재 i 계단의 값과 합하여 DP배열에 저장(Memoization)
		if(dp[n] == null) {
			dp[n] = Math.max(dp(n-2), arr[n-1]+dp(n-3)) + arr[n];
		}
		
		return dp[n];
		
	} 
	
}
		