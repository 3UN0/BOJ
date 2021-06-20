import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_11050 {
	public static int[][] dp;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		dp = new int[N+1][K+1];
		
		System.out.println(bino(N, K));
		
	}
	
	// 1. ���丮��
	public static int factorial(int n) {
		if(n == 0) {
			return 1;
		}
		return n * factorial(n-1);
	}
	
	// 2. ���װ�� ���� �̿� 
	public static int bino(int n, int k) {
		if(k==0 || n == k) {
			return 1;
		}
		return bino(n-1, k-1) + bino(n-1, k);
	}
	
	// 3. ������ȹ��
	public static int binodp(int n, int k) {
		// �̹� Ǯ���� �� ���� ��� ��Ȱ��
		if(dp[n][k] > 0) {
			return dp[n][k];
		}
		if(n == k || k == 0) {
			return dp[n][k] = 1;
		}
		
		return dp[n][k] = binodp(n-1, k-1) + binodp(n-1, k);
	}
}
