import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_10845 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		Queue<Integer> q = new LinkedList<>();
		int num = 0;
		
		for(int i=0;i<N;i++) {
			
			st = new StringTokenizer(br.readLine(), " ");
			String str = st.nextToken();
			
			switch(str) {
			
			case "push":
				num = Integer.parseInt(st.nextToken());
				q.add(num);
				break;
				
			case "pop":
				if(!q.isEmpty()) {
					sb.append(q.poll() + "\n");
				} else {
					sb.append(-1 + "\n");
				}
				break;
				
			case "size":
				sb.append(q.size() + "\n");
				break;
			
			case "empty":
				if(!q.isEmpty()) {
					sb.append(0 + "\n");
				} else {
					sb.append(1 + "\n");
				}
				break;
			
			case "front":
				if(!q.isEmpty()) {
					sb.append(q.peek() + "\n");
				} else {
					sb.append(-1 + "\n");
				}
				break;
			
			case "back":
				if(!q.isEmpty()) {
					sb.append(num + "\n");
				} else {
					sb.append(-1 + "\n");
				}
				break;
				
			}
			
		}
		
		System.out.println(sb);
	}
}
