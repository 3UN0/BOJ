import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_10809 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String alpha = "abcdefghijklmnopqrstuvwxyz";
		String str = br.readLine();
		
		StringBuilder sb = new StringBuilder();
		
		for(int i=0;i<alpha.length();i++) {
			char c = alpha.charAt(i);
      // indexOf(char) : 해당 문자가 속한 인덱스 번호 반환, 없을 경우 -1 
			sb.append(str.indexOf(c) + " ");
		}
		
		System.out.println(sb);
	}
}
