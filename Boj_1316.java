import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_1316 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int count = 0;
		for(int i=0;i<N;i++) {
			String str = br.readLine();
			if(check(str) == true){
				count++;
			}
		}
		
		System.out.println(count);
		
	}
	
	public static boolean check(String str) {
		// 알파벳 기록
		boolean[] ch = new boolean[26];
		
		// int 형으로 변환시키기
		ch[str.charAt(0)-'a'] = true;
		
		for(int i=1;i<str.length();i++) {
			char now = str.charAt(i);
			char prev = str.charAt(i-1);
			
			// 이전 문자와 같지 않을 때
			if(prev != now) {
				// 중복 x
				if(ch[now-'a'] == false) {
					ch[now-'a'] = true;
				}
				// 중복
				else {
					return false;
				}
			}
			
		}
		
		
		return true;
	}
}
