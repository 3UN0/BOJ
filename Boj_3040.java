import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static int[] arr, temp;
	public static boolean[] visit;
	public static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		arr = new int[9];
		temp = new int[7];
		visit = new boolean[9];
		
		for(int i=0;i<9;i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		pemu(temp, 7, 0, 0);
		
		
		System.out.println(sb);
	}
	
	public static void pemu(int[] temp, int r, int current, int start) {
		if(r == current) {
			int sum = 0;
			
			for (int i=0;i<temp.length;i++) {
				sum += temp[i];
			}
			
			if(sum == 100) {
				for(int i=0;i<temp.length;i++) {
					sb.append(temp[i] + "\n");
				}
			}
			
		}
		else {
			for(int i=start;i<arr.length;i++) {
				temp[current] = arr[i];
				pemu(temp, r, current+1, i+1);
			}
			
		}
		
	}
}
