import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Boj_2504 {
	public static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();	// 문자열 입력
		Stack<Character> stack = new Stack<>();

		boolean flag = false;
		int val = 1;
		int answer = 0;
		for(int i=0;i<str.length();i++) {
			if(str.charAt(i) == '(') {
				stack.push(str.charAt(i));
				val *= 2;
			} else if (str.charAt(i) == '[') {
				stack.push(str.charAt(i));
				val *= 3;
			} else if(str.charAt(i) == ')') {
				if(stack.isEmpty() || stack.peek() != '(') {
					flag = true;
					break;
				} if(str.charAt(i-1) == '(') {
					answer += val;
				}
				stack.pop();
				val/=2;
			} else if(str.charAt(i) == ']') {
				if(stack.isEmpty() || stack.peek() != '[') {
					flag = true;
					break;
				} if(str.charAt(i-1) == '[') {
					answer += val;
				}
				stack.pop();
				val/=3;
			}
		}
		if(flag == true || !stack.isEmpty()) {
			System.out.println(0);
		} else {
			System.out.println(answer);
		}
	}
	
}
