import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static int[] arr;
	public static int S, count;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		arr = new int[N];
		
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=1;i<=N;i++) {
			int[] ans = new int[i];
			
			combi(ans, i, 0, 0);
		}

		System.out.println(count);
		
	}
	
	// 부분 수열 - 1, 2, 3 , 4 , 5 / 12, 13, 14, 15 ,... / 123, 124, ... /12345
	// 조합 이용
	public static void combi(int[] ans, int p, int cur, int start) {
		if(p == cur) {
			int sum = 0;
			for(int i=0;i<p;i++) {
				sum += ans[i];
			}
			if(sum == S) {
				count++;
			}
		} else {
			for(int i=start;i<arr.length;i++) {
				ans[cur] = arr[i];
				combi(ans, p, cur+1, i+1);
			}
		}
		
	}
}
