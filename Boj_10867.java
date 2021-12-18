import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Boj_10867 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		ArrayList<Integer> list = new ArrayList<>();
		
		for(int i=0;i<N;i++) {
			int num = Integer.parseInt(st.nextToken());
			
			if(!list.contains(num)) {
				list.add(num);
			}
		}
		
		Collections.sort(list);
		for(int i=0;i<list.size();i++) {
			System.out.print(list.get(i) + " ");
		}
		
	}
}

