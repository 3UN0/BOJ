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
					board[i][j] = true;		// W�� �� true
				} else {
					board[i][j] = false;	// B�� �� false
				}
			}
		}
		
		// �ּ� ����� �� : N-7 , M-7 �� ���
		for(int i=0;i<N-7;i++) {
			for(int j=0;j<M-7;j++) {
				find(i, j);
			}
		}
		
		System.out.println(result);
		
	}
	
	public static void find(int x, int y) {
		int a = x+8;	// 8*8 ü���� ����� ����
		int b = y+8;
		int count = 0;
		
		boolean color = board[x][y];	// ù��° ĭ�� ��
		
		for(int i=x;i<a;i++) {
			for(int j=y;j<b;j++) {
				// �ùٸ� �� �ƴҰ�� +1
				if(board[i][j] != color	) {
					count++;
				}
				// ���� ĭ�� ���� �ٲ��� �ϹǷ� t�̸� f, f�̸� t�� ��������
				color = (!color);
			}
			color = (!color);
		}
		// ù ��° ĭ �������� �� ���� ��ĥ �� ������
		// ù ��° ĭ �ݴ� ���� ���� ��ĥ �� ������
		// �� �� �ּڰ��� count�� ����
		count = Math.min(count, 64-count);
		
		// �������� ��� �� �ּڰ����� ���� count ���� �� ���� ��� �ּڰ� ����
		result = Math.min(result, count);
	
	}
}
