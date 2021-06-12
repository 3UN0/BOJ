import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_2580 {
	public static int[][] arr = new int[9][9];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
		for(int i=0;i<9;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for(int j=0;j<9;j++) {
				arr[i][j] =  Integer.parseInt(st.nextToken());
			}
		}
		
		sudoku(0, 0);
	}
	
		
	public static void sudoku(int row, int col) {
		// 행을 다 채우면 다음 행의 첫 열부터 시작
		if(col == 9) {
			sudoku(row+1, 0);
			return;
		}
		
		// 행,열 다 채워지면 출력 후 종료
		if(row == 9) {
			StringBuilder sb = new StringBuilder();
			for(int i=0;i<9;i++) {
				for(int j=0;j<9;j++) {
					sb.append(arr[i][j] + " ");
				}
				sb.append("\n");
			}
			System.out.println(sb);
			// 시스템 종료
			System.exit(0);
		}
		
		// 해당 위치가 0이라면 1~9까지 중  가능한 수 탐색
		if(arr[row][col] == 0) {
			for(int i=1;i<=9;i++) {
				// i 값 중복 여부 검사
				if(Possibility(row, col, i)) {
					arr[row][col] = i;
					sudoku(row, col+1);
				}
			}
			// 지금은 채울 수 있어도 계속 재귀하다가 나중에 채울 수 없음을 발견했을 때, 다시 값을 저장해야 하므로 재귀 빠져 나오면서 0으로 세팅
			arr[row][col] = 0;
			return;
		}
		sudoku(row, col+1);
		
	}

	public static boolean Possibility(int row, int col, int value) {
		// 1. 같은 행에 있는 원소들 중 겹치는 값들이 있는지 검사 (가로줄 검사)
		for(int i=0;i<9;i++) {
			// 해당 열의 행과 i열의 행이 일치할 경우(같은 행에 위치)
			if(arr[row][i] == value) {
				return false;
			}
		}
		// 2. 같은 열에 있는 원소들 중 겹치는 값이 있는지 검사 (세로줄 검사)
		for(int i=0;i<9;i++) {
			if(arr[i][col] == value) {
				return false;
			}
		} 
		// 3. 3x3 내부에서 값이 존재하는지 검사
		int set_row = (row/3)*3;	// value 가 속한 3x3의 행 첫 위치
		int set_col = (col/3)*3;	// value 가 속한 3x3의 행 첫 위치
		
		for(int i=set_row;i<set_row+3;i++) {
			for(int j=set_col;j<set_col+3;j++) {
				if(arr[i][j] == value) {
					return false;
				}
			}
		}
		
		return true;	// 3가지 조건과 무관하면 true (값 위치O)
	}
		
}
		