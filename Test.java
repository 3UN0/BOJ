import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Test {
	public static int[][] arr;
	public static Integer[][] dp;	// 객체배열 -> int[] 배열은 0으로 초기화되므로 문제의 범위와 겹침-> 객체배열은 null로 초기화되므로 편함 (단:메모리 초과)
	public static int N;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];	// 삼각형 저장용 배열
		dp = new Integer[N][N];	// dp 합의 값 저장용 배열
		
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for(int j=0;j<i+1;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=0;i<N;i++) {	// dp 맨 마지막을 삼각형 배열과 똑같이 초기화 해줌
			dp[N-1][i] = arr[N-1][i];
		}
		System.out.println(dp(0, 0));
		
	}
	public static int dp(int depth, int idx) {
		// 맨 밑의 깊이(행)에 도달하면 해당 인덱스(열)반환
		if(depth == N-1) {
			return dp[depth][idx];
		}
		
		// 아직 탐색하지 않은 위치라면 다음 행의 항목 중 최댓값 구함 (밑 줄의 수 중에서 최댓값 구하기) -> 큰 값을 현재 현재 인덱스 값과 더하여 저장
		if(dp[depth][idx] == null) {
			dp[depth][idx] = Math.max(dp(depth+1, idx), dp(depth+1, idx+1)) + arr[depth][idx];
		}
		
		return dp[depth][idx];
		
	} 
	
}
		