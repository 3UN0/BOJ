import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_1707 {
	public static int K, V, E;
	public static int[] number;
	public static ArrayList<ArrayList<Integer>> graph;
	// 0번째 리스트에 정점 1과 인접한 정점들의 번호가 입력됨 ... 
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int K = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		// map에 해당 좌표 값 입력
		for(int t=0;t<K;t++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			V = Integer.parseInt(st.nextToken());	// 정점의 개수
			E = Integer.parseInt(st.nextToken());	// 간선의 개수
			number = new int[V+1];	// 1~V 까지므로
			
			graph = new ArrayList<>();
			for(int i=0;i<=V;i++) {
				graph.add(new ArrayList<>());
			}
			
			for(int i=0;i<E;i++) {
				st = new StringTokenizer(br.readLine(), " ");
				// 간선 정보
				int a = Integer.parseInt(st.nextToken());	
				int b = Integer.parseInt(st.nextToken());	
				graph.get(a).add(b);
				graph.get(b).add(a);
			}
			boolean flag = true;
			
			// 연결그래프가 아닐 수도 있으므로 탐색하지 않은 모든 노드 탐색
			for(int i=1;i<=V;i++) {
				if(number[i] == 0) {	// 방문 x
					// 인접한 노드들로 이분그래프 만들지 못하면
					// 다른 노드 탐색할 필요 x
					if(!bfs(i)) {
						flag = false;
						break;
					}
				}
			}
			
			if(flag) {
				sb.append("YES\n");
			} else {
				sb.append("NO\n");
			}
			
		}
		System.out.println(sb);

	}
	
	// 너비 우선 탐색 (큐)
	public static boolean bfs(int start) {
		Queue<Integer> queue = new LinkedList<>();
		// 시작 좌표 추가
		queue.add(start);
		// 방문 표시
		number[start] = 1;
		
		// 큐에 값이 있으면
		while(!queue.isEmpty()) {
			// 현재 위치에 있는 값 저장
			int now = queue.poll();
			for(int next : graph.get(now)) {
				// 1-2-3 처럼 연결되어 있다면 1-2-1 처럼 번호를 매김
				// 미방문 -> 현재 노드와 비교하여 다음 노드의 번호 매김 (자신과 다른 번호)
				if(number[next] == 0) {
					// 다음에 방문할 좌표 추가
					queue.add(next);
					if(number[now] == 1)
						number[next] = 2;
					else
						number[next] = 1;
				}
				// 다음 노드와 현재 노드 번호 같다면 이분그래프 x
				if(number[now] == number[next])
					return false;
			}
		}
		return true;
	}
}