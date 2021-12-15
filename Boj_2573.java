import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Test {
	public static int N, M;
	public static int[][] map;
	public static int[] dx = {1, -1, 0, 0};
	public static int[] dy = {0, 0, -1, 1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// 행과 열
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				int num = Integer.parseInt(st.nextToken());
				map[i][j] = num;
			}
		}
		
		int year = 0;
		while(true) {
			int block = countIce();
			// 두 덩어리 이상으로 분리
			if(block >= 2) {
				break;
			} else if (block == 0){
				year = 0;
				break;
			}
			meltIce();
			year++;
		}
		
		System.out.println(year);
		
	}
	
	// 빙하 녹는 것 계산
	public static void meltIce(){
		Queue<IceNode> q = new LinkedList<>();
		// 원래 빙하였던 것 판별하기 위함
		boolean[][] check = new boolean[N][M];
		
		for(int i=1;i<N-1;i++) {
			for(int j=1;j<M-1;j++) {
				if(map[i][j] != 0) {
					q.offer(new IceNode(i, j));
					check[i][j] = true;
				}
			}
		}
		
		while(!q.isEmpty()) {
			int count = 0;
			IceNode ice = q.poll();
			
			for(int i=0;i<4;i++) {
				int nx = ice.x + dx[i];
				int ny = ice.y + dy[i];
				
				if(nx>=0 && nx<N && ny>=0 && ny<M) {
					if(!check[nx][ny] && map[nx][ny] == 0) {
						count++;
					}
				}
			}
			if(map[ice.x][ice.y] - count < 0) {
				map[ice.x][ice.y] = 0;
			} else {
				map[ice.x][ice.y] -= count;
			}
			
		}
		
		
	}
	
	
	// 빙하 분리 갯수
	public static int countIce() {
		boolean[][] visit = new boolean[N][M];
		int icount = 0;
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(!visit[i][j] && map[i][j] != 0) {
					dfs(i, j, visit);
					icount++;
				}
			}
		}
		return icount;
	}
	
	// 빙하 탐색
	public static void dfs(int x, int y, boolean[][] visit) {
		visit[x][y] = true;
		
		for(int i=0;i<4;i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(nx>=0 && nx<N && ny>=0 && ny<M) {
				if(map[nx][ny] != 0 && !visit[nx][ny]) {
					dfs(nx, ny, visit);
				}
			}
		}
	}
	
}

class IceNode{
	int x;
	int y;
	
	IceNode(int x, int y){
		this.x = x;
		this.y = y;
	}
}
