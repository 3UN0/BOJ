import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj_10867_2 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[N];
		
		for(int i=0;i<N;i++) {
			int num = Integer.parseInt(st.nextToken());
			arr[i] = num;
		}
		
		Arrays.sort(arr);

		ArrayList<Integer> list = new ArrayList<>();
		list.add(arr[0]);
		
		for(int i=1;i<N;i++) {
			if(arr[i-1] != arr[i]){
				list.add(arr[i]);
			}
		}
		
		for(int i=0;i<list.size();i++) {
			System.out.print(list.get(i) + " ");
		}
		
	}
}

