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

        // � ���� �������� 0�� ������ 10�� ����� ���ϴ� �� �ۿ� ����.
        // �׷��� 5�� ������ ���ϸ� �ڿ� ��� 0�� ������ �� �� �ִ�.
        //System.out.println((n/5) + (n/25) + (n/125));

		System.out.println(count);
	}
}
