import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_9461 {
	public static long[] dp = new long[101]; // 100 정도 되면 int형 범위를 넘어가므로 long 타입!!
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();
		dp[0] = 0;
		dp[1] = dp[2] = dp[3] = 1;
		dp[4] = 2;
		
		for(int i=5;i<dp.length;i++) {
			dp[i] = -1;
		}
		
		for(int i=0;i<T;i++) {
			int N = Integer.parseInt(br.readLine());
			P(N);
			sb.append(dp[N]+"\n");
		}
		
		System.out.println(sb);
		
	}
	public static long P(int n) {
		if(dp[n] == -1) {
			dp[n] = (P(n-1) + P(n-5));
		}
		return dp[n];
	}
	
	
	
}
		