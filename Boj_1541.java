import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_1541 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int sum = Integer.MAX_VALUE;
		// 1. 뺄셈 기준으로 토큰들 분리 (50 - 15+20 ----> 50      15+20
		StringTokenizer st = new StringTokenizer(br.readLine(), "-");
		
		while(st.hasMoreTokens()) {
			int temp = 0;
			
			// 2. 뺄셈으로 나눈 토큰들을 다시 덧셈으로 분리	(50   /   15 .  20)
			StringTokenizer add = new StringTokenizer(st.nextToken(), "+");
			
			// 3. 덧셈으로 나눈 토큰들을 모두 더한다 (15+20 -> 15 20 수식으로)
			while(add.hasMoreTokens()) {
				temp += Integer.parseInt(add.nextToken());
			}
			
			// 첫 번째 토큰인 경우 temp = 첫 번째 수  (50    ->    
			if(sum == Integer.MAX_VALUE) {
				sum = temp;
			} else {
				sum -= temp;
			}
		}
		
		System.out.println(sum);
	}
	
}

		