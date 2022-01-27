import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_2908 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		String num1 = "";
		String num2 = "";
		
		String orinum1 = st.nextToken();
		String orinum2 = st.nextToken();
		
		for(int i=2;i>=0;i--) {
			num1 += orinum1.charAt(i);
			num2 += orinum2.charAt(i);
		}
		
		int n1 = Integer.parseInt(num1);
		int n2 = Integer.parseInt(num2);
		
		if(n1 > n2) {
			System.out.print(n1);
		} else {
			System.out.print(n2);
		}
		
	}
}
