import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj_1026 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		int N = Integer.parseInt(br.readLine());
		
		int[] arra = new int[N];
		int[] arrb = new int[N];
		
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			arra[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			arrb[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arra);
		Arrays.sort(arrb);
	
		int sum = 0;
		for(int i=0;i<N;i++) {
			sum += arra[i] * arrb[N-1-i];
		}
		
		System.out.print(sum);
		
	}
}

