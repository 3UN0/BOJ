import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Dijkstra_pq {
	public static int[] dis;
	public static boolean[] visit;
	public static ArrayList<Node>[] list;
;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		// 정점
		int V = Integer.parseInt(st.nextToken());
		// 간선
		int E = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(br.readLine());

		// 최단거리 저장
		dis = new int[V+1];
		Arrays.fill(dis, Integer.MAX_VALUE);
		// 방문 배열
		visit = new boolean[V+1];
		// 1~V 노드 까지
		list = new ArrayList[V+1];
		
		for(int i=1;i<=V;i++) {
			list[i] = new ArrayList<>();
		}
		
		for(int i=0;i<E;i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			// 출발지 -> 도착노드, 가중치 추가
			list[u].add(new Node(v, w));
		}
		
		dijkstra(K);
		
		StringBuilder sb = new StringBuilder();
		
		for(int i=1;i<=V;i++) {
			if(dis[i] == Integer.MAX_VALUE) {
				sb.append("INF\n");
			} else {
				sb.append(dis[i] + "\n");
			}
		}
		System.out.println(sb);
		
	}
	
	public static void dijkstra(int start) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(start, 0));
		// 시작 노드 최단거리는 0 (자기 자신)
		dis[start] = 0;
		
		while(!pq.isEmpty()) {
			Node newNode = pq.poll();
			int depart = newNode.end;
			
			if(!visit[depart]) {
				for(Node next : list[depart]) {
					if(dis[next.end] > dis[depart] + next.weight) {
						dis[next.end] = dis[depart] + next.weight;
						pq.add(new Node(next.end, dis[next.end]));
					}
				}
				visit[depart] = true;
			}
		}
		
	}
	
	static class Node implements Comparable<Node>{
		int end, weight;

		public Node(int end, int weight) {
			this.end = end;
			this.weight = weight;
		}
		
		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			return weight-o.weight;
		}
	}
	
}
