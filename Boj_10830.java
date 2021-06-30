import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_10830 {
	final static int number = 1000;
	public static int N;
	public static int[][] mat;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		long B = Long.parseLong(st.nextToken());
		
		mat = new int[N][N];
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0;j<N;j++) {
				// B=1 �϶� A�״�� ��ȯ->��ⷯ ���� ������� ����->����
				// ���� ���� �ذ� ���Ͽ� �ʱ� ��Ŀ��� ������ ���� �����Ͽ� ����(�ʱ�ȭ)
				mat[i][j] = Integer.parseInt(st.nextToken()) % number;
			}
		}
		
		int[][] result = math(mat, B);
		
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				sb.append(result[i][j]).append(' ');
			}
			sb.append("\n");
		}

		System.out.println(sb);
		
	
	}
	
	// ��� ����
	public static int[][] matrix(int[][] m1, int[][] m2) {
		int[][] temp = new int[N][N];
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				// �� ��/���� ���ҵ� ���� ���ϴ� ���� (�� N��)
				for(int k=0;k<N;k++) { // ������
					temp[i][j] += m1[i][k]*m2[k][j];
					temp[i][j] %= number;	// ��� ���� ���� �� ������ �����Ͽ� ����
				}
			}
		}
		return temp;
	}
	
	// ���� (��������)
	public static int[][] math(int[][] arr, long expo) {
		// ������ 1�̸� �״�� arr ����
		if(expo == 1L) {
			return arr;
		}
		// ���� ���� �����Ͽ� ���ȣ��
		int[][] temp = math(arr, expo/2);
		// ���� ��Ϳ��� ���� ��� ���� (��� ����)
		temp = matrix(temp, temp);
	
		// ���� Ȧ�����, �������� arr^1(�ʱ� �迭) ������
		if(expo % 2 == 1L) {
			temp = matrix(temp, mat);
		}
		return temp;
	
	}
	
	
}

