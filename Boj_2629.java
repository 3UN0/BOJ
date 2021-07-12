import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_2629 {
	public static int M, N;
	public static int[] arr;
	public static int[] bell;
	public static boolean[][] dp;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N];	// ���� ���� (N�� ����)
		
		// dp[i][j] = i��° �߱��� �����Ͽ� ���԰� j�� ������ Ȯ���� �� �ִ��� (n���� �߸� �����Ͽ� ���� �� �ִ� ���̸� dp[] = true)
		dp = new boolean[N+1][15001];	// N���� ��, �� ���Դ� �ִ� 15000

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		
		// Ž�� ��� (������ ���ʿ� �ִٰ� ����)
		// 1. i��° �߸� �����ʿ� �ø��� (�߳��� ���� ��)
		// 2. i��° �߸� �ø��� �ʴ� ���
		// 3. i��° �߸� ���� �������� ���ʿ� �ø��� (������ �Բ� ������ ��) (���־��� �� / �ݴ��ʿ� ������ ��)

		dp(0, 0);	// �� �ø��� �ʾ��� ��, 0g���� ����
		
		StringBuilder sb = new StringBuilder();

		M = Integer.parseInt(br.readLine());	// ���� ����
		st = new StringTokenizer(br.readLine(), " ");
		for(int i=0;i<M;i++) {
			int ball = Integer.parseInt(st.nextToken());	// ���� ����
			
			if(ball > 15000) {	// �߷� �� �� �ִ� �ִ� ���Դ� 15000
				sb.append("N ");
			} else {
				if(dp[N][ball])		// ���� O	
					sb.append("Y ");
				else
					sb.append("N ");
			}
			
		}
		
		System.out.println(sb);
	}
	
	public static void dp(int idx, int w) {
		if(dp[idx][w])
			return;
		
		dp[idx][w] = true;	// ���� o
		
		if(idx == N)
			return;
		
		dp(idx+1, w + arr[idx]);			// �� ���� �� 
		dp(idx+1, w);						// �� �ø��� ���� ���
		dp(idx+1, Math.abs(w - arr[idx]));	// �߸� ������ �Բ� �÷��� �� (�ݴ���)
	}
	
}
		