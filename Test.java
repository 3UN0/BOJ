import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Test {
	public static int[][] arr;
	public static Integer[][] dp;	// ��ü�迭 -> int[] �迭�� 0���� �ʱ�ȭ�ǹǷ� ������ ������ ��ħ-> ��ü�迭�� null�� �ʱ�ȭ�ǹǷ� ���� (��:�޸� �ʰ�)
	public static int N;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];	// �ﰢ�� ����� �迭
		dp = new Integer[N][N];	// dp ���� �� ����� �迭
		
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for(int j=0;j<i+1;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=0;i<N;i++) {	// dp �� �������� �ﰢ�� �迭�� �Ȱ��� �ʱ�ȭ ����
			dp[N-1][i] = arr[N-1][i];
		}
		System.out.println(dp(0, 0));
		
	}
	public static int dp(int depth, int idx) {
		// �� ���� ����(��)�� �����ϸ� �ش� �ε���(��)��ȯ
		if(depth == N-1) {
			return dp[depth][idx];
		}
		
		// ���� Ž������ ���� ��ġ��� ���� ���� �׸� �� �ִ� ���� (�� ���� �� �߿��� �ִ� ���ϱ�) -> ū ���� ���� ���� �ε��� ���� ���Ͽ� ����
		if(dp[depth][idx] == null) {
			dp[depth][idx] = Math.max(dp(depth+1, idx), dp(depth+1, idx+1)) + arr[depth][idx];
		}
		
		return dp[depth][idx];
		
	} 
	
}
		