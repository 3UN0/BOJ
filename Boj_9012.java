import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Boj_9012 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		
		for(int i=0;i<T;i++) {
			String str = br.readLine();
			Stack<Character> st = new Stack<>();
			boolean vps=true;
			for(int j=0;j<str.length();j++) {
				char ccc = str.charAt(j);
				
				if(ccc == '(') {	// 여는 괄호 -> push
					st.push(ccc);
				} else if(st.empty()) {	// pop할 원소 없을 경우 (닫는 괄호가 더 많을 경우)
					vps = false;
				} else {	// 그 외 경우 pop
					st.pop();
				}
			}
			
			if(vps && st.empty()) {	// 스택에 잔여 요소 있을 경우 (여는 괄호가 더 많을 경우)
				sb.append("YES"+'\n');
			} else {	// 스택 비어있을 경우
				sb.append("NO"+'\n');
				
			}
			
		}
		System.out.println(sb);
	}		
}
