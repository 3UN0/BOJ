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
				// 맨 앞 탑이 N보다 작으면 신호 수신 못함 -> 스택에서 제거
				if(stack.peek()[0] < top) {
					stack.pop();
				// 맨 앞 탑이 N보다 크다면 수신 가능 -> 해당 탑의 번호 출력
				} else {
					sb.append(stack.peek()[1] + " "); 
					break;
				}
			}
			// 스택(탑)이 비었을 경우
			if(stack.empty()) {
				sb.append(0 + " ");
			}
			stack.push(new int[] {top, i+1});	// 탑 높이, 번호 배열(인덱스) 저장
		}
		
		System.out.println(sb);
	}
	
}
