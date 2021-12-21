import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj_10815 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[N];
		
		for(int i=0;i<N;i++) {
			arr[i]= Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		
		for(int i=0;i<M;i++) {
			int num = Integer.parseInt(st.nextToken());
			int start = 0;
			int end = N-1;
			int index = 0;
			
			while(start <= end) {
				index = (start+end)/2;
				
				if(arr[index] == num) {
					sb.append(1 + " ");
					break;
				} else if (arr[index] < num) {
					start = index + 1;
				} else {
					end = index - 1;
				}
				
        // 숫자를 찾을 수 없는 경우 (여러번 반복 탈피)
				if(start > end) {
					sb.append(0 + " ");
					break;
				}
			}

		}
		
		System.out.print(sb);
		
	}
}

