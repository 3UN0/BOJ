import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_1520 {
	public static int M, N;
	public static int[][] arr;
	public static int[][] dp;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		M = Integer.parseInt(st.nextToken());	// ����
		N = Integer.parseInt(st.nextToken());	// ����
		arr = new int[M][N];		
		dp = new int[M][N];	// ���� ���������� �� �� �ִ� ����� ��
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0;j<N;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());	
				dp[i][j] = -1;
			}
		}
		System.out.println(dp(0, 0));
	
	}
	// �������� �����ϸ� 1, �湮�� ��� 0, ���� x -1
	public static int dp(int x, int y) {
		if(x==M-1 && y==N-1 ) {
			return 1;
		}
		// �湮�� �� ������
		if(dp[x][y] == -1) {
			// �湮 ǥ��
			dp[x][y] = 0;
			// �� : x-1>=0, arr[x-1, y]
			if(x>0 && arr[x][y] > arr[x-1][y])
				dp[x][y] += dp(x-1, y);
			// �� : x+1<m, arr[x+1, y] 
			if(x<M-1 && arr[x][y] > arr[x+1][y])
				dp[x][y] += dp(x+1, y);
			// �� : y-1>=0, arr[x][y-1]
			if(y>0 && arr[x][y] > arr[x][y-1])
				dp[x][y] += dp(x, y-1);
			// �� : y+1<n, arr[x][y+1]
			if(y<N-1 && arr[x][y] > arr[x][y+1])
				dp[x][y] += dp(x, y+1);
		} 
		
		return dp[x][y];
		
	}
	
	
}
		