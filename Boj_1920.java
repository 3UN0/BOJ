import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_1920 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[] arr = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int M = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<M;i++) {
			int temp = Integer.parseInt(st.nextToken());
			boolean exist = false;
			
			for(int j=0;j<N;j++) {
				if(temp == arr[j]) {
					exist = true;
					break;
				}
			}
			
			if(exist == false) {
				sb.append(0 + "\n");
			} else {
				sb.append(1 + "\n");
			}
		}
		
		System.out.println(sb);

	}
	
}
