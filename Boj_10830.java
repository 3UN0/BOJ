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
				// B=1 일때 A그대로 반환->모듈러 연산 실행되지 않음->오답
				// 위의 문제 해결 위하여 초기 행렬에도 나머지 연산 수행하여 저장(초기화)
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
	
	// 행렬 곱셈
	public static int[][] matrix(int[][] m1, int[][] m2) {
		int[][] temp = new int[N][N];
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				// 각 행/렬의 원소들 곱을 더하는 과정 (총 N개)
				for(int k=0;k<N;k++) { // 누적합
					temp[i][j] += m1[i][k]*m2[k][j];
					temp[i][j] %= number;	// 행렬 곱셈 연산 후 나머지 연산하여 저장
				}
			}
		}
		return temp;
	}
	
	// 지수 (분할정복)
	public static int[][] math(int[][] arr, long expo) {
		// 지수가 1이면 그대로 arr 리턴
		if(expo == 1L) {
			return arr;
		}
		// 지수 절반 분할하여 재귀호출
		int[][] temp = math(arr, expo/2);
		// 하위 재귀에서 얻은 행렬 제곱 (행렬 곱셈)
		temp = matrix(temp, temp);
	
		// 지수 홀수라면, 마지막에 arr^1(초기 배열) 곱해줌
		if(expo % 2 == 1L) {
			temp = matrix(temp, mat);
		}
		return temp;
	
	}
	
	
}

