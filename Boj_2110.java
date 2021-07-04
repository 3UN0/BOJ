import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj_2110 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[N];	// 현재 나무 높이 (N개)
		
		st = new StringTokenizer(br.readLine());
		
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);	// 10 15 17 20
		
		long low = 0;
		long high = arr[N-1];
		long mid = 0;
		
		while(low <= high) {
			mid = (high+low)/2;
			int height = 0;		// 가져갈 수 있는 나무 높이
		
			for(int j=0;j<arr.length;j++) {
				if(arr[j] > mid) {
					height += arr[j]-mid;	// 현재 보유한 각 랜선 (K개)를 mid 값으로 나누어 새로 만들 수 있는 랜선 개수 구함
				}
			}
			
			if(height >= M) {	// 적어도 M미터 나무 가져가야 함 (M이상이면 OK)	
				low = mid + 1;	
				// if (high < mid) 	high = mid;
			} else {			// M미터 미만 나무 가져가기 X (high 감소 시키면서 절단기 높이 최댓값 찾기)
				high = mid - 1;
			}
		}
		
		System.out.println(high);	
		
	}
	
}
