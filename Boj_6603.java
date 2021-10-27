import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static int[] number;
	public static int[] ans;
	public static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			// k개 
			int k = Integer.parseInt(st.nextToken());
			if(k == 0) {
				break;
			}
			
			// 선택하는 수들
			number = new int[k];
			ans = new int[6];
			for(int i=0;i<k;i++) {
				number[i] = Integer.parseInt(st.nextToken());
			}
			
			combi(ans, 6, 0, 0);
			sb.append("\n");
		}
		
		System.out.println(sb);
		
		
	}
	
	// 조합
	public static void combi(int[] ans, int r, int cur, int start) {
		if(r == cur) {
			for(int i=0;i<ans.length;i++) {
				sb.append(ans[i] + " ");
			}
			sb.append("\n");
			return;
		}
		else {
			for(int i=start;i<number.length;i++) {
				ans[cur] = number[i];
				combi(ans, r, cur+1, i+1);
			}
		}
	}


}
