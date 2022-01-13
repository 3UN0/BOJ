import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj_15655 {
	public static int[] arr;
	public static int[] temp;	
	//public static boolean[] visit;
	public static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		arr = new int[N];
		temp = new int[M];
		//visit = new boolean[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		permu(temp, M, 0, 0);
		
		System.out.print(sb);
	}
	
	// 배열, 뽑을 수, 현재, 시작 수
	public static void permu(int[] temp, int n, int r, int start) {
		if(n == r) {
			for(int i=0;i<n;i++) {
				sb.append(temp[i] + " ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i=start;i<arr.length;i++) {
			temp[r] = arr[i];
			permu(temp, n, r+1, i+1);
		}
		
	}
}
