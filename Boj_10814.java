import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Boj_10814 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		
		String[][] one = new String[N][2];
		
		
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			one[i][0] = st.nextToken();	// 나이
			one[i][1] = st.nextToken();	// 이름
		}
		
		Arrays.sort(one, new Comparator<String[]>() {
			@Override
			// 나이순 정렬
			public int compare(String[] s1, String[] s2) {
				return Integer.compare(Integer.parseInt(s1[0]), Integer.parseInt(s2[0]));
				//	return Integer.parseInt(s1[0]) - Integer.parseInt(s2[0]);
			} // 입력은 기입순이므로, 나이 같으면 기입순 정렬되는 것
		});
		StringBuilder sb = new StringBuilder();
		
		for(int i=0;i<N;i++) {
			// 중복되지 않는 단어만 출력
			sb.append(one[i][0]+" "+one[i][1]+"\n");
		}
		System.out.println(sb);
	}
}
		