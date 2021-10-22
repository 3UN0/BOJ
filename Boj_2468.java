import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static int N, count;
	public static boolean[][] visit;
	public static int[][] map, tempMap;
	public static int[] dx = {0, 0, -1, 1};
	public static int[] dy = {1, -1, 0, 0};
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		map = new int[N][N];

		// 모든 지역 1일 경우 답은 1 (최소값 1)
		int max = 1;
		
		// map 에 입력
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for(int j=0;j<N;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
	
	
		for(int i=1;i<101;i++) {
			// 모든 숫자마다 방문 초기화
			visit = new boolean[N][N];
			
			// 1, 0 으로 해당 높이 이상인지 아닌지 판별하는 맵
			tempMap = new int[N][N];
			
			// 안전지대 갯수 초기화
			count=0;
			
			// i 높이 수에 따라 1, 0 판별
			for(int x=0;x<N;x++) {
				for(int y=0;y<N;y++) {
					if(map[x][y] <= i) {
						tempMap[x][y] = 0;
					} else
						tempMap[x][y] = 1;
				}
			}
			
			for(int j=0;j<N;j++) {
				for(int k=0;k<N;k++) {
					if(tempMap[j][k] == 1 && !visit[j][k]) {
						dfs(j, k);
						count++;
					}
				}
			}
			max = Math.max(max, count);
		}
		
		System.out.println(max);
		
	}
	
	public static void dfs(int x, int y) {
		visit[x][y] = true;
		
		for(int i=0;i<4;i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(nx >= 0 && nx < N && ny >= 0 && ny < N) {
				if(tempMap[nx][ny] == 1 && !visit[nx][ny]) {
					dfs(nx, ny);
				}
			}
		}
		
	}
}
