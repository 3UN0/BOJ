import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_2231 {
	public static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int result = 0;
		
		for(int i=0;i<N;i++) {
			int number = i;
			int sum = 0;	// 각 자릿수의 합
			
			while(number != 0) {
				sum += number % 10;
				number /= 10;
			}
			
			if(i+sum == N) {
				result = i;
				break;
			}
		}
		
		System.out.println(result);
			
	}
	
}
