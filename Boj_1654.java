import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj_1654 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());

		int K = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[K];	// 가지고 있는 랜선 길이 (K개)
		for(int i=0;i<K;i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(arr);	// 457 539 743 802
		
		long low = 1;
		long high = arr[K-1];
		long mid = 0;
		
		while(low <= high) {
			mid = (high+low)/2;
			int count = 0;	// 가능한 랜선 갯수
		
			for(int j=0;j<arr.length;j++) {
				count += arr[j]/mid;	// 현재 보유한 각 랜선 (K개)를 mid 값으로 나누어 새로 만들 수 있는 랜선 개수 구함
			}
			
			if(count >= N) {	// N개보다 많이 만드는 것도 N개를 만드는 것에 포함
				low = mid + 1;
			} else {			// N개보다 적게 만들어졌을 경우 high 값을 축소시켜서 범위 축소 시킴
				high = mid - 1;	
			}
			
		}
		
		System.out.println(high);	// N개의 랜선으로 만들 수 있는 랜선 길이의 '최대값'을 구하는 것이므로 max 반환
		
	}
	
}
