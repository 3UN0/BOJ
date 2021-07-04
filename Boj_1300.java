import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_1300 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());	
		int k = Integer.parseInt(br.readLine());	
		
		int low = 1;
		int high = k;
		int ans = 0;
		while(low <= high) {
			int mid = (low+high)/2;
			long cnt = 0;
			
			for(int i=1;i<=N;i++) {	// mid보다 작거나 같은 수는 몇 개인지
				cnt += Math.min(mid/i, N);	// mid보다 작은 j의 수 (i*j <= mid)
			}
			
			if(cnt < k) {
				low = mid + 1;
			} else {
				high = mid - 1;
				ans = mid;
			}
			
		}
		
		System.out.println(ans);	
	}
}
