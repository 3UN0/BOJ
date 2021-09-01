import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_11053_2 {
	public static StringBuilder sb = new StringBuilder();
	public static int[] dp;	// 누적합
	public static int[] arr;	// 수열
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		dp = new int[N];
		arr = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		// 숫자 1개일 때 길이 1
		dp[0] = 1;
		
		// BOTTOM-UP
		for(int i=1;i<N;i++) {
			dp[i] = 1;
			for(int j=0;j<i;j++) {
				// arr: 현 숫자가 앞 숫자들보다 클 때
				// dp: 현 dp값 = 앞 dp의 최댓값 + 1 (앞 dp가 현 dp보다 크거나 같을 때)
				if(arr[i] > arr[j] && dp[i] <= dp[j]) {
					dp[i] = dp[j] + 1;
				}
			}
		}
		
		int max = 0;
		for(int i=0;i<N;i++) {
			max = Math.max(dp[i], max);
		}
		
		System.out.println(max);
		
	}
}
