import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_2579 {
	public static Integer[] dp;	// 누적합
	public static int[] arr;	// 계단 값
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		dp = new Integer[N+1];
		arr = new int[N+1];
		
		for(int i=1;i<=N;i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		dp[0] = 0;
		dp[1] = arr[1];
		
		if(N>=2) { // 두 번째 계단은 무조건 첫 계단->두 번째 계단 이므로 (첫 값 + 두 번째 값)
			dp[2] = arr[1] + arr[2];
		}
		
		// BOTTOM-UP 방식일 때 -> for문으로 작은문제부터 큰문제로 풀이
		// 이전 계단  dp 값과  두칸을 넘어서 도달할 경우 비교
		for(int i=3;i<=N;i++) {
			dp[i] = Math.max(dp[i-2], dp[i-3] + arr[i-1]) + arr[i];
		}
		
		System.out.println(dp[N]);
		
	}
}
		
