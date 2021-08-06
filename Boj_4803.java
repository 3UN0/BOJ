import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_4803 {
	public static StringBuilder sb = new StringBuilder();
	public static ArrayList<ArrayList<Integer>> graph;
	public static boolean[] visit;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int testcase = 1;

		while(true) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());	// 정점
			int m = Integer.parseInt(st.nextToken());	// 간선
			
			if(n==0 && m==0) {
				break;
			}
			
			// 그래프 초기화
			graph = new ArrayList<>();
			for(int i=0;i<=n;i++) {
				graph.add(new ArrayList<>());
			}
			
			// 그래프 간선 입력
			for(int i=0;i<m;i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				graph.get(a).add(b);
				graph.get(b).add(a);
			}
			
			visit = new boolean[n+1];
			
			int count = 0;
			// 여러 트리 존재할 수 있음->모든 노드 검사
			for(int i=1;i<=n;i++) {
				if(!visit[i]) {
					count += Tree(i);
				}
			}
			
			if(count == 0) {
				sb.append("Case " + testcase++ + ": No trees.");
			} else if(count == 1) {
				sb.append("Case " + testcase++ + ": There is one tree.");
			} else {
				sb.append("Case " + testcase++ + ": A forest of " + count + " trees.");
			}
			sb.append("\n");
		}
		
		System.out.println(sb);
		
	}
	
	// 트리 맞는지 검사
	// 트리 -> 노드 개수 = 간선 개수 +1;
	// 양방향 간선 그래프 => 노드  = (간선/2)+1 => 트리
	public static int Tree(int start) {
		Queue<Integer> queue = new LinkedList<>();
		// 시작 노드 추가
		queue.add(start);
		int node = 0;
		int edge = 0;
		
		while(!queue.isEmpty()) {
			int now = queue.poll();
			// 노드 있으면 +1
			node += 1;
			visit[now] = true;
			
			for(int next : graph.get(now)) {
				// 그래프 현재 노드에서 연결된 간선 있으면
				edge += 1;
				if(!visit[next]) {
					queue.add(next);
				}
			}
		}
		// 트리 맞으면 1, 아니면 0
		return node == (edge/2) + 1 ? 1 : 0;
	}
	
}


