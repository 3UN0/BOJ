import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_10989 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		
		int[] number = new int[10001];
		
		for(int i=0;i<N;i++) {
			number[Integer.parseInt(br.readLine())]++;
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i=1;i<10001;i++) {
			while(number[i] > 0) {
				sb.append(i+"\n");
				number[i]--;	// �Էµ� i���� �󵵼��� 0�� �ɶ�����
			}
		}
		
		System.out.println(sb);
	}
}
		