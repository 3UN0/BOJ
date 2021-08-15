import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_1018 {
	public static StringBuilder sb = new StringBuilder();
	public static boolean[][] board;
	public static int result = Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N  = Integer.parseInt(st.nextToken());
		int M  = Integer.parseInt(st.nextToken());
		
		board = new boolean[N][M];
			
		for(int i=0;i<N;i++) {
			String str = br.readLine();
			for(int j=0;j<M;j++) {
				if(str.charAt(j) == 'W') {
					board[i][j] = true;		// W일 때 true
				} else {
					board[i][j] = false;	// B일 때 false
				}
			}
		}
		
		// 최소 경우의 수 : N-7 , M-7 일 경우
		for(int i=0;i<N-7;i++) {
			for(int j=0;j<M-7;j++) {
				find(i, j);
			}
		}
		
		System.out.println(result);
		
	}
	
	public static void find(int x, int y) {
		int a = x+8;	// 8*8 체스판 만들기 위해
		int b = y+8;
		int count = 0;
		
		boolean color = board[x][y];	// 첫번째 칸의 색
		
		for(int i=x;i<a;i++) {
			for(int j=y;j<b;j++) {
				// 올바른 색 아닐경우 +1
				if(board[i][j] != color	) {
					count++;
				}
				// 다음 칸은 색이 바뀌어야 하므로 t이면 f, f이면 t로 변경해줌
				color = (!color);
			}
			color = (!color);
		}
		// 첫 번째 칸 기준으로 할 때의 색칠 할 갯수와
		// 첫 번째 칸 반대 색일 때의 색칠 할 갯수의
		// 둘 중 최솟값을 count에 저장
		count = Math.min(count, 64-count);
		
		// 이전까지 경우 중 최솟값보다 현재 count 값이 더 작을 경우 최솟값 갱신
		result = Math.min(result, count);
	
	}
}
