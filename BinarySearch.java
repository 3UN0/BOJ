import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BinarySearch {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[] arr = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		// 1 2 3 4 5 
		
		int M = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		st = new StringTokenizer(br.readLine());
		
		for(int i=0;i<M;i++) {
			int temp = Integer.parseInt(st.nextToken());
			int re = binarySearch(arr, temp);
			sb.append(re + "\n");
		}
		
		System.out.println(sb);

	}
	
	public static int binarySearch(int[] arr, int num) {
		int low = 0;
		int high = arr.length - 1;
		int mid = 0;
		
		while(low <= high) {
			mid = (low + high) /2;
			if(arr[mid] == num) {	// 찾으려는 값이 mid(인덱스)와 같은 값일 때
				return 1;
			} else if (arr[mid] > num) {	// 찾으려는 값이 mid(인덱스)보다 작은 쪽에 있을 때
				high = mid-1;
			} else {	// 찾으려는 값이 mid(인덱스)보다 큰 쪽에 있을 때
				low = mid+1;
			}
		}
		return 0;
	}
	
}
