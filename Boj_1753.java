import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Boj_1753 {
	public static int K, V, E;
	public static int[] dis;	// 최단거리 저장
	public static boolean[] visit;	// 방문
	public static ArrayList<Node>[] list;
	// 0번째 리스트에 정점 1과 인접한 정점들의 번호가 입력됨 ... 
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		V = Integer.parseInt(st.nextToken());	// 정점의 개수
		E = Integer.parseInt(st.nextToken());	// 간선의 개수
		K = Integer.parseInt(br.readLine());

		dis = new int[V+1];	// 1~V 까지므로	
		list = new ArrayList[V+1];	// 1~V 까지므로
		visit = new boolean[V+1];	// 1~V 까지
		Arrays.fill(dis, Integer.MAX_VALUE);	// dis 배열 일괄 초기화
		
		for(int i=1;i<=V;i++) {
			list[i] = new ArrayList<Node>();
		}

		for(int i=0;i<E;i++) {
			st = new StringTokenizer(br.readLine(), " ");
			// 간선 정보
			int u = Integer.parseInt(st.nextToken());	// start
			int v = Integer.parseInt(st.nextToken());	// end
			int w = Integer.parseInt(st.nextToken());	// weight
			
			list[u].add(new Node(v, w));
		}
		
		StringBuilder sb = new StringBuilder();
		
		dijkstra(K);
		
		for(int i=1;i<=V;i++) {
			if(dis[i] == Integer.MAX_VALUE) {
				sb.append("INF\n");
			} else {
				sb.append(dis[i] + "\n");
			}
		}

		System.out.println(sb);

	}
	
	// 다익스트라 알고리즘
	// 현재 연결된 노드에서 이어진 모든 곳 일단 방문하여 거리 계산하여 저장 후
	// 새로운 노드와 새로운 간선들이 추가되면 도달할 수 있는 최단거리 다시 계산하여 거리 저장
	public static void dijkstra(int start) {
		// 가중치 적은 순서대로 저장하기 위해서 우선순위 큐 사용
		PriorityQueue<Node> queue = new PriorityQueue<Node>();
		// 시작 좌표 추가
		queue.add(new Node(start, 0));
		// 최단 거리 입력
		dis[start] = 0;
		
		// 큐에 값이 있으면 (각 노드까지 가는 최단 경로 검사)
		while(!queue.isEmpty()) {
			// 현재 위치에 있는 노드 저장
			Node nowNode = queue.poll();
			// 시작 -> 끝 (향하는 곳)
			int now = nowNode.end;
			
			// 현재 노드를 방문했다면 continue (자기 자신)
			if(visit[now])
				continue;
			visit[now] = true;
			
			// 현재 노드에서 연결된 노드로 가는 최단거리 계산
			for(Node node : list[now]) {
				if(dis[node.end] > dis[now] + node.weight) {
					dis[node.end] = dis[now] + node.weight;
					queue.add(new Node(node.end, dis[node.end]));
				}
			}
		}
	}
}

class Node implements Comparable<Node>{
	int end;
	int weight;
	
	public Node(int end, int weight) {
		this.end = end;
		this.weight = weight;
	}
	// weight 순으로 정렬
	@Override
	public int compareTo(Node o) {
		return weight-o.weight;
	}
	
	
}
