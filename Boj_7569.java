import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_7569 {
	public static int M, N, H;
	public static int[][][] map;
	public static boolean[][][] visit;
	public static int[] dx = {0, 0, -1, 1, 0, 0};	// 위아래상하좌우
	public static int[] dy = {0, 0, 0, 0, -1, 1};	// 위아래상하좌우
	public static int[] dz = {1, -1, 0, 0, 0, 0,};	// 위아래상하좌우
	public static Queue<Coor> queue = new LinkedList<>();
	
	static class Coor{
		int x;
		int y;
		int h;
		
		public Coor(int x, int y, int h) {
			this.x = x;
			this.y = y;
			this.h = h;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		map = new int[N][M][H];
		visit = new boolean[N][M][H];
		
		// map에 해당 좌표 값 입력
		for(int h=0;h<H;h++) {
			for(int i=0;i<N;i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for(int j=0;j<M;j++) {
					map[i][j][h] = Integer.parseInt(st.nextToken());
					// 좌표값이 1인 모든 경우가 시작점 (익은 토마토가 있는 좌표)
					if(map[i][j][h] == 1) {
						// 익은 토마토가 있는 좌표 큐에 추가
						queue.add(new Coor(i, j, h));
					}
				}
			}
			
		}

		bfs();

		// int day = Integer.MIN_VALUE;
		int day = 0;
		for(int h=0;h<H;h++) {
			for(int i=0;i<N;i++) {
				for(int j=0;j<M;j++) {
					// 익을 수 없는 토마토 존재하면(0이 있다면) -1 출력
					if(map[i][j][h] == 0) {
						System.out.println("-1");
						System.exit(0);
					}
					// 0 이 없다면 제일 큰 수 저장
					else {
						day = Math.max(day, map[i][j][h]);
					}
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
			for(int i=0;i<6;i++) {
				// 이동할 좌표로 변경
				int nx = coor.x + dx[i];
				int ny = coor.y + dy[i];
				int nz = coor.h + dz[i];
				
				// map 내에 존재
				if(nx >= 0 && ny >= 0 && nz >= 0 && nx < N && ny < M && nz < H) {
					// 좌표값이 0인 경우 (익지 않은 토마토를 향해) , 미방문
					if(map[nx][ny][nz] == 0 && !visit[nx][ny][nz]) {
						// 다음에 방문할 좌표 추가
						queue.add(new Coor(nx, ny, nz));
						// 방문할 곳에 현재 위치의 map에 있던 값 (현재 일수) + 1 저장 -> 최대 일수 저장
						map[nx][ny][nz] = map[coor.x][coor.y][coor.h] + 1;
						// 다음 좌표 방문 처리
						visit[nx][ny][nz] = true;	// 좌표 추가 밑에 써도 됨
					}
				}
			}
		}
	}
}
		