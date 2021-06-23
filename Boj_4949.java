import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Boj_4949 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringBuilder sb = new StringBuilder();
		
		
		while(true) {
			String str = br.readLine();
			if(str.equals(".")) {	// 종료 조건문 
				break;
			}
			sb.append(solve(str)).append('\n');
		}
		System.out.println(sb);
	}
	
	public static String solve(String s) {
		
		Stack<Character> stack = new Stack<>();
		
		for(int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);	// i 번째 문자 
			// 여는 괄호일 push 
			if(c == '(' || c == '[') {
				stack.push(c);
			}
			
			// 닫는 소괄호 
			else if(c == ')') {
				// 스택이 비어있거나  or 매칭x
				if(stack.empty() || stack.peek() != '(') {
					return "no";
				}
				else {
					stack.pop();
				}
			}
			// 닫는 대괄호 
			else if(c == ']') {
				// 스택이 비어있거나 or 매칭x
				if(stack.empty() || stack.peek() != '[') {
					return "no";
				}
				else {
					stack.pop();
				}
			}
			
			// 그외 문자 skip 
		}
		
		if(stack.empty()) {
			return "yes";
		}
		else {
			return "no";
		}
	}
 
}
