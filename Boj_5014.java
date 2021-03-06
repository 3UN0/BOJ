import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_5014 {
	public static int F, S, G, U, D;
	public static int[][] map;
	public static int count;
	public static int[] dx = {-1, 0, 1, 0};	// 북0 동1 남2 서3
	public static int[] dy = {0, 1, 0, -1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		// 총 건물 층 수
		F = Integer.parseInt(st.nextToken());
		// 현재 위치
		S = Integer.parseInt(st.nextToken());
		// 스타트링크 있는 곳
		G = Integer.parseInt(st.nextToken());
		// 위로 u층
		U = Integer.parseInt(st.nextToken());
		// 아래로 d층
		D = Integer.parseInt(st.nextToken());
		
		// 1층부터 F층까지
		int[] floor = new int[F+1];
		
		System.out.println(bfs(S, G, floor));
		
	}
	
	// bfs로 시작점 큐에 넣어서 시작 -> up, down 이동경로 큐에 저장 -> poll했을 때 위치가 도착점이면 끝
	// 위치가 0 보다 작거나 F보다 크면 return
	public static String bfs(int start, int end, int[] arr) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(start);
		// 처음 시작 버튼 누르고 시작한다 가정
		arr[start] = 1;
		
		while(!q.isEmpty()) {
			int current = q.poll();
			// 현재 위치와 도착지 비교
			if(current == end) {
				return String.valueOf(arr[current] - 1);
			}
			
			// 다음 up 위치가 최대 높이보다 작고, 방문 x 지점
			if(current + U <= F) {
				if(arr[current+U] == 0) {
					arr[current+U] = arr[current] + 1;
					q.add(current+U);
				}
			}
			
			// 다음 down 위치가 1층 이상이고, 방문 x 위치
			if(current - D > 0) {
				if(arr[current-D] == 0) {
					arr[current-D] = arr[current] + 1;
					q.add(current - D);
				}
			}
		}
		return "use the stairs";
	}
}
