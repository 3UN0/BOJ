import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_1011 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(rd.readLine());
		
		for(int i=0;i<T;i++) {
			StringTokenizer st = new StringTokenizer(rd.readLine()," ");
			int X = Integer.parseInt(st.nextToken());
			int Y = Integer.parseInt(st.nextToken());
			int distance = Y-X;
			int max = (int)Math.sqrt(distance);
		
			if(max == Math.sqrt(distance)) { // 1 2 4 9 16 ... 
				System.out.println(max * 2 -1);
			} else if(distance <= max * max + max) {
				System.out.println(max * 2);
			} else {
				System.out.println(max * 2+1);
			}
		
		}
	}
	
}
