import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_9095 {
	public static int[] dp = new int[12];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 4;
		
		for(int i=4;i<12;i++) {
			dp[i] = dp[i-3] + dp[i-2] + dp[i-1];
		}
		
		StringBuilder sb = new StringBuilder();
		
		for(int i=0;i<T;i++) {
			int n = Integer.parseInt(br.readLine());
			sb.append(dp[n] + "\n");
		}
		
		System.out.print(sb);
		
	}
}

