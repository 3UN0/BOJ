import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_10828 {
	public static int[] stack;
	public static int idx = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		stack = new int[N];
		
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine(), " ");
			
			switch (st.nextToken()) {
			case "push":
				push(Integer.parseInt(st.nextToken()));
				break;

			case "pop":
				sb.append(pop()+"\n");
				break;

			case "size":
				sb.append(size()+"\n");
				break;

			case "empty":
				sb.append(empty()+"\n");
				break;

			case "top":
				sb.append(top()+"\n");
				break;
			}
		}
				
		System.out.println(sb);
	}
	
	public static void push(int n) {
		stack[idx] = n;
		idx++;
	}
	
	
	public static int pop() {
		if(idx == 0) {
			return -1;
		} else {
			int popnum = stack[idx-1];
			stack[idx-1] = 0;
			idx--;
			return popnum;
		}
	}
	
	public static int size() {
		return idx;
	}
	
	public static int empty() {
		if(idx == 0)
			return 1;
		else
			return 0;
	}
	
	public static int top() {
		if(idx == 0)
			return -1;
		else
			return stack[idx-1];
	}
}
