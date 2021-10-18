import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static int N, M, count;
	public static boolean[] visit;
	public static int[][] map;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N+1][N+1];
		visit = new boolean[N+1];
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			
			map[u][v] = 1;
			map[v][u] = 1;
			
		}
		
		
		for(int i=1;i<=N;i++) {
			if(!visit[i]) {
				dfs(i);
				count++;
			}
		}
		System.out.println(count);
		
	}
	
	public static void dfs(int x) {
		visit[x] = true; 
		
		for(int i=1;i<=N;i++) {
			
			if(x!=i && !visit[i] && map[x][i] == 1) {
				dfs(i);
			}
			
		}
		
	}
	
}
