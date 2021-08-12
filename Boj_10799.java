import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Boj_10799 {
	public static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();	// 문자열 입력
		Stack<Character> stack = new Stack<>();
		
		int count = 0;
		for(int i=0;i<str.length();i++) {
			if(str.charAt(i) == '(') {
				stack.push('(');
			}
			// ')' 입력받은 경우
			else {
				stack.pop();	// 일단 pop
				// 바로 전 문자가 '('일 경우 ->레이저
				if(str.charAt(i-1) == '(') {	
					count+=stack.size();	// 스택 사이즈만큼 증가
				}
				// 바로 전 문자가 ')'일 경우 ->괄호 닫기(막대 판별)
				else {
					count++;	// 조각난 막대 있으므로 +1
				}
			}
		}
		System.out.println(count);
	}
	
}
