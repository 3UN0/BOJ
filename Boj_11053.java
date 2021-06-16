import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_11053 {
	public static int[] arr;
	public static int[] dp;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		arr = new int[N];
		dp = new int[N];
		
		// ������ ��
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		dp[0] = 1;

		/* 	�ݺ��� (bottom-up)

		 * for(int i=1;i<N;i++) {
			dp[i] = 1;
			for(int j=0;j<i;j++) {
				if(arr[j] < arr[i] && dp[j] >= dp[i])
					dp[i] = dp[j] + 1;
			}
		}
		int max=0;
		for(int i=0;i<N;i++) {
			max = Math.max(dp[i], max);
		}
		
		System.out.println(max);*/
		
		for(int i=0;i<N;i++) {
			dp(i);
		}
		
		int max=0;
		for(int i=0;i<N;i++) {
			max = Math.max(dp[i], max);
		}
		System.out.println(max);
		
	}
	
	public static int dp(int n) {
		if(dp[n] == 0) {	
			dp[n] = 1;
			// n ������ ��� Ž��
			for(int i=n-1;i>=0;i--) {
				// ���� ���� �� ���� arr[n]�� ������ ���� �� �߰�
				if(arr[i] < arr[n]) {
					dp[n] = Math.max(dp[n], dp(i) + 1);
				}
			}
		}
		return dp[n];
	}
	
	
}
		