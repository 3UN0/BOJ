import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Boj_1406 {
	public static int[] dp = new int[12];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String str = br.readLine();
		int M = Integer.parseInt(br.readLine());
		
		Stack<String> stack = new Stack<String>();
		Stack<String> answer = new Stack<String>();
		
		// abcd 스택에 넣기
		String[] arr = str.split("");
		for(String s : arr) {
			stack.push(s);
		}
		
		for(int i=0;i<M;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String s = st.nextToken();
			// String com = br.readLine();
			// char c = com.charAt(0);
			
			switch(s) {
			case "L":
				if(!stack.isEmpty()) {
					answer.push(stack.pop());
				}
				break;
				
			case "D":
				if(!answer.isEmpty()) {
					stack.push(answer.pop());
				}
				break;
				
			case "B":
				if(!stack.isEmpty()) {
					stack.pop();
				}
				break;
	
			case "P":
				stack.push(st.nextToken());
				// char t = com.charAt(2); (1)은 중간에 공백
				// answer.push(String.valueOf(t));
				break;
	
			default:
				break;
			}
		}
		
		while(!stack.isEmpty()) {
			answer.push(stack.pop());
		}
		
		while(!answer.isEmpty()) {
			sb.append(answer.pop());
		}
		
		System.out.print(sb);
		
	}
}

