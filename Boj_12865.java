import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_12865 {
	public static int[][] arr;
	public static Integer[][] dp;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		arr = new int[N][2];	// 물건 무게, 가치
		dp = new Integer[N][K+1];
		
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine(), " ");
			
			arr[i][0] = Integer.parseInt(st.nextToken());	// 무게 k
			arr[i][1] = Integer.parseInt(st.nextToken());	// 가치 v
		}
		
		System.out.println(dp(N-1, K));
	}
	

	public static int dp(int i, int k) {
		if(i < 0) {	// i가 범위 밖일 경우
			return 0;
		}
		
		if(dp[i][k] == null) {
			// 현재 물건을 더 못담을 경우 (이전 i값 탐색) 
			if(arr[i][0] > k) {
				dp[i][k] = dp(i-1, k);
			}
			// 현재 물건(i)더 다을  수 있는 경우
			else if(arr[i][0] <= k) {
				// 이전 i값 vs 이전 i값에 대한 k-arr[i][0](무게)의 값 + 현재 가치 arr[i][1]	 중 큰 값 저장
				dp[i][k] = Math.max(dp(i-1, k), dp(i-1, k-arr[i][0])+arr[i][1]);
			}
		}			
		return dp[i][k];
	}


}

		