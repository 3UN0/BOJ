import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_2178 {
	public static int M, N;
	public static int[][] map;
	public static boolean[][] visit;
	public static int[] dx = {-1, 1, 0, 0};	// 상하좌우
	public static int[] dy = {0, 0, -1, 1};	// 상하좌우

	public static class Coor{
		int x;
		int y;
		
		public Coor(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		visit = new boolean[N][M];
		
		// map에 해당 좌표 값 입력
		for(int i=0;i<N;i++) {
			String str = br.readLine();
			for(int j=0;j<M;j++) {
				map[i][j] = str.charAt(j) - '0';
			}
		}

		bfs(0,0);
		
		//(1, 1)~(N, M) 위치 -> 인덱스로는 (0,0)~(N-1, M-1)
		System.out.println(map[N-1][M-1]);
	}

	
	// 너비 우선 탐색 (큐)
	public static void bfs(int x, int y) {
		Queue<Coor> queue = new LinkedList<>();
		// 시작 좌표 추가
		queue.add(new Coor(x, y));
		
		// 큐에 값이 있으면
		while(!queue.isEmpty()) {
			// 현재 위치에 있는 값 저장
			Coor coor = queue.poll();
			for(int i=0;i<4;i++) {
				// 이동할 좌표로 변경
				int nx = coor.x + dx[i];
				int ny = coor.y + dy[i];
				
				// map 내에 존재
				if(nx >= 0 && ny >= 0 && nx < N && ny < M) {
				// map 내 값 o , 미방문
					if(map[nx][ny] == 1 && !visit[nx][ny]) {
						// 다음에 방문할 좌표 추가
						queue.add(new Coor(nx, ny));
						//방문할 곳에 직전 map에 있던 값 + 1 저장 -> 최소 비용 저장
						map[nx][ny] = map[coor.x][coor.y] + 1;
						// 다음 좌표 방문 처리
						visit[nx][ny] = true;	// 좌표 추가 밑에 써도 됨
					}
				}
			}
		}
	}
}
		