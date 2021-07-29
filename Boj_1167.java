import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Boj_1167 {
	public static StringBuilder sb = new StringBuilder();
	public static boolean[] visit;
	public static ArrayList<Tree>[] list;
	public static int maxDis;
	public static int maxNode;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int V = Integer.parseInt(br.readLine());
		list = new ArrayList[V+1];
		for(int i=1;i<=V;i++) {
			list[i] = new ArrayList<Tree>();
		}
		
		StringTokenizer st;
		for(int i=0;i<V;i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int node = Integer.parseInt(st.nextToken());	// 정점 번호 (1~V)
			
			while(true) {
				int next = Integer.parseInt(st.nextToken());	// V정점에서 향하는 정점
				if(next == -1)
					break;
				int dis = Integer.parseInt(st.nextToken());	// 향하는 정점까지의 거리
				list[node].add(new Tree(next, dis));
			}
		}
		// 루트 노드 1부터 가장 먼 노드 찾기->이 노드를 maxNode에 저장
		visit = new boolean[V+1];
		dfs(1, 0);

		// visit 배열 초기화 후, maxNode부터 가장 먼 정점까지의 거리 계산
		visit = new boolean[V+1];
		dfs(maxNode, 0);

		System.out.println(maxDis);
		
	}
	
	public static void dfs(int v, int dis) {
		// 노드 방문 처리
		visit[v] = true;
		
		// 현재 노드의 거리가  max 보다 크다면 현재 노드 거리 저장
		if(dis > maxDis) {
			maxDis = dis;
			maxNode = v;
		}
		
		for(Tree nd : list[v]) {
			// 미방문한 경우
			if(!visit[nd.next]) {
				dfs(nd.next, dis + nd.dis);
			}
		}
	}
	
	static class Tree{
		int next;
		int dis;
		
		Tree(int next, int dis){
			this.next = next;
			this.dis = dis;
		}
	}
}

