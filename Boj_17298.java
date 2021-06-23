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
			// 스택 비어 있지 않으면서 and 현재 원소가 스택 맨 위 인덱스가 가리키는 원소보다 큰 경우
			while(!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
				// 해당 조건을 만족할 때까지 stack을 pop하면서 해당 인덱스의 값을 현재 원소로 바꿈
				arr[stack.pop()] = arr[i];
			}
			// 스택 비어 있거나 or 현재 원소가 스택 맨 위 인덱스의 원소보다 작으면 push
			stack.push(i);
		}
		
		// 스택에 남아있는 인덱스 pop 하면서 해당 인덱스의 값을 -1로 초기화
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
