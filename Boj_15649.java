import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_15649 {
	public static int[] num;
	public static boolean[] visit;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			
		int N = Integer.parseInt(st.nextToken());	// 1~N까지의 자연수
		int M = Integer.parseInt(st.nextToken());	// M개 선택

		visit = new boolean[N];	// 수가 중복되지 않도록, 방문 표시
		num = new int[M];
		dfs(N, M, 0);
	}
	
		
	
	public static void dfs(int N, int M, int depth) {
		if(depth == M) {
			for(int val : num) {
				System.out.print(val + " ");
			}
			System.out.println();
			return;
		}
		
		for(int i=0;i<N;i++) {
			// 해당 값 방문x
			if(visit[i] == false) {
				visit[i] = true;	// 방문 상태로 변경
				num[depth] = i+1; 	// 해당 깊이를 index로 해서 i+1 저장
				dfs(N, M, depth+1);	// 다음 자식 노트 방문 위해 depth+1 -> 재귀 
				
				// 자식 노드 방문 끝나고 돌아오면 방문노드를 방문x 상태 변경
				visit[i] = false;
				
			}
		}
		return;
	}
		
}
		