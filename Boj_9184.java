import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_9184 {
	public static StringBuilder sb = new StringBuilder();
	public static int[][][] dp = new int[21][21][21];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			
			if(A == -1 && B == -1 && C == -1) {
				break;
			}
			
			sb.append("w(" + A + ", " + B + ", " + C + ") = " + dp(A, B, C) + "\n");
		}
		
		
		System.out.println(sb);
	}
	
	public static int dp(int a, int b, int c) {
		if (a <= 0 || b <= 0 || c <= 0)
			return 1;

		if (a > 20 || b > 20 || c > 20)
			return dp(20, 20, 20);

		if(dp[a][b][c] != 0)
			return dp[a][b][c];
		
		if (a < b && b < c)
			return dp[a][b][c] = dp(a, b, c-1) + dp(a, b-1, c-1) - dp(a, b-1, c);

		return dp[a][b][c] = dp(a-1, b, c) + dp(a-1, b-1, c) + dp(a-1, b, c-1) - dp(a-1, b-1, c-1);
	}
}
