import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_14889 {
	public static int N;
	public static int[][] arr;
	public static boolean[] visit;
	public static int MIN = Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
		N = Integer.parseInt(br.readLine());	// 1~N까지의 자연수
		arr = new int[N][N];
		visit = new boolean[N];
		
		// 능력치
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for(int j=0;j<N;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		
		dfs(0, 0);	
		
		System.out.println(MIN);
	}
	
		
	// idx : 인덱스, count : 조합 개수(재귀 깊이)
	public static void dfs(int idx, int count) {
		// 팀 조합 완료될 때
		if(count == N/2) {
			// 방문 팀, 방문x 팀 -> 각 팀의 점수 구하고 최솟값(차이) 찾음
			Score();
			return;
		}
		
		for(int i=idx;i<N;i++) {
			// 방문 x
			if(!visit[i]) {
				visit[i] = true;	// 방문으로 변경
				dfs(i+1, count+1);	// 재귀 호출
				visit[i] = false;	// 재귀 호출 끝나면 방문x로 변경
			}
			
		}
	}

	// 두 팀의 능력치 계산
	private static void Score() {
		int team_start = 0;
		int team_link = 0;
		
		for(int i=0;i<N-1;i++) {
			for(int j=i+1;j<N;j++) {
				// i번째 사람과 j번째 사람이 true 라면 스타트팀 점수 증가
				if(visit[i] == true && visit[j] == true) {
					team_start += arr[i][j];
					team_start += arr[j][i];
				}
				// i번째 사람과 j번째 사람이 false 라면 링크팀 정수 증가
				else if(visit[i] == false && visit[j] == false) {
					team_link += arr[i][j];
					team_link += arr[j][i];
				}
			}
		}
		// 두 팀의 점수 차이
		int val = Math.abs(team_start - team_link);
		
		// 두 팀의 점수차 0이라면 가장 낮은 최솟값이므로 탐색 x -> 0 출력 및 종료
		if(val == 0) {
			System.out.println(val);
			System.exit(0);
		}
		MIN = Math.min(val, MIN);
		
	}

}
		