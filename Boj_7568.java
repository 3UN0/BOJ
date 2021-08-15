import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_7568 {
	public static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[][] arr = new int[N][2];
		
		StringTokenizer st;
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}
			
		for(int i=0;i<N;i++) {
			int cnt = 1;
			for(int j=0;j<N;j++) {
                if(i == j) continue;
                // if (i != j) ÀÏ ¶§
				if(arr[i][0] < arr[j][0] && arr[i][1] < arr[j][1]) {
					cnt++;
				}
			}
			sb.append(cnt + " ");
		}
		
		System.out.println(sb);
		
	}
	
}
