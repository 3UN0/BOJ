import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Boj_1967 {
	public static StringBuilder sb = new StringBuilder();
	public static boolean[] visit;
	public static ArrayList<Tree>[] list;
	public static int maxDis = 0;
	public static int maxNode = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());	// 노드 개수
		list = new ArrayList[n+1];
		for(int i=0;i<=n;i++) {
			list[i] = new ArrayList<Tree>();
		}
		
		StringTokenizer st;
		for(int i=0;i<n-1;i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int parent = Integer.parseInt(st.nextToken());	// 부모 노드
			int child = Integer.parseInt(st.nextToken());	// 자식 노드
			int weight = Integer.parseInt(st.nextToken());	// 가중치
			list[parent].add(new Tree(child, weight));
			list[child].add(new Tree(parent, weight));
		}
		// 루트 노드 1부터 가장 먼 노드 찾기->이 노드를 maxNode에 저장
		visit = new boolean[n+1];
		dfs(1, 0);
		// visit 배열 초기화 후, maxNode부터 가장 먼 정점까지의 거리 계산
		visit = new boolean[n+1];
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
			if(!visit[nd.child]) {
				dfs(nd.child, dis + nd.weight);
			}
		}
	}
	
	static class Tree{
		int child;
		int weight;
		
		public Tree(int child, int weight){
			this.child = child;
			this.weight = weight;
		}
	}
}

