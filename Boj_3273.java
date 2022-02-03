import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj_3273 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		
		int n = Integer.parseInt(br.readLine());
		
		int[] arr = new int[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i=0;i<n;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int x = Integer.parseInt(br.readLine());
		
		Arrays.sort(arr);
		
		int count = 0;
		int start = 0;
		int end = n-1;
    
    // start, end 교차하기 전까지 반복
		while(start < end) {
			int sum = arr[start] + arr[end];
			if(sum == x) {
				end--;
				start++;
				count++;
			} else if (sum > x){
				end--;
			} else {
				start++;
			}
		}
		// 1 2 3 5 7 9 10 11 12 
		System.out.println(count);
		
	}
	
}
