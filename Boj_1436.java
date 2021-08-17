import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_1436 {
	public static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int number = 666;	// 최솟값 666
		
		// N=1 이면 반복 끝
		while(N>1) {
			number++;
			if(String.valueOf(number).contains("666")) {
				N--;
			}
		}
		
		System.out.println(number);
		
	}
}
