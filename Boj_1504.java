import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Boj_1504 {
	public static int N, E;
	public static int[] dis;	// 최단거리 저장
	public static boolean[] visit;	// 방문 체크
	public static ArrayList<Node1504>[] list;
	// 0번째 리스트에 정점 1과 인접한 정점들의 번호가 입력됨 ... 
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());	// 정점의 개수
		E = Integer.parseInt(st.nextToken());	// 간선의 개수

		dis = new int[N+1];	// 1~N 까지	
		list = new ArrayList[N+1];	// 1~N 까지
		// visit = new boolean[N+1];	// 1~V 까지
		//Arrays.fill(dis, Integer.MAX_VALUE);	// dis 배열 일괄 초기화

		for(int i=1;i<=N;i++) {
			list[i] = new ArrayList<Node1504>();
		}

		// 1 - v1 - v2 - n 까지의 경로 (=> 1 - v2 - v1 - n)
		for(int i=0;i<E;i++) {
			st = new StringTokenizer(br.readLine(), " ");
			// 간선 정보
			int a = Integer.parseInt(st.nextToken());	// start
			int b = Integer.parseInt(st.nextToken());	// end
			int w = Integer.parseInt(st.nextToken());	// 거리 (weight)
			
			// 양방향
			list[a].add(new Node1504(b, w));	
			list[b].add(new Node1504(a, w));	
		}
		
		st = new StringTokenizer(br.readLine(), " ");
		int v1 = Integer.parseInt(st.nextToken());	// 필수 방문 정점
		int v2 = Integer.parseInt(st.nextToken());	// 필수 방문 정점
		
		
		StringBuilder sb = new StringBuilder();

		// 1. v1(v2)~v2(v1) 사이의 거리
		// 2. 1~v1(v2) 사이의 거리
		// 3. n~v1(v2) 사이의 거리
		long ans1 = dijkstra(1, v1) + dijkstra(v1, v2) + dijkstra(v2, N);
		long ans2 = dijkstra(1, v2) + dijkstra(v2, v1) + dijkstra(v1, N);
		
		if(Math.min(ans1, ans2) >= Integer.MAX_VALUE) {
			System.out.println(-1);
		} else {
			System.out.println(Math.min(ans1, ans2));
		}

	}
	
	// 다익스트라 알고리즘
	// 현재 연결된 노드에서 이어진 모든 곳 일단 방문하여 거리 계산하여 저장 후
	// 새로운 노드와 새로운 간선들이 추가되면 도달할 수 있는 최단거리 다시 계산하여 거리 저장
	public static long dijkstra(int start, int end) {
		// 가중치 적은 순서대로 저장하기 위해서 우선순위 큐 사용
		PriorityQueue<Node1504> queue = new PriorityQueue<Node1504>();
		// 방문 배열 초기화 (함수 여러 번 호출하므로)
		visit = new boolean[N+1];	// 1~V 까지
		// 시작 노드 추가
		queue.add(new Node1504(start, 0));
		// dis 배열 초기화 (함수 여러 번 호출하므로)
		Arrays.fill(dis, Integer.MAX_VALUE);

		// 최단 거리 입력
		dis[start] = 0;
		
		// 큐에 값이 있으면 (각 노드까지 가는 최단 경로 검사)
		while(!queue.isEmpty()) {
			// 현재 위치에 있는 노드 저장
			Node1504 nowNode = queue.poll();
			// 시작 -> 끝 (향하는 곳)
			int now = nowNode.end;
			
			// 현재 노드를 방문했다면 continue (자기 자신)
			if(visit[now])
				continue;
			visit[now] = true;
			
			// 현재 노드에서 연결된 노드로 가는 최단거리 계산
			for(Node1504 node : list[now]) {
				if(dis[node.end] > dis[now] + node.weight) {
					dis[node.end] = dis[now] + node.weight;
					queue.add(new Node1504(node.end, dis[node.end]));
				}
			}
		}
		return dis[end];
	}
}

class Node1504 implements Comparable<Node1504>{
	int end;
	int weight;
	
	public Node1504(int end, int weight) {
		this.end = end;
		this.weight = weight;
	}
	// weight 순으로 정렬
	@Override
	public int compareTo(Node1504 o) {
		return weight-o.weight;
	}
	
	
}
