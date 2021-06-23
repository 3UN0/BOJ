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
				
				if(ccc == '(') {	// ���� ��ȣ -> push
					st.push(ccc);
				} else if(st.empty()) {	// pop�� ���� ���� ��� (�ݴ� ��ȣ�� �� ���� ���)
					vps = false;
				} else {	// �� �� ��� pop
					st.pop();
				}
			}
			
			if(vps && st.empty()) {	// ���ÿ� �ܿ� ��� ���� ��� (���� ��ȣ�� �� ���� ���)
				sb.append("YES"+'\n');
			} else {	// ���� ������� ���
				sb.append("NO"+'\n');
				
			}
			
		}
		System.out.println(sb);
	}		
}
