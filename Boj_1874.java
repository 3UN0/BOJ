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
		
		int index = 0;	// �Է� ��ġ
		
		while(n --> 0) {
			int value = Integer.parseInt(br.readLine());

			if(value > index) {	// stack�� �Է°� ���� push
				for(int i=index + 1;i<=value;i++) {
					stack.push(i);
					sb.append("+" + '\n');	// push�� �� +
				}
				index = value;
			}
			// top�� �ִ� ���Ұ� �Է¹��� ���� ���� ���� ���
			else if(stack.peek() != value) {
				System.out.println("NO");
				return;
			}
			stack.pop();
			sb.append("-" + '\n');	// pop�� �� -
			
		}
		System.out.println(sb);
	}
 
}
