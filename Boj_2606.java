import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_2606 {
	public static int N, M, V, count;
	public static int[][] map;
	public static boolean[] visit;
	public static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());	// 컴퓨터 갯수 (노드)
		M = Integer.parseInt(br.readLine());	// 연결된 쌍 (간선)
		
		map = new int[N+1][N+1];
		
		// map 에 간선 초기화
		for(int i=0;i<M;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int s = Integer.parseInt(st.nextToken());	
			int e = Integer.parseInt(st.nextToken());
			map[s][e] = 1;
			map[e][s] = 1;
		}
		
		// 배열 초기화
		visit = new boolean[N+1];
		dfs(1);

		System.out.println(count - 1);
		
	}
	
	// 깊이 우선 탐색 (스택 / 재귀)
	public static void dfs(int start) {
		// 경로 노드 출력
		sb.append(start + " ");
		// 노드 방문 처리
		visit[start] = true;
		
		for(int i=1;i<=N;i++) {
			// map 내 간선 o , 미방문
			if(map[start][i] == 1 && !visit[i])
				dfs(i);
		}
		
		count++;
	}
	
}
		