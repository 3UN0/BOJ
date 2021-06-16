import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Boj_2565 {
	public static int[][] arr;
	public static Integer[] dp;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		arr = new int[N][2];
		dp = new Integer[N];	// 123 오름차순

		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr, new Comparator<int[]>(){
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[0] - o2[0];
			}
		});
		
		int max = 0;
		for(int i=0;i<N;i++) {
			max = Math.max(dp(i), max);
		}
		
		System.out.println(N-max);
		
	}
	
	public static int dp(int n) {
		if(dp[n] == null) {	
			dp[n]= 1; // 최솟값 1로 초기화
			
			for(int i=n+1;i<dp.length;i++) {
				// a에 연결되어 나온 n번째 전선이 b전봇대에 연결되었을 때,
				// a의 i번째 전선이 이전에 b전봇대에 연결한 것보다 뒤에 연결해야함 
				if(arr[n][1] < arr[i][1]) {
					dp[n] = Math.max(dp[n], dp(i)+1);
				}
				
			}
			
		}
		return dp[n];
	}
	
}
		