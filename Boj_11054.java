import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_11054 {
	public static int[] arr;
	public static int[] dp;
	public static int[] dpm;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		arr = new int[N];
		dp = new int[N];	// 123 ��������
		dpm = new int[N];	// 321 ��������

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		dp[0] = 1;
		dpm[0] = 1;

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
			dpm(i);
		}
		
		int max=0;
		for(int i=0;i<N;i++) {
			max = Math.max(dp[i]+dpm[i], max);
		}
		// �� ���� ���� ��ġ�� ���� ���� �ߺ��ǹǷ�, ��ü ��ģ ���� �迭���� 1�� ����� ��
		System.out.println(max-1);
		
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
	
	public static int dpm(int n) {
		if(dpm[n] == 0) {
			dpm[n] = 1;
			
			// n ������ ��� Ž�� 12 3 21 �̶�� n=3, i=2, 1 ... 
			for(int i=n+1;i<dp.length;i++) {
				if(arr[i] < arr[n]) {
					dpm[n] = Math.max(dpm[n], dpm(i) + 1);
				}
			}
		}
		return dpm[n];
	}
	
	
}
		