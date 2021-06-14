import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_1149 {
	public static int[][] cost;	// �� ������ ���
	public static int[][] dp;	// ������ ������ dp
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		cost = new int[N][3];
		dp = new int[N][3];
		
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for(int j=0;j<3;j++) {
				cost[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		// dp�� ù��° ���� �� ���� ����� ù��° ������ �ʱ�ȭ
		dp[0][0] = cost[0][0];	//RED
		dp[0][1] = cost[0][1];	//GREEN
		dp[0][2] = cost[0][2];	//BLUE
		
		
		System.out.println(Math.min(Paint(N-1, 0), Math.min(Paint(N-1, 1), Paint(N-1, 2))));
		
	}
	public static int Paint(int N, int color) {
		// Ž��x �迭
		if(dp[N][color] == 0) {
			// color �� ���� ���� ���� ���� �ٸ� ���� ���ȣ���Ͽ� �ּڰ�+���� �� ��� ����Ͽ� dp ����
/*			Red�� ���
			Cost[N][0] = min( Cost[N-1][1], Cost[N-1][2] ) + Cost[N][0]

			Green�� ���
			Cost[N][1] = min( Cost[N-1][0], Cost[N-1][2] ) + Cost[N][1]

			Blue�� ���
			Cost[N][2] = min( Cost[N-1][0], Cost[N-1][1] ) + Cost[N][2]
*/		
			
			if(color == 0) {	//RED
				return dp[N][0] = Math.min(Paint(N-1, 1), Paint(N-1, 2)) + cost[N][0];
			}
		
			else if(color == 1) {	//GREEN
				return dp[N][1] = Math.min(Paint(N-1, 0), Paint(N-1, 2)) + cost[N][1];
			}
		
			else if(color == 2) {	//BLUE
				return dp[N][2] = Math.min(Paint(N-1, 0), Paint(N-1, 1)) + cost[N][2];
			}
		}
		return dp[N][color];
	}
	
	
	
}
		