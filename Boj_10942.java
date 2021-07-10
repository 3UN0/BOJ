import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_10942 {
	public static int M, N;
	public static int[] arr;
	public static Integer[][] dp;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		dp = new Integer[N][N];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		StringBuilder sb = new StringBuilder();
	
		M = Integer.parseInt(br.readLine());
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int S = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());
			sb.append(dp(S-1, E-1) + "\n");
		}
		System.out.println(sb);
	}
	
	public static int dp(int x, int y) {
		if(x >= y) {	// 길이 1 : x == y or 길이 2 
			return 1;
		}
		if(arr[x] != arr[y])
			return 0;

		if(dp[x][y] != null)
			return dp[x][y];
		
		dp[x][y] = dp(x+1, y-1);
		return dp[x][y];
	}
	
}
		