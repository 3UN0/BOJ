import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static int N, count, no_count;
	public static boolean[][] visit;
	public static char[][] map;
	public static int[] dx = {0, 0, -1, 1};
	public static int[] dy = {1, -1, 0, 0};
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		map = new char[N+1][N+1];
		visit = new boolean[N+1][N+1];
		
		// map에 색깔 저장
		for(int i=0;i<N;i++) {
			String str = br.readLine();
			for(int j=0;j<N;j++) {
				map[i][j] = str.charAt(j);
			}
		}
		
		// 적록색맹 x -> 현재 색과 새로운 좌표에 있는 색이 같은지 판별
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(!visit[i][j]) {
					dfs(i, j);
					// 구역의 갯수
					count++;
				}
			}
		}
		// 초기화
		visit = new boolean[N+1][N+1];
		
		// 적록색맹 o
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(!visit[i][j]) {
					no_dfs(i, j);
					// 구역의 갯수
					no_count++;
				}
			}
		}
		System.out.println(count +" "+no_count);
	}
	
	// 적록색약 x
	public static void dfs(int x, int y) {
		visit[x][y] = true; 
		// 현재 색깔
		char color = map[x][y];
		
		for(int i=0;i<4;i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(nx >= 0 && nx <= N && ny >= 0 && ny <= N) {
				if(!visit[nx][ny] && map[nx][ny] == color) {
					dfs(nx, ny);
				}
				
			}
			
		}
	}
	
	// 적록색약 o
	public static void no_dfs(int x, int y) {
		visit[x][y] = true; 
		// 현재 색깔
		char color = map[x][y];
		
		for(int i=0;i<4;i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(nx >= 0 && nx <= N && ny >= 0 && ny <= N) {
				
				if(!visit[nx][ny] && map[nx][ny] == color) {
					no_dfs(nx, ny);
				}
				
				else if(!visit[nx][ny] && 
						((color == 'R' && map[nx][ny] == 'G') || (color =='G' && map[nx][ny]=='R'))) {
					no_dfs(nx, ny);
				}
				
			}
			
		}
	}
	
}
