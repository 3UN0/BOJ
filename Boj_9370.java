import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Boj_9370 {
	public static int n, m, t, s, g, h;
	public static int[] dis;	// 최단거리 저장
	public static boolean[] visit;	// 방문 체크
	public static StringBuilder sb = new StringBuilder();
	public static ArrayList<Node9370>[] list;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int j=0;j<T;j++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			n = Integer.parseInt(st.nextToken());	// 정점의 개수
			m = Integer.parseInt(st.nextToken());	// 간선의 개수
			t = Integer.parseInt(st.nextToken());	// 목적지 후보의 개수
			list = new ArrayList[n+1];	// 1~N 까지
			
			st = new StringTokenizer(br.readLine(), " ");
			s = Integer.parseInt(st.nextToken());	// 예술가들의 출발지
			g = Integer.parseInt(st.nextToken());	// 지나간 교차로 1
			h = Integer.parseInt(st.nextToken());	// 지나간 교차로 2 (1-2 사이 도로 지나감)
			
			for(int i=1;i<=n;i++) {
				list[i] = new ArrayList<Node9370>();
			}
			
			// 1 - v1 - v2 - n 까지의 경로 (=> 1 - v2 - v1 - n)
			for(int i=0;i<m;i++) {
				st = new StringTokenizer(br.readLine(), " ");
				// 간선 정보
				int a = Integer.parseInt(st.nextToken());	// start
				int b = Integer.parseInt(st.nextToken());	// end
				int d = Integer.parseInt(st.nextToken());	// 거리 (weight)
				
				// 양방향
				list[a].add(new Node9370(b, d));	
				list[b].add(new Node9370(a, d));	
			}
			
			// 목적지를 오름차순으로 (작은 것부터) 정렬하기 위한 우선순위 큐 선언 (정답 추가)
			PriorityQueue<Integer> q = new PriorityQueue<>();
			for(int i=0;i<t;i++) {
				int x = Integer.parseInt(br.readLine());	// 목적지 노드
				
				// 1. h(g)~g(h) 사이의 거리
				// 2. s~h(g) 사이의 거리
				// 3. x~g(h) 사이의 거리
				// s~x 사이의 최단 거리 (g, h 포함) = min (ans1, ans2) 일 경우 정답에 추가됨 
				long ans1 = dijkstra(s, h) + dijkstra(h, g) + dijkstra(g, x);
				long ans2 = dijkstra(s, g) + dijkstra(g, h) + dijkstra(h, x);
				long ans3 = dijkstra(s, x);
				
				if(Math.min(ans1, ans2) == ans3) {
					q.add(x);
				}
			}
			while(!q.isEmpty()) {
				int end = q.poll();
				sb.append(end + " ");
			}
			sb.append("\n");
				
		}
		System.out.println(sb);
	}
	
	// 다익스트라 알고리즘
	// 현재 연결된 노드에서 이어진 모든 곳 일단 방문하여 거리 계산하여 저장 후
	// 새로운 노드와 새로운 간선들이 추가되면 도달할 수 있는 최단거리 다시 계산하여 거리 저장
	public static long dijkstra(int start, int end) {
		// 가중치 적은 순서대로 저장하기 위해서 우선순위 큐 사용
		PriorityQueue<Node9370> queue = new PriorityQueue<Node9370>();
		// 방문 배열 초기화 (함수 여러 번 호출하므로)
		visit = new boolean[n+1];	// 1~V 까지
		dis = new int[n+1];
		// 시작 노드 추가
		queue.add(new Node9370(start, 0));
		// dis 배열 초기화 (함수 여러 번 호출하므로)
		Arrays.fill(dis, Integer.MAX_VALUE);

		// 최단 거리 입력
		dis[start] = 0;
		
		// 큐에 값이 있으면 (각 노드까지 가는 최단 경로 검사)
		while(!queue.isEmpty()) {
			// 현재 위치에 있는 노드 저장
			Node9370 nowNode = queue.poll();
			// 시작 -> 끝 (향하는 곳)
			int now = nowNode.end;
			
			// 현재 노드를 방문했다면 continue (자기 자신)
			if(visit[now])
				continue;
			visit[now] = true;
			
			// 현재 노드에서 연결된 노드로 가는 최단거리 계산
			for(Node9370 node : list[now]) {
				if(dis[node.end] > dis[now] + node.weight) {
					dis[node.end] = dis[now] + node.weight;
					queue.add(new Node9370(node.end, dis[node.end]));
				}
			}
		}
		return dis[end];
	}
}

class Node9370 implements Comparable<Node9370>{
	int end;
	int weight;
	
	public Node9370(int end, int weight) {
		this.end = end;
		this.weight = weight;
	}
	// weight 순으로 정렬
	@Override
	public int compareTo(Node9370 o) {
		return weight-o.weight;
	}
	
	
}
