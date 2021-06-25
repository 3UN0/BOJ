import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Boj_10866 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		ArrayDeque<Integer> dq = new ArrayDeque<Integer>();		// LinkedList<String> dq = new LinkedList<>();

		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());

		StringTokenizer st;
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine(), " ");	// String[] s = br.readLine().split(" ");
				
			switch(st.nextToken()) {	// switch(s[0])
			case "push_front":
				dq.addFirst(Integer.parseInt(st.nextToken()));	// (s[1])
				break;
				
			case "push_back":
				dq.addLast(Integer.parseInt(st.nextToken()));
				break;
				
			case "pop_front":
				if(dq.isEmpty()) {
					sb.append(-1 + "\n");
				} else {
					sb.append(dq.pollFirst() + "\n");
				}
				break;
				
			case "pop_back":
				if(dq.isEmpty()) {
					sb.append(-1 + "\n");
				} else {
					sb.append(dq.pollLast() + "\n");
				}
				break;
				
			case "size":
				sb.append(dq.size() + "\n");
				break;

			case "empty":
				if(dq.isEmpty()) {
					sb.append(1 + "\n");
				} else {
					sb.append(0 + "\n");
				}
				break;
				
			case "front":
				if(dq.isEmpty()) {
					sb.append(-1 + "\n");
				} else {
					sb.append(dq.peekFirst() + "\n");
				}
				break;
				
			case "back":
				if(dq.isEmpty()) {
					sb.append(-1 + "\n");
				} else {
					sb.append(dq.peekLast() + "\n");
				}
				break;
			}
			
		}

		System.out.println(sb);
		
	}
	
}
