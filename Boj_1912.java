import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_1912 {
	public static int[] arr;
	public static Integer[] dp;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		arr = new int[N];
		dp = new Integer[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		dp[0] = arr[0];
		dp(N-1);	// dp의 마지막 인덱스는 n-1 이므로 탐색은 n-1 부터
		int max=Integer.MIN_VALUE;
		for(int i=0;i<N;i++) {
			max = Math.max(dp[i], max);
		}
		
		System.out.println(max);
	}
	

	public static int dp(int n) {
		if(dp[n] == null) {
			dp[n] = Math.max(dp(n-1)+arr[n], arr[n]);
			
		}
		return dp[n];
	}
	
}
		