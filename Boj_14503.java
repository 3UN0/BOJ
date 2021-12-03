import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Test {
	public static int N, M, r, c, d;
	public static int[][] map;
	public static int count;
	public static int[] dx = {-1, 0, 1, 0};	// 북0 동1 남2 서3
	public static int[] dy = {0, -1, 0, 1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		
		st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		count = 0;
		
		dfs(r, c, d);
		
		System.out.println(count);
		
		
	}
	
	public static void dfs(int x, int y, int d) {
		// 1. 현재 위치 청소 (처음 시작점)
		if(map[x][y] == 0) {
			// 청소 o : 2, 벽 : 1 구분 
			map[x][y] = 2;
			count++;
		}
		
		// 2. 현재 위치(방향) 기준 왼쪽 방향부터 탐색
		boolean flag = false;
		
		for(int i=0;i<4;i++) {
			d = direction(d);
			int nx = x + dx[d];
			int ny = y + dy[d];
			
			// 청소 x 
			if(nx > 0 && nx < N && ny > 0 && ny < M) {
				if(map[nx][ny] == 0) {
					dfs(nx, ny, d);
					flag = true;
					break;
				}
			}
		}
		
		// 4방향 모두 청소 or 벽
		if(flag == false) {
			System.out.println("후진할때 현재 방향 : " +d);
			int nd = (d + 2) % 4;
			int nx = x + dx[nd];
			int ny = y + dy[nd];
			
			if(nx > 0 && nx < N && ny > 0 && ny < M) {
				// 청소한 곳(2)도 지나가도 됨 (벽만 아니면 됨)
				if(map[nx][ny] != 1) {
					dfs(nx, ny, d);
				}
			}
		}
		
	}
	public static int direction(int d) {
		// 북 -> 서 
		if(d == 0)
			return 3;
		
		// 동 -> 북
		else if(d == 1)
			return 0;
		
		// 남 -> 동
		else if(d == 2)
			return 1;
		
		// 서 -> 남 (d == 3)
		else
			return 2;
	}
	
	
}
