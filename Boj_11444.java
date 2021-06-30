import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_11444 {
	final static int number = 1000000007;
	public static long[][] arr = {{1,1},{1,0}};	// 초기값 가진 행렬
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		/*
		 *                n
		 *       | 1   1 |    | F(n+1)  F(n)  |
		 * A^n = |       |  = |               |
		 *       | 1   0 |    |  F(n)  F(n-1) |
		 */
		
		long[][] a = {{1,1}, {1,0}};
		
		long n = Long.parseLong(br.readLine());
		
		// Fn을 구하기 위해서 a행렬을 n-1 제곱한 뒤 반환된 행렬 a11 원소를 출력한다

		System.out.println(fibo(a, n-1)[0][0]);
	
	}
	
	public static long[][] fibo(long[][] A, long expo) {
		// 지수가 1 or 0 이면 A return
		if(expo == 1 || expo == 0) {
			return A;
		}
		
		// 지수 절반으로 분할하여 재귀호출
		long[][] temp = fibo(A, expo/2);
		// 하위 재귀에서 얻은 행렬 제곱 (행렬 곱셈)
		temp = multi(temp, temp);
		
		// 지수가 홀수라면 마지막에 A^1 (초기 배열) 곱함
		if(expo % 2 == 1) {
			temp = multi(temp, arr);
		}
		
		return temp;
	}
	
	public static long[][] multi(long[][] m1, long[][] m2){
		long[][] temp = new long[2][2];

		temp[0][0] = ((m1[0][0] * m2[0][0]) + (m1[0][1] * m2[1][0])) % number;
		temp[0][1] = ((m1[0][0] * m2[0][1]) + (m1[0][1] * m2[1][1])) % number;
		temp[1][0] = ((m1[1][0] * m2[0][0]) + (m1[1][1] * m2[1][0])) % number;
		temp[1][1] = ((m1[1][0] * m2[0][1]) + (m1[1][1] * m2[1][1])) % number;
 
		// 반복문으로 작성하는 경우
		/*
		for (int k = 0; k < 2; k++) {
			for (int i = 0; i < 2; i++) {							
				for (int j = 0; j < 2; j++) {
					temp[i][j] += m1[i][k] * m2[k][j];
					temp[i][j] %= numberr;
				}
			}
		}
		*/
		return temp;
	}
	
}

