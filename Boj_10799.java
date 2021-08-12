import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Boj_10799 {
	public static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();	// ���ڿ� �Է�
		Stack<Character> stack = new Stack<>();
		
		int count = 0;
		for(int i=0;i<str.length();i++) {
			if(str.charAt(i) == '(') {
				stack.push('(');
			}
			// ')' �Է¹��� ���
			else {
				stack.pop();	// �ϴ� pop
				// �ٷ� �� ���ڰ� '('�� ��� ->������
				if(str.charAt(i-1) == '(') {	
					count+=stack.size();	// ���� �����ŭ ����
				}
				// �ٷ� �� ���ڰ� ')'�� ��� ->��ȣ �ݱ�(���� �Ǻ�)
				else {
					count++;	// ������ ���� �����Ƿ� +1
				}
			}
		}
		System.out.println(count);
	}
	
}
