import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_1260 {
	public static int N, M, V;
	public static int[][] map;
	public static boolean[] visit;
	public static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());
		
		map = new int[N+1][N+1];
		
		// map 에 간선 초기화
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int s = Integer.parseInt(st.nextToken());	
			int e = Integer.parseInt(st.nextToken());
			map[s][e] = 1;
			map[e][s] = 1;
		}
		
		// 배열 초기화
		visit = new boolean[N+1];
		dfs(V);
		
		sb.append("\n");
		
		// 배열 초기화하기 위해서 다시 선언
		visit = new boolean[N+1];
		bfs(V);

		System.out.println(sb);
		
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
		
	}
	
	// 너비 우선 탐색 (큐)
	public static void bfs(int start) {
		Queue<Integer> queue = new LinkedList<>();
		// 시작 노드 추가
		queue.add(start);
		// 노드 방문 처리
		visit[start] = true;
		
		// 큐에 값이 있으면
		while(!queue.isEmpty()) {
			int num = queue.poll();
			// 경로 노드 출력
			sb.append(num + " ");
			
			for(int i=1;i<=N;i++) {
				// map 내 간선 o , 미방문
				if(map[num][i] == 1 && !visit[i]) {
					// 노드 추가
					queue.add(i);
					// 노드 방문 처리
					visit[i] = true;
				}
			}
			
		}
	}
	
}
		