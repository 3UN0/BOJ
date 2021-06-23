import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_10773 {
	public static int[] stack;
	public static int idx = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int K = Integer.parseInt(br.readLine());
		
		stack = new int[K];
		
		for(int i=0;i<K;i++) {
			int value = Integer.parseInt(br.readLine());
			if(value == 0) {
				pop();
			} else {
				push(value);
			}
		}

		/*for(int i=0;i<K;i++) {
			int value = Integer.parseInt(br.readLine());
			
			if(value == 0) {
				stack[idx] = 0;
				idx--;
			} else {
				idx++;
				stack[idx] = value;
			}
		}*/
		
		int sum = 0;
		for(int i=0;i<stack.length;i++) {
			sum += stack[i];
		}
		
		System.out.println(sum);
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
