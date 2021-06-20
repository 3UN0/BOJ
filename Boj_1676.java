import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_1676 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int count = 0;
		
		while(N >= 5) {
			count += N/5;
			N = N / 5;
		}

        // 어떤 수의 마지막의 0이 오려면 10의 배수를 곱하는 것 밖에 없다.
        // 그러면 5의 개수를 구하면 뒤에 몇개의 0이 오는지 알 수 있다.
        //System.out.println((n/5) + (n/25) + (n/125));

		System.out.println(count);
	}
}
