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
		dp[1] = arr[1];	// ��� 1���� ��� ������ 1-> dp[1] = ù ��ܿ� �Էµ� ��
		
		if(N>=2) {	// �� ��° ����� ������ ù ���->�� ��° ��� �̹Ƿ� (ù �� + �� ��° ��)
			dp[2] = arr[1] + arr[2];
		}
		
		// BOTTOM-UP ����� �� -> for������ ������������ ū������ Ǯ��
		/*for(int i=3;i<=N;i++) {
			dp[i] = Math.max(dp[i-2], dp[i-3] + arr[i-1]) + arr[i];
		}*/
		
		System.out.println(dp(N));
		
	}
	public static int dp(int n) {
		// �� ĭ ��(n - 2)�� '�޸������̼� ��'�� ù ĭ ��(n - 1)�� �� + �� °ĭ ��(n - 3)�� '�޸������̼� ��' �� ū ���� ���� i ����� ���� ���Ͽ� DP�迭�� ����(Memoization)
		if(dp[n] == null) {
			dp[n] = Math.max(dp(n-2), arr[n-1]+dp(n-3)) + arr[n];
		}
		
		return dp[n];
		
	} 
	
}
		