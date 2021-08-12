import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Boj_12605 {
	public static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		for(int i=1;i<=N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			Stack<String> stack = new Stack<>();
			int cnt = st.countTokens();
			for(int j=0;j<cnt;j++) {
				stack.push(st.nextToken());
			}
			
			sb.append("Case #"+i+": ");
			
			for(int j=0;j<cnt;j++) {
				sb.append(stack.pop() + " ");
			}
			
			sb.append("\n");
		}
		System.out.println(sb);
			
	}
	
}
