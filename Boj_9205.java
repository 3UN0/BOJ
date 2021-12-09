import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Test {
	public static int F, S, G, U, D;
	public static int[][] map;
	public static int count;
	public static int[] dx = {-1, 0, 1, 0};	// 북0 동1 남2 서3
	public static int[] dy = {0, 1, 0, -1};
	
	// 플로이드 와샬 알고리즘 이용
	// 모든 정점에 대한 거리 조사 -> 도달하는 과정에서 편의점 있나 없나 검사
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st;
		
		int t = Integer.parseInt(br.readLine());
		
		for(int i=0;i<t;i++) {
			
			// 편의점 개수
			int n = Integer.parseInt(br.readLine());
			List<int[]> list = new ArrayList<>();
			for(int j=0;j<n+2;j++) {
				st = new StringTokenizer(br.readLine());
				// 좌표
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				list.add(new int[] {x, y});
			}
			// 편의점 유무 확인
			boolean[][] flag = new boolean[n+2][n+2];
			for(int j=0;j<n+2;j++) {
				for(int k=0;k<n+2;k++) {
					int[] now = list.get(j);
					int[] next = list.get(k);
					// 좌표 사이 거리
					int dis = Math.abs(now[0] - next[0]) + Math.abs(now[1] - next[1]);
					
					if(dis <= 1000) {
						flag[j][k] = true;
					}
				}
			}
			
			for(int j=0;j<n+2;j++) {
				for(int k=0;k<n+2;k++) {
					for(int m=0;m<n+2;m++) {
						if(flag[k][j] && flag[j][m]) {
							flag[k][m] = true;
						}
					}
				}
			}
			
			if(flag[0][n+1]) {
				sb.append("happy\n");
			} else {
				sb.append("sad\n");
			}
			
		}
		System.out.println(sb);
				
	}
	
	// https://loosie.tistory.com/334 참고
}
