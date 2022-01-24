import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_1157 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] alpha = new int[26];
		
		String str = br.readLine();
		str = str.toUpperCase();

		for(int i=0;i<str.length();i++) {
			alpha[str.charAt(i)-'A']++;
		}
		
		char ch = '?';
		
		int max = -1;
		for(int i=0;i<alpha.length;i++) {
			if(alpha[i] != 0 && max < alpha[i]) {
				max = alpha[i];
				ch = (char)(i+'A');
			}
			else if(alpha[i] == max) {
				ch = '?';
			}
		}
		
		System.out.print(ch);
	}
}
