import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static int w, h, count;
	public static int[] dx= {-1, 1, 0, 0, -1, 1, -1, 1};
	public static int[] dy= {0, 0, -1, 1, 1, 1, -1, -1};
	public static int[][] map;
	public static boolean[][] visit;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		while(true) {
			
			StringTokenizer st = new StringTokenizer(br.readLine());

			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			
			if(w==0 && h==0) {
				break;
			}
			
			map = new int[h][w];
			visit = new boolean[h][w];
			
			for(int i=0;i<h;i++) {
				st = new StringTokenizer(br.readLine());
				
				for(int j=0;j<w;j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			count = 0;
			
			for(int i=0;i<h;i++) {
				for(int j=0;j<w;j++) {
					// island 함수 실행 -> count++
					if(map[i][j] == 1 && !visit[i][j]) {
						island(i, j);
						count++;
					}
				}
			}
			
			System.out.println(count);
		}
		
	}
	
	public static void island(int x, int y) {
		visit[x][y] = true;
		
		for(int i=0;i<8;i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(nx>=0 && nx<h && ny>=0 && ny<w) {
				if(map[nx][ny] == 1 && !visit[nx][ny]) {
					island(nx, ny);
				}
			}
			
		}
	}
	
}
