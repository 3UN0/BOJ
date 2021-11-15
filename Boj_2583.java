import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	public static int M;
	public static int N;
	public static int K;
	public static int[][] map;
	public static int count = 0;
	public static int[] dx = {-1, 1, 0, 0};
	public static int[] dy = {0, 0, -1, 1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		ArrayList<Integer> list = new ArrayList<>();
		
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		map = new int[M][N];
		
		for(int i=0;i<K;i++) {
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			
			for(int j=y1;j<y2;j++) {
				for(int k=x1;k<x2;k++) {
					map[j][k] = 1;
				}
			}
		}
		
		
		for(int i=0;i<M;i++) {
			for(int j=0;j<N;j++) {
				if(map[i][j] == 0) {
					count=0;
					dfs(i, j);
					list.add(count);
				}
			}
		}
		
		System.out.println(list.size());
		
		Collections.sort(list);
		
		for(Integer box : list) {
			System.out.print(box + " ");
		}
		
	}
	
	public static void dfs(int x, int y) {
		map[x][y] = 1;
		count++;
		
		for(int i=0;i<4;i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(nx>=0 && nx<M && ny>=0 && ny<N) {
				if(map[nx][ny] == 0) {
					dfs(nx, ny);
				}
			}
		
		}
		
	}
}
