import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_7576 {
	public static int M, N;
	public static int[][] map;
	public static boolean[][] visit;
	public static int[] dx = {-1, 1, 0, 0};	// 상하좌우
	public static int[] dy = {0, 0, -1, 1};	// 상하좌우

	public static Queue<Coor> queue = new LinkedList<>();
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
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		visit = new boolean[N][M];
		
		// map에 해당 좌표 값 입력
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0;j<M;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				// 좌표값이 1인 모든 경우가 시작점 (익은 토마토가 있는 좌표)
				if(map[i][j] == 1) {
					// 익은 토마토가 있는 좌표 큐에 추가
					queue.add(new Coor(i, j));
				}
			}
		}

		bfs();

		// int day = Integer.MIN_VALUE;
		int day = 0;
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				// 익을 수 없는 토마토 존재하면(0이 있다면) -1 출력
				if(map[i][j] == 0) {
					System.out.println("-1");
					System.exit(0);
				}
				// 0 이 없다면 제일 큰 수 저장
				else {
					day = Math.max(day, map[i][j]);
				}
			}
		}
		
		// 걸린 일수 : 최대값-1 (처음 1에서 시작하므로)
		System.out.println(day - 1);

	}

	
	// 너비 우선 탐색 (큐)
	public static void bfs() {
		
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
					// 좌표값이 0인 경우 (익지 않은 토마토를 향해) , 미방문
					if(map[nx][ny] == 0 && !visit[nx][ny]) {
						// 다음에 방문할 좌표 추가
						queue.add(new Coor(nx, ny));
						// 방문할 곳에 현재 위치의 map에 있던 값 (현재 일수) + 1 저장 -> 최대 일수 저장
						map[nx][ny] = map[coor.x][coor.y] + 1;
						// 다음 좌표 방문 처리
						visit[nx][ny] = true;	// 좌표 추가 밑에 써도 됨
					}
				}
			}
		}
	}
}
		