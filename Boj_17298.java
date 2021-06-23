import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Boj_17298 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int arr[] = new int[N];
		Stack<Integer> stack = new Stack<Integer>();
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=0;i<N;i++) {
			// ���� ��� ���� �����鼭 and ���� ���Ұ� ���� �� �� �ε����� ����Ű�� ���Һ��� ū ���
			while(!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
				// �ش� ������ ������ ������ stack�� pop�ϸ鼭 �ش� �ε����� ���� ���� ���ҷ� �ٲ�
				arr[stack.pop()] = arr[i];
			}
			// ���� ��� �ְų� or ���� ���Ұ� ���� �� �� �ε����� ���Һ��� ������ push
			stack.push(i);
		}
		
		// ���ÿ� �����ִ� �ε��� pop �ϸ鼭 �ش� �ε����� ���� -1�� �ʱ�ȭ
		while(!stack.isEmpty()) {
			arr[stack.pop()] = -1;
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<N;i++) {
			sb.append(arr[i]+" "); 
		}
		
		System.out.println(sb);
	}
 
}
