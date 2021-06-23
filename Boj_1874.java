import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Boj_1874 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		Stack<Integer> stack = new Stack<Integer>();
		
		int index = 0;	// 입력 위치
		
		while(n --> 0) {
			int value = Integer.parseInt(br.readLine());

			if(value > index) {	// stack에 입력값 까지 push
				for(int i=index + 1;i<=value;i++) {
					stack.push(i);
					sb.append("+" + '\n');	// push할 때 +
				}
				index = value;
			}
			// top에 있는 원소가 입력받은 값과 같지 않은 경우
			else if(stack.peek() != value) {
				System.out.println("NO");
				return;
			}
			stack.pop();
			sb.append("-" + '\n');	// pop할 때 -
			
		}
		System.out.println(sb);
	}
 
}
