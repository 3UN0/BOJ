import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static int[][] arr;
	public static int N, count;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		arr = new int[N+1][2];
		
		// 상담 일수 , 금액
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}
		count = 0;
		dfs(0, 0);
		
		System.out.println(count);
	}
	
	public static void dfs(int day, int pay) {
		if(day >= N) {
			// 최대이익 계산
			count = Math.max(count, pay);
			return;
		}
		
		// day + 상담일수 <=N 이면, 계속 상담 가능
		if(day + arr[day][0] <= N) {
			dfs(day + arr[day][0], pay + arr[day][1]);
		}
		// > N 일 때, 상담 유지 (금액 추가x)
		else {
			dfs(day + arr[day][0], pay);
		}
		
		// 최대 이익 구해야 하므로 다른 경우의 수도 고려
		dfs(day + 1, pay);

	}
}
