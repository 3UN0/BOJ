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
		
		arr = new int[N];	// 동전 가치
		
		// 동전들 가치 입력 1 5 10 50 100 ,,, 50000
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		int count=0;
		// 가장 큰 값부터 탐색 (50000 -> 1)
		for(int i=N-1;i>=0;i--) {
			// 구하려는 금액보다 가치가 작거나 같을 경우 
			if(arr[i] <= K) {
				count += (K / arr[i]);
				K = K % arr[i];
			} // (else. 금액 < 가치 -> 다음 i 값으로 넘어감)
		}
		
		System.out.println(count);
	}
	

}

		