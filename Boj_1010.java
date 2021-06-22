import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_1010 {
	public static int[][] dp;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		
		for(int i=0;i<T;i++) {
			st = new StringTokenizer(br.readLine());
			
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());

			dp = new int[M+1][N+1];
			System.out.println(binodp(M, N));
		}
		
	}
	
	// 3. 동적계획법
	public static int binodp(int n, int k) {
		// 이미 풀었던 값 있을 경우 재활용
		if(dp[n][k] > 0) {
			return dp[n][k];
		}
		if(n == k || k == 0) {
			return dp[n][k] = 1;
		}
		
		return dp[n][k] = binodp(n-1, k-1) + binodp(n-1, k);
	}
}
