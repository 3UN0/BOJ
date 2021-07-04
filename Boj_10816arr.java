import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj_10816arr {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[] arr = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arr);
		
		int M = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();
		st = new StringTokenizer(br.readLine());
		
		for(int i=0;i<M;i++) {
			int temp = Integer.parseInt(st.nextToken());
			sb.append(upperBound(arr, temp) - lowerBound(arr, temp) + " ");
		}
		
		System.out.print(sb);

	}
	
	public static int lowerBound(int[] arr, int num) {
		int low = 0;
		int high = arr.length;
		while(low < high) {
			int mid = (low + high)/2;
			if(arr[mid] >= num) {
				high = mid;
			} else {
				low = mid + 1;
			}
		}
		return low;
		
	}
	
	public static int upperBound(int[] arr, int num) {
		int low = 0;
		int high = arr.length;
		while(low < high) {
			int mid = (low + high)/2;
			if(arr[mid] <= num) {
				low = mid + 1;
			} else {
				high = mid;
			}
		}
		return low;
		
	}
	
}
