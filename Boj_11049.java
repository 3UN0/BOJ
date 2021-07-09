import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_11049 {
	public static int[][] dp = new int[41][2];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int[][] arr = new int[N][2];		
		int[][] dp = new int[N][N];
		StringTokenizer st;
	
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			arr[i][0] = r;
			arr[i][1] = c;
		}
		
		for(int i=0;i<N-1;i++) {
			dp[i][i+1] = arr[i][0] * arr[i][1] * arr[i+1][1];
		}
		
		for(int j=2;j<N;j++) {
			for(int i=0;i+j<N;i++) {
				for(int k=i;k<i+j;k++) {
					if(dp[i][i+j] == 0) {
						dp[i][i+j] = dp[i][k] + dp[k+1][i+j] + (arr[i][0] * arr[k+1][0] * arr[i+j][1]);
					} else {	// arr[k+1][0] == arr[k][1]
						dp[i][i+j] = Math.min(dp[i][i+j], dp[i][k] + dp[k+1][i+j] + (arr[i][0] * arr[k+1][0] * arr[i+j][1]));
					}
				}
			}
		}

        System.out.println(dp[0][N - 1]);
		
	}
	
	
}
		