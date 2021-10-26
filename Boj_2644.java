import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static int N, M;
	public static boolean[] visit;
	public static int[][] map;
	public static int[] dis;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 전체 인원
		N = Integer.parseInt(br.readLine());
		
		map = new int[N+1][N+1];

		visit = new boolean[N+1];
		dis = new int[N+1];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int p1 = Integer.parseInt(st.nextToken());
		int p2 = Integer.parseInt(st.nextToken());
		
		M = Integer.parseInt(br.readLine());
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
				
			map[x][y] = 1;
			map[y][x] = 1;
		}
		
		bfs(p1, p2);
		
		if(dis[p2] == 0) {
			System.out.println(-1);
		} else {
			System.out.println(dis[p2]);
		}
		
		
	}
	
	// 인접행렬 -> bfs -> 큐 이용 / 인접리스트로도 가능 
	public static void bfs(int s, int e) {
		Queue<Integer> q = new LinkedList<Integer>();
		visit[s] = true;
		q.add(s);
		
		// 비었다는 것 = 연결 끝남 (끊김)
		while(!q.isEmpty()) {
			int now = q.poll();
			
			// 목적 노드 만나면 종료
			if(now == e) {
				break;
			}
			
			// 연결된 부분 찾기
			for(int i=1;i<=N;i++) {
				// !visit[i] -> 메모리 초과
				if(now != i && map[now][i] == 1 && dis[i] == 0) {
					q.add(i);
					// 거리 (촌수) 갱신
					dis[i] = dis[now] + 1;
				}
			}
		}
		
  }

}
