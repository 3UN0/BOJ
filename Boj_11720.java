import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_11720 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		String s = br.readLine();
		int num = 0;
		for(int i=0;i<N;i++) {
      // 아스키 코드 값으로 계산 (아스키코드 -> 정수형)
			num += s.charAt(i)-'0';
		}
		
		System.out.println(num);
		
	}
}
