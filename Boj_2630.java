import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_2630 {
	public static int white = 0;
	public static int blue = 0;
	public static int[][] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		
		StringTokenizer st;
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0;j<N;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		part(0, 0, N);
		
		System.out.println(white);
		System.out.println(blue);
		
	}
	
	
	public static void part(int row, int col, int size) {
		if(check(row, col, size)) {
			if(arr[row][col] == 0) {
				white++;
			} else {
				blue++;
			}
			return;
		}
		int nSize = size/2;	// 1/2 ������
		// ��� ȣ��
		part(row, col, nSize);				// 2��и� 
		part(row, col+nSize, nSize);		// 1��и�
		part(row+nSize, col, nSize);		// 3��и� 
		part(row+nSize, col+nSize, nSize);	// 4��и�
		
	}

	// �� ���� �� ���� üũ
	public static boolean check(int row, int col, int size) {
		int color = arr[row][col];	// ù ��° ���� �������� �˻�
		
		for(int i=row;i<row+size;i++) {
			for(int j=col;j<col+size;j++) {
				// ������ �ٸ��� false
				if(arr[i][j] != color) {
					return false;
				}
			}
		}
		// �˻� ��� ��� -> true
		return true;
	}

}
