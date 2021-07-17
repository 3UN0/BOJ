import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_7562 {
	public static int A, B, N, M, I;
	public static int[][] map;
	public static boolean[][] visit;
	public static int[] dx = {-2, -2, -1, -1, 1, 1, 2, 2};	// 상하좌우
	public static int[] dy = {-1, 1, 2, -2, 2, -2, -1, 1};	// 상하좌우

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
		
		int T = Integer.parseInt(br.readLine());
		
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		// map에 해당 좌표 값 입력
		for(int t=0;t<T;t++) {
			I = Integer.parseInt(br.readLine());
			map = new int[I][I];
			visit = new boolean[I][I];
			
			// 시작점
			st = new StringTokenizer(br.readLine(), " ");
			A = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());
			
			// 도착점
			st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			sb.append(bfs(A,B) + "\n");
		}
		System.out.println(sb);

	}

	
	// 너비 우선 탐색 (큐)
	public static int bfs(int x, int y) {
		Queue<Coor> queue = new LinkedList<>();
		// 시작 좌표 추가
		queue.add(new Coor(x, y));
		visit[x][y] = true;
		
		// 큐에 값이 있으면
		while(!queue.isEmpty()) {
			// 현재 위치에 있는 값 저장
			Coor coor = queue.poll();
			if(coor.x == N && coor.y == M)
				return map[coor.x][coor.y];
			for(int i=0;i<8;i++) {
				// 이동할 좌표로 변경
				int nx = coor.x + dx[i];
				int ny = coor.y + dy[i];
				
				// map 내에 존재
				if(nx >= 0 && ny >= 0 && nx < I && ny < I) {
				// map 내 값 o , 미방문
					if(map[nx][ny] == 0 && !visit[nx][ny]) {
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
		return 0;
	}
}
		