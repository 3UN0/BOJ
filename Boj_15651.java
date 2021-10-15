 import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static int N, M;
	public static int[] num;
	public static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			
		N = Integer.parseInt(st.nextToken());	// 1~N까지의 자연수
		M = Integer.parseInt(st.nextToken());	// M개 선택

		num = new int[M];
		dfs(0);
		System.out.println(sb);
	}
	
	// 중복 순열
  // depth : 현재 수 (깊이)
	public static void dfs(int depth) {
		if(depth == M) {
			for(int i=0;i<M;i++) {
				sb.append(num[i] + " ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i=1;i<=N;i++) {
			// 현재 깊이를 index로 하여 해당 위치에 i값 저장
			num[depth]=i;
			
			// 현재보다 다음 위치 값이 더 커야함
			dfs(depth+1);
			
		}
		return;
	}
		
}
		
