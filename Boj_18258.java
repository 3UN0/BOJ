import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_18258 {
	public static int Front=0;
	public static int Back=0;
	public static int index=0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		Queue<Integer> queue = new LinkedList<Integer>();	//or Queue<Integer> q = new ArrayDeque<>(); -> �� �� ���� ��ȯ �޼ҵ� x
		int rear = 0;	// �� �� ���� ��ȯ �޼ҵ尡 �����Ƿ� push�� �Է� �� �� �������� �ԷµǴ� ���� rear�� ������ -> back ��ɾ� ��� �� rear�� ���
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine(), " ");
			
			switch(st.nextToken()) {
			case "push":
				int value = Integer.parseInt(st.nextToken());
				queue.add(value);
				rear = value;
				break;
			case "front":
				if(!queue.isEmpty()) {
					sb.append(queue.peek() + "\n");
				} else {
					sb.append(-1 + "\n");
				}
				break;

			case "back":
				if(!queue.isEmpty()) {
					sb.append(rear + "\n");
				} else {
					sb.append(-1 + "\n");
				}
				break;

			case "size":
				sb.append(queue.size() + "\n");
				break;

			case "empty":
				if(!queue.isEmpty()) {
					sb.append(0 + "\n");
				} else {
					sb.append(1 + "\n");
				}
				break;

			case "pop":
				if(!queue.isEmpty()) {
					sb.append(queue.poll() + "\n");
				} else {
					sb.append(-1 + "\n");
				}
				break;

			} 
		}
		System.out.println(sb);
		
	}
 
}
