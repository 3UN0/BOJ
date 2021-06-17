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
		
		arr = new int[N][2];	// ���� ����, ��ġ
		dp = new Integer[N][K+1];
		
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine(), " ");
			
			arr[i][0] = Integer.parseInt(st.nextToken());	// ���� k
			arr[i][1] = Integer.parseInt(st.nextToken());	// ��ġ v
		}
		
		System.out.println(dp(N-1, K));
	}
	

	public static int dp(int i, int k) {
		if(i < 0) {	// i�� ���� ���� ���
			return 0;
		}
		
		if(dp[i][k] == null) {
			// ���� ������ �� ������ ��� (���� i�� Ž��) 
			if(arr[i][0] > k) {
				dp[i][k] = dp(i-1, k);
			}
			// ���� ����(i)�� ����  �� �ִ� ���
			else if(arr[i][0] <= k) {
				// ���� i�� vs ���� i���� ���� k-arr[i][0](����)�� �� + ���� ��ġ arr[i][1]	 �� ū �� ����
				dp[i][k] = Math.max(dp(i-1, k), dp(i-1, k-arr[i][0])+arr[i][1]);
			}
		}			
		return dp[i][k];
	}


}

		