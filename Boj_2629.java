import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_2629 {
	public static int M, N;
	public static int[] arr;
	public static int[] bell;
	public static boolean[][] dp;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N];	// 추의 무개 (N개 무게)
		
		// dp[i][j] = i번째 추까지 포함하여 무게가 j인 구술을 확인할 수 있는지 (n개의 추를 조합하여 만들 수 있는 값이면 dp[] = true)
		dp = new boolean[N+1][15001];	// N개의 추, 추 무게는 최대 15000

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		
		// 탐색 방법 (구슬이 왼쪽에 있다고 가정)
		// 1. i번째 추를 오른쪽에 올린다 (추끼리 더할 때)
		// 2. i번째 추를 올리지 않는 경우
		// 3. i번째 추를 빼고 나머지는 한쪽에 올린다 (구슬과 함께 놓았을 때) (빼주었을 때 / 반대쪽에 놓았을 때)

		dp(0, 0);	// 추 올리지 않았을 때, 0g부터 시작
		
		StringBuilder sb = new StringBuilder();

		M = Integer.parseInt(br.readLine());	// 구슬 갯수
		st = new StringTokenizer(br.readLine(), " ");
		for(int i=0;i<M;i++) {
			int ball = Integer.parseInt(st.nextToken());	// 구슬 무게
			
			if(ball > 15000) {	// 추로 잴 수 있는 최대 무게는 15000
				sb.append("N ");
			} else {
				if(dp[N][ball])		// 연산 O	
					sb.append("Y ");
				else
					sb.append("N ");
			}
			
		}
		
		System.out.println(sb);
	}
	
	public static void dp(int idx, int w) {
		if(dp[idx][w])
			return;
		
		dp[idx][w] = true;	// 연산 o
		
		if(idx == N)
			return;
		
		dp(idx+1, w + arr[idx]);			// 추 무게 합 
		dp(idx+1, w);						// 추 올리지 않은 경우
		dp(idx+1, Math.abs(w - arr[idx]));	// 추를 구슬과 함께 올렸을 때 (반대쪽)
	}
	
}
		