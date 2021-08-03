import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Counting_Sort {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		
		// ī���� ����: �Է��� ���� �迭�� �ε����� �Ͽ� �ش� �Է� ���� �� �� (count) �̿��ϴ� ����
		int[] number = new int[10001];
		
		// 2�Է��ϸ� num[2] = 1 �� ����, �� 2 �Է��ϸ� num[2] = 2 �� ���� .... 
		for(int i=0;i<N;i++) {
			number[Integer.parseInt(br.readLine())]++;
		}
		
		StringBuilder sb = new StringBuilder();
		
		// 0�� �Էµ��� ����(�Է� ���� -> 10000������ �ڿ���)
		for(int i=1;i<10001;i++) {
			// num[2] = 2 -> 1 -> 0 �̸� �ݺ���x
			while(number[i] > 0) {
				sb.append(i+"\n");
				number[i]--;	// �Էµ� i���� �󵵼��� 0�� �ɶ�����
			}
		}
		
		System.out.println(sb);
	}
}
		