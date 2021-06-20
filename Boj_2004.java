import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_2004 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		long n = Integer.parseInt(st.nextToken());
		long m = Integer.parseInt(st.nextToken());
		
		long count5 = five_power(n) - five_power(n-m) - five_power(m);
		long count2 = two_power(n) - two_power(n-m) - two_power(m);
				
		System.out.println(Math.min(count5, count2));
	}
	
	public static long five_power(long num) {
		int cnt = 0;
		
		while(num >= 5) {
			cnt+= num / 5 ;
			num /= 5;
		}
		return cnt;
	}
	
	public static long two_power(long num) {
		int cnt = 0;
		
		while(num >= 2 ) {
			cnt+= num / 2 ;
			num /= 2;
		}
		return cnt;
	}
}
