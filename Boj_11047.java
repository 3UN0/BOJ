import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_11047 {
	public static int[] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		arr = new int[N];	// ���� ��ġ
		
		// ������ ��ġ �Է� 1 5 10 50 100 ,,, 50000
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		int count=0;
		// ���� ū ������ Ž�� (50000 -> 1)
		for(int i=N-1;i>=0;i--) {
			// ���Ϸ��� �ݾ׺��� ��ġ�� �۰ų� ���� ��� 
			if(arr[i] <= K) {
				count += (K / arr[i]);
				K = K % arr[i];
			} // (else. �ݾ� < ��ġ -> ���� i ������ �Ѿ)
		}
		
		System.out.println(count);
	}
	

}

		