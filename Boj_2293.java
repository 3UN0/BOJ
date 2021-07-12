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
			arr[i] = Integer.parseInt(br.readLine());	// ���� 1, 2, 5
		}
		// dp[i][j]	=> i���� ������ ������ ����Ͽ� j���� ����
		dp = new int[N+1][K+1];   // ���� 1��, 1�� ���� �����
		
		dp[0][0] = 1;	// dp[N][K]�� �� -> ù��° ����(1��)���� 0���� ����� ����� �� : 1
		
		for(int i=1;i<=N;i++) {
			for(int j=0;j<=K;j++) {
				// i���� ������ j������ Ŭ ��� (cf.5�� ¥�� ������ j=5 �� �� ��� Ƚ�� ����)
				if(arr[i] > j)
					dp[i][j] = dp[i-1][j];
				else
					dp[i][j] = dp[i-1][j] + dp[i][j-arr[i]];
			}
		}
		System.out.println(dp[N][K]);
	}
	
}
		