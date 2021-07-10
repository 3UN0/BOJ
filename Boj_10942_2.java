import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_10942_2 {
	public static int M, N;
	public static int[] arr;
	public static boolean[][] dp;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N+1];
		dp = new boolean[N+1][N+1];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i=1;i<=N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		StringBuilder sb = new StringBuilder();
		solve();
		M = Integer.parseInt(br.readLine());
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int S = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());
			
			if(dp[S][E]) sb.append("1\n");
	        else sb.append("0\n");
		}
		System.out.println(sb);
	}
		public static void solve() {
		// 길이가 1일때 계산
	    for(int i = 1; i <= N; i++)
	    	dp[i][i] = true;
	    // 길이가 2일때 계산
	    for(int i = 1; i <= N - 1; i++)
	    	if(arr[i] == arr[i + 1]) dp[i][i + 1]= true;

	    // 길이가 3 이상일 때
	    for(int i = 2; i < N; i++){
	    	for(int j = 1; j <= N - i; j++){
	    		if(arr[j] == arr[j + i] && dp[j + 1][j + i - 1])
	    			dp[j][j + i] = true;
	            }
	        }
	    }
	
}
		