import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_2293 {
	public static int N, K;
	public static int[] arr;
	public static int[][] dp;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		arr = new int[N+1];
		for(int i=1;i<=N;i++) {
			arr[i] = Integer.parseInt(br.readLine());	// 동전 1, 2, 5
		}
		// dp[i][j]	=> i개의 종류의 동전을 사용하여 j원을 만듦
		dp = new int[N+1][K+1];   // 동전 1개, 1원 부터 사용함
		
		dp[0][0] = 1;	// dp[N][K]일 떄 -> 첫번째 동전(1원)으로 0원을 만드는 경우의 수 : 1
		
		for(int i=1;i<=N;i++) {
			for(int j=0;j<=K;j++) {
				// i번쨰 동전이 j원보다 클 경우 (cf.5원 짜리 동전은 j=5 일 때 사용 횟수 증가)
				if(arr[i] > j)
					dp[i][j] = dp[i-1][j];
				else
					dp[i][j] = dp[i-1][j] + dp[i][j-arr[i]];
			}
		}
		System.out.println(dp[N][K]);
	}
	
}
		