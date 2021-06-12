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
		// ���� �� ä��� ���� ���� ù ������ ����
		if(col == 9) {
			sudoku(row+1, 0);
			return;
		}
		
		// ��,�� �� ä������ ��� �� ����
		if(row == 9) {
			StringBuilder sb = new StringBuilder();
			for(int i=0;i<9;i++) {
				for(int j=0;j<9;j++) {
					sb.append(arr[i][j] + " ");
				}
				sb.append("\n");
			}
			System.out.println(sb);
			// �ý��� ����
			System.exit(0);
		}
		
		// �ش� ��ġ�� 0�̶�� 1~9���� ��  ������ �� Ž��
		if(arr[row][col] == 0) {
			for(int i=1;i<=9;i++) {
				// i �� �ߺ� ���� �˻�
				if(Possibility(row, col, i)) {
					arr[row][col] = i;
					sudoku(row, col+1);
				}
			}
			// ������ ä�� �� �־ ��� ����ϴٰ� ���߿� ä�� �� ������ �߰����� ��, �ٽ� ���� �����ؾ� �ϹǷ� ��� ���� �����鼭 0���� ����
			arr[row][col] = 0;
			return;
		}
		sudoku(row, col+1);
		
	}

	public static boolean Possibility(int row, int col, int value) {
		// 1. ���� �࿡ �ִ� ���ҵ� �� ��ġ�� ������ �ִ��� �˻� (������ �˻�)
		for(int i=0;i<9;i++) {
			// �ش� ���� ��� i���� ���� ��ġ�� ���(���� �࿡ ��ġ)
			if(arr[row][i] == value) {
				return false;
			}
		}
		// 2. ���� ���� �ִ� ���ҵ� �� ��ġ�� ���� �ִ��� �˻� (������ �˻�)
		for(int i=0;i<9;i++) {
			if(arr[i][col] == value) {
				return false;
			}
		} 
		// 3. 3x3 ���ο��� ���� �����ϴ��� �˻�
		int set_row = (row/3)*3;	// value �� ���� 3x3�� �� ù ��ġ
		int set_col = (col/3)*3;	// value �� ���� 3x3�� �� ù ��ġ
		
		for(int i=set_row;i<set_row+3;i++) {
			for(int j=set_col;j<set_col+3;j++) {
				if(arr[i][j] == value) {
					return false;
				}
			}
		}
		
		return true;	// 3���� ���ǰ� �����ϸ� true (�� ��ġO)
	}
		
}
		