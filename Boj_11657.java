import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj_11657 {
	public static int N, M;
	public static long[] dis;	// 최단거리 저장
	public static StringBuilder sb = new StringBuilder();
	public static ArrayList<Node11657>[] list;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());	// 정점의 개수
		M = Integer.parseInt(st.nextToken());	// 간선의 개수

		list = new ArrayList[N+1];
		dis = new long[N+1];	// 1~N 까지
		Arrays.fill(dis, Integer.MAX_VALUE);
		
		for(int i=1;i<=N;i++) {
			list[i] = new ArrayList<Node11657>();
		}
		
		// 도시 to 도시 최단경로 (비용) -> 음수 사이클 존재할 수도 있음 -> 다익스트라X, 벨만포드O
		// 벨만-포드 알고리즘: 최단거리로 목적지에 도착하는 최소비용은 유일하다 (비용 같을 경우는 경로 여러개일 수 있음)
		// V개의 각각의 노드가 E개의 모든 간선을 이용하여 최소비용 갱신 (각각 노드 출발점X) (간선 1개, 2개 .. n개)
		// 음수 사이클 없다면 V개 만큼 루프 돌기 전에 종료 -> V개 루프 돌면서 업데이트 된다 = 음수 사이클 존재
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine(), " ");
			// 간선 정보
			int a = Integer.parseInt(st.nextToken());	// start
			int b = Integer.parseInt(st.nextToken());	// end
			int c = Integer.parseInt(st.nextToken());	// 시간 (weight)
			
			list[a].add(new Node11657(b, c));
		}
		
		if(bellmanFord()) {
			sb.append("-1\n"); // 갱신 X
		} else {
			for(int i=2;i<=N;i++) {
				if(dis[i] == Integer.MAX_VALUE) {
					sb.append("-1\n");
				} else {
					sb.append(dis[i] + "\n");
				}
			}
		}
		
		System.out.println(sb);
		

	}
	
	// 벨만-포드 알고리즘
	public static boolean bellmanFord() {
		// 처음 최단 거리 입력
		dis[1] = 0;
		boolean update = false;
		
		// 노드 개수 N만큼 업데이트 (check 변수로 표시)
		for(int i=1; i<=N; i++) {
			update = false;
			for(int j=1; j<=N; j++) {
				for(Node11657 node : list[j]) {
					// update 안 되고 초기값 그대로인 경우
					if(dis[j] == Integer.MAX_VALUE) {
						break;
					}
					// update 진행 (최소 비용 갱신)
					if(dis[node.end] > dis[j] + node.weight) {
						dis[node.end] = dis[j] + node.weight;
						update = true;
					}
				}
			}
			if(!update) {	// 업데이트 발생 X
				break;
			}
		}
		// N==2 일 땐 음수사이클 없어도 update = true 이므로 조건 추가
		// N-1 번째까지 갱신했을 때 변경이 있으면 N번째도 업데이트 하므로 음수 사이클 존재한다고 생각될 수 있음
		return update && N>2 ? true : false;
	}
	
}

class Node11657 implements Comparable<Node11657>{
	int end;
	int weight;
	
	public Node11657(int end, int weight) {
		this.end = end;
		this.weight = weight;
	}
	// weight 순으로 정렬
	@Override
	public int compareTo(Node11657 o) {
		return weight-o.weight;
	}
	
}
