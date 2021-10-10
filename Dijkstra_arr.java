import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Dijkstra_arr {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 노드
		int v = Integer.parseInt(br.readLine());
		// 간선
		int e = Integer.parseInt(br.readLine());

		// 최단거리 저장
		int[] dis = new int[v];
		// 방문 배열
		boolean[] visit = new boolean[v];
		// 노드, 간선 정보 저장
		int[][] map = new int[v][v];
		
		for(int i=0;i<e;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			
			map[x][y] = cost;
		}
		// 최단거리 전체 초기화
		Arrays.fill(dis, Integer.MAX_VALUE);
		// 시작 노드 0으로 초기화
		dis[0] = 0;

		for(int i=0;i<v-1;i++) {
			int min = Integer.MAX_VALUE;
			int index = -1;
			for(int j=0;j<v;j++) {
				// 아직 방문x, 가장 짧은 거리 (최단거리)
				if(!visit[j] && min > dis[j]) {
					// 해당 노드에서 연결된 다른 노드 찾기
					index = j;
					min = dis[j];
				}
			}
			
			for(int j=0;j<v;j++) {
				// 아직 방문 x, 경로o, index까지의 거리 + index부터 연결된 노드까지의 거리가 현재 입력된 dis 보다 작으면
				if(!visit[j] && map[index][j] !=0 && dis[index] != Integer.MAX_VALUE 
						&& dis[j] > dis[index] + map[index][j]) {
					dis[j] = dis[index] + map[index][j];
				}
			}
			// 방문 완료 (연결된 노드 다 방문하면)
			visit[index] = true;
		}
		System.out.println(Arrays.toString(dis));
	}
	
}
