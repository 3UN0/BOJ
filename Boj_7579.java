import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_7579 {
	public static int N, M, maxCost, ans;
	public static int[][]  arr;
	public static long[][] dp;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][2];
		
		st = new StringTokenizer(br.readLine(), " ");
		// �� �޸�
		for(int i=0;i<N;i++) {
			arr[i][0] = Integer.parseInt(st.nextToken());	
		}
		// �� ��Ȱ��ȭ ���
		st = new StringTokenizer(br.readLine(), " ");
		for(int i=0;i<N;i++) {
			arr[i][1] = Integer.parseInt(st.nextToken());	
			maxCost += arr[i][1];	// ����� �ִ�
		}
		// dp[i][j] => i���� ������ j��ŭ�� ����� �鿩 Ȯ���� �� �ִ� �ִ� ������
		dp = new long[N][maxCost+1];		// ����� �ִ񰪱����� dp ����
		for(int i=0;i<N;i++) {
			int memory = arr[i][0];
			int cost = arr[i][1];
			
			for(int j=0;j<=maxCost;j++) {
				if(i == 0) {	// �� 1��
					if(j >= cost )
						dp[i][j] = memory;
				} else {
					if(j >= cost) {
						dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-cost] + memory);
					} else {
						dp[i][j] = dp[i-1][j];
					}
				}
			}
		}

		ans = Integer.MAX_VALUE;
		
		// N���� ������ i���� ����� �鿴�� �� Ȯ���� �� �ִ� �޸𸮰� M�̻��� �� ���
		for(int i=0;i<=maxCost;i++) {
			if(dp[N-1][i] >= M) {
				ans = i;
				System.out.println(ans);
				break;
			}
		}
		
	}
	
}
		