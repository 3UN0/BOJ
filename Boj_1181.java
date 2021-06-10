import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Boj_1181 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		
		String[] str = new String[N];
		
		for(int i=0;i<N;i++) {
			str[i] = br.readLine();
		}
		
		Arrays.sort(str, new Comparator<String>() {
			@Override
			public int compare(String s1, String s2) {
				if(s1.length() == s2.length()) {	// 길이 같을 때
					return s1.compareTo(s2);	 // 사전순 정렬
				} else {
					return Integer.compare(s1.length(), s2.length()); // return s1.length()-s2.length();
				}
			}
		});
		
		StringBuilder sb = new StringBuilder();
		sb.append(str[0]+'\n');
		for(int i=1;i<N;i++) {
			// 중복되지 않는 단어만 출력
			if(!str[i].equals(str[i-1])) {
				sb.append(str[i]+'\n');
			}
		}
		System.out.println(sb);
	}
}
		