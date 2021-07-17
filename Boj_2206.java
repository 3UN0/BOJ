import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_2206 {
	public static int N, M, answer;
	public static int[][] map;
	public static int[][] visit;	// 벽 뚫는 횟수 (공사횟수)
	public static int[] dx = {-1, 1, 0, 0};	// 상하좌우
	public static int[] dy = {0, 0, -1, 1};	// 상하좌우

	static class Coor{
		int x;
		int y;
		int dis;	// 이동거리
		int check;	// 벽 뚫는 횟수
		
		public Coor(int x, int y, int dis, int check) {
			this.x = x;
			this.y = y;
			this.dis = dis;
			this.check = check;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		visit = new int[N][M];
		
		// map에 집의 수 입력
		for(int i=0;i<N;i++) {
			String[] str2 = br.readLine().split("");
			//String str = br.readLine();	// 문자열로 입력 받음
			for(int j=0;j<M;j++) {
				map[i][j] = Integer.parseInt(str2[j]);
				//map[i][j] = str.charAt(j) - '0';	// 문자열 숫자로 변환
				visit[i][j] = Integer.MAX_VALUE;	// 최댓값으로 초기화
			}
		}
		
		answer = Integer.MAX_VALUE;
		
		bfs(0,0);
		if(answer == Integer.MAX_VALUE)
			System.out.println(-1);
		else
			System.out.println(answer);
	}

	
	// 너비 우선 탐색 (큐)
	public static void bfs(int x, int y) {
		// 이동거리 증가시키고, 벽 뚫는 횟수를 함께 입력하여 성립할 때만 노드 추가
		Queue<Coor> queue = new LinkedList<>();
		// 시작 노드 추가 (dis -> 처음 칸도 포함하여 이동거리 계산하므로)
		queue.add(new Coor(x, y, 1, 0));
		// 처음 벽 뚫는 횟수
		visit[x][y] = 0;
		
		// 큐에 값이 있으면
		while(!queue.isEmpty()) {
			// 현재 위치에 있는 값 저장
			Coor co = queue.poll();
			// 좌표 (N, M)에 도착하면 이동거리 return 
			if(co.x == N-1 && co.y == M-1) {
				answer = co.dis;
				break;
			}
			
			for(int i=0;i<4;i++) {
				// 이동할 좌표로 변경
				int nx = co.x + dx[i];
				int ny = co.y + dy[i];
				// map 내에 존재
				if (nx >= 0 && ny >= 0 && nx < N && ny < M){
					// map[nx][ny] == 0 -> 지나갈 수 있는 곳
					// 다음에 나올 공사횟수 값이 기존 값보다 크면 (현재 있는 곳 벽 부신 횟수=0 or 미방문(최댓값))
					// => 이동거리 증가 
					if(map[nx][ny] == 0 && co.check < visit[nx][ny]) {
		                // 다음에 방문할 좌표 추가
						visit[nx][ny] = co.check;	// 공사횟수 그대로
						queue.add(new Coor(nx, ny, co.dis+1, co.check));
					}
					// map[nx][ny] == 1 -> 벽
					// 현재 공사횟수 0일 때 (이전에 공사 x)
					// => 이동거리, 공사횟수 증가
					else if (map[nx][ny] == 1 && co.check == 0 ){
						visit[nx][ny] = co.check+1;	// 공사횟수 증가
						queue.add(new Coor(nx, ny, co.dis+1, co.check+1));
					}
				}
			}
		}
	}
	
}
		