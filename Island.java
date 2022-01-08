import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Test {
	public static int r, c, length, count;
	public static int[] dx = {-1, 1, 0, 0};
	public static int[] dy = {0, 0, -1, 1};
	public static int[][] map;
	public static boolean[][] visit;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		visit = new boolean[r][c];
		map = new int[r][c];
		
		for(int i=0;i<r;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<c;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=0;i<r;i++) {
			for(int j=0;j<c;j++) {
				if(!visit[i][j] && map[i][j] == 1) {
					dfs(i, j);
					count++;
				}
			}
		}
		
		System.out.println("섬의 개수 : "+count);
		System.out.println("섬 둘레의 합 : " + length);
		
	}

	public static void dfs(int x, int y) {
		// 사각형 기본 둘레 : 4
		length+=4;
		
		visit[x][y] = true;
		
		// 해당 사각형과 맞닿는 사각형 개수 저장
		int around = 0;
		for(int i=0;i<4;i++) {
			
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(nx>=0 && nx<r && ny>=0 && ny<c) {
				// 사각형 주위의 개수 (섬 둘레)
				if(map[nx][ny] == 1) { 
					around++;
				}
				// 이어지는 섬 (섬의 개수)
				if(!visit[nx][ny] && map[nx][ny] == 1) {
					dfs(nx, ny);
				}
			}
		}
		length -= around; 
	}
}
