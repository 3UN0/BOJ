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
			if(str.equals(".")) {	// ���� ���ǹ� 
				break;
			}
			sb.append(solve(str)).append('\n');
		}
		System.out.println(sb);
	}
	
	public static String solve(String s) {
		
		Stack<Character> stack = new Stack<>();
		
		for(int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);	// i ��° ���� 
			// ���� ��ȣ�� push 
			if(c == '(' || c == '[') {
				stack.push(c);
			}
			
			// �ݴ� �Ұ�ȣ 
			else if(c == ')') {
				// ������ ����ְų�  or ��Īx
				if(stack.empty() || stack.peek() != '(') {
					return "no";
				}
				else {
					stack.pop();
				}
			}
			// �ݴ� ���ȣ 
			else if(c == ']') {
				// ������ ����ְų� or ��Īx
				if(stack.empty() || stack.peek() != '[') {
					return "no";
				}
				else {
					stack.pop();
				}
			}
			
			// �׿� ���� skip 
		}
		
		if(stack.empty()) {
			return "yes";
		}
		else {
			return "no";
		}
	}
 
}
