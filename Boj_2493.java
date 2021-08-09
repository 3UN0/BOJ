import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Stack;

public class Boj_2493 {
	public static StringBuilder sb = new StringBuilder();
	public static boolean[] visit;
	public static int[] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		Stack<int[]> stack = new Stack<>();
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i=0;i<N;i++) {
			int top = Integer.parseInt(st.nextToken());
			
			while(!stack.isEmpty()) {
				// �� �� ž�� N���� ������ ��ȣ ���� ���� -> ���ÿ��� ����
				if(stack.peek()[0] < top) {
					stack.pop();
				// �� �� ž�� N���� ũ�ٸ� ���� ���� -> �ش� ž�� ��ȣ ���
				} else {
					sb.append(stack.peek()[1] + " "); 
					break;
				}
			}
			// ����(ž)�� ����� ���
			if(stack.empty()) {
				sb.append(0 + " ");
			}
			stack.push(new int[] {top, i+1});	// ž ����, ��ȣ �迭(�ε���) ����
		}
		
		System.out.println(sb);
	}
	
}
