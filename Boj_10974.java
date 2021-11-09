import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static int[] arr, temp;
	public static boolean[] visit;
	public static int N;
	public static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		arr = new int[N];
		temp = new int[N];
		visit = new boolean[N];
		
		for(int i=0;i<N;i++) {
			arr[i] = i+1;
		}
		
		pemu(temp, N, 0, visit);
		
		
		System.out.println(sb);
	}
	
	public static void pemu(int[] temp, int r, int current, boolean[] visit) {
		if(r == current) {
			for (int i=0;i<temp.length;i++) {
				sb.append(temp[i] + " ");
			}
			sb.append("\n");
			return;
		}
		else {
			for(int i=0;i<N;i++) {
				if(!visit[i]) {
					visit[i] = true;
					temp[current] = arr[i];
					pemu(temp, r, current+1, visit);
					visit[i] = false;
				}
			}
			
		}
		
	}
}
