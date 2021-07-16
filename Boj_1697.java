import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_1697 {
	public static int N, K;
	public static int[] map;
	public static boolean[] visit;	// 굳이 사용 안해도 됨

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		// 위치 범위 : 0~100000
		map = new int[100001];
		visit = new boolean[100001];

		System.out.println(bfs(N));
		
	}

	
	// 너비 우선 탐색 (큐)
	public static int bfs(int n) {
		Queue<Integer> queue = new LinkedList<>();
		// 시작 노드 추가
		queue.add(n);
		// 노드 방문 처리
		visit[n] = true;
		
		// 큐에 값이 있으면
		while(!queue.isEmpty()) {
			// 현재 위치에 있는 값 저장
			int num = queue.poll();
			// 현재 위치 = K이면 값 반환
			if(num == K)
				return map[num];
			int[] check = {num - 1, num + 1, 2*num};
			for(int i=0;i<3;i++) {
				// 이동할 좌표로 변경
				int next = check[i];
				// map 내에 존재
				if (next >= 0 && next <= 100000 && !visit[next]) {
	                // 다음에 방문할 좌표 추가
					queue.add(next);
					// 방문할 곳에 직전 map에 있던 값 + 1 저장 -> 최소 시간 저장
					map[next] = map[num] + 1;
					// 다음 좌표 방문 처리
					visit[next] = true;	// 좌표 추가 밑에 써도 됨
				}
			}
		}
		return 0;
	}
	
}
		