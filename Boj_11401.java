import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_11401 {
	public static long number = 1000000007;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		long N = Integer.parseInt(st.nextToken());
		long K = Integer.parseInt(st.nextToken());
		
		long a = factorial(N);
		long b = factorial(K) * factorial(N-K) % number;
				
		System.out.println(a * math(b, number-2) % number);
	}
	
	public static long factorial(long n) {
		if(n == 0) {
			return 1;
		}
		return (n * factorial(n-1))%number;
	}
	
	
	public static long math(long base, long expo) {
		if(expo == 1) {
			return base % number;
		}
		
		// ������ ����
		long temp = math(base, expo/2);
		// ���� ������ Ȧ����� base^(expo/2) * base^(expo/2) * base �� �Ǿ�� �ϹǷ�
		if(expo % 2 == 1) {
			return (temp * temp % number) * base % number;
			// return (temp * temp * base) % number ; -> ���� �Ѿ
		}
		// ���� ���� ¦��
		return (temp * temp) % number;
	}
	
}

