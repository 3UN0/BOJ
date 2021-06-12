import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_14888 {
	public static int N;
	public static int[] arr;
	public static int[] operator = new int[4];
	public static int maxnum = Integer.MIN_VALUE;
	public static int minnum = Integer.MAX_VALUE;
	
	public static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
		N = Integer.parseInt(br.readLine());	// 1~N까지의 자연수
		arr = new int[N];
		
		// 숫자
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		// 연산자
		st = new StringTokenizer(br.readLine(), " ");
		for(int i=0;i<4;i++) {
			operator[i] = Integer.parseInt(st.nextToken());
		}
		
		dfs(arr[0], 1);	// 처음 숫자, 다음 숫자->인덱스 (숫자 정해져있고 순서 변하지 않으므로)
		
		System.out.println(maxnum);
		System.out.println(minnum);
	}
	
		
	public static void dfs(int num, int depth) {
		// depth : 인덱스이자 깊이 (모든 연산자 사용함)
		if(depth == N) {
			maxnum = Math.max(maxnum, num);
			minnum = Math.min(minnum, num);
			return;
		}
		
		for(int i=0;i<4;i++) {
			// 연산자 개수가 1 이상인 경우
			if(operator[i] > 0) {
				operator[i]--; // 해당 연산자 1 감소 (방문)
				
				switch(i) {
				
				case 0 : dfs(num + arr[depth], depth+1 ); break;
				case 1 : dfs(num - arr[depth], depth+1 ); break;
				case 2 : dfs(num * arr[depth], depth+1 ); break;
				case 3 : dfs(num / arr[depth], depth+1 ); break;
				
				}
				// 재귀호출 종료 후 해당 연산자 개수 복구
				operator[i]++;
			}
			
		}
	}

}
		