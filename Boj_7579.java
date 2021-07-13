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
		// 앱 메모리
		for(int i=0;i<N;i++) {
			arr[i][0] = Integer.parseInt(st.nextToken());	
		}
		// 앱 비활성화 비용
		st = new StringTokenizer(br.readLine(), " ");
		for(int i=0;i<N;i++) {
			arr[i][1] = Integer.parseInt(st.nextToken());	
			maxCost += arr[i][1];	// 비용의 최댓값
		}
		// dp[i][j] => i개의 앱으로 j만큼의 비용을 들여 확보할 수 있는 최대 사이즈
		dp = new long[N][maxCost+1];		// 비용의 최댓값까지만 dp 가능
		for(int i=0;i<N;i++) {
			int memory = arr[i][0];
			int cost = arr[i][1];
			
			for(int j=0;j<=maxCost;j++) {
				if(i == 0) {	// 앱 1개
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
		
		// N개의 앱으로 i원의 비용을 들였을 때 확보할 수 있는 메모리가 M이상일 때 출력
		for(int i=0;i<=maxCost;i++) {
			if(dp[N-1][i] >= M) {
				ans = i;
				System.out.println(ans);
				break;
			}
		}
		
	}
	
}
		