import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_11066 {
	public static int[][] dp = new int[41][2];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		int[] arr;
		int[] sum;
		int[][] dp;
		StringTokenizer st;

		StringBuilder sb = new StringBuilder();
		for(int t=0;t<T;t++) {
			int K = Integer.parseInt(br.readLine());
			arr = new int[K+1];
			sum = new int[K+1];
            dp = new int[502][502];
			
			st = new StringTokenizer(br.readLine());
            for(int i = 1; i <= K; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
                sum[i] = sum[i-1]+ arr[i];
                // dp[i-1][i] = 0;
            }
            // dp[0][1] = 0; dp[1][1] = 0;
             
            for (int i = 2; i <= K; i++) {
              for (int j = i - 1; j > 0; j--) {
                  dp[j][i] = Integer.MAX_VALUE;
                  for (int k = j; k <= i; k++) {
                      dp[j][i] = Math.min(dp[j][i], dp[j][k] + dp[k + 1][i]);
                  }
                  dp[j][i] += sum[i] - sum[j - 1]; // 마지막에 전체 합을 한 번 더해준다.
              }
          }
          sb.append(dp[1][K]).append("\n");
            
		}
		System.out.println(sb);
		
	}
	
	
}
		