import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Boj_9375 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		
		StringTokenizer st;
		while(T-->0) {
			HashMap<String, Integer> map = new HashMap<>();	// 종류, 개수 (종류별로 개수 세기 -> HashMap 클래스 이용)
			
			int N = Integer.parseInt(br.readLine());	// 옷 개수
			
			while(N-->0) {
				st = new StringTokenizer(br.readLine(), " ");
				st.nextToken();	// 옷 이름 필요x
				String cloth = st.nextToken();	// 옷 종류
			
				// 해당 종류의 옷이 해시맵에 있을 떄, 해시맵의 저장되어 있던 해당 종류 +1 증가
				// 해당 종류의 옷이 해시맵에 없을 때, 해당 종류와 개수 1 입력
			
				if(map.containsKey(cloth)) {
					map.put(cloth, map.get(cloth)+1);
				} else {
					map.put(cloth, 1);
				}
			
			}
			
			int result = 1;
			// 안 입는 경우 고려하여 각 종류별 옷의 개수에 +1 해준 값을 모두 곱함
			for(int val : map.values()) {
				result = result * (val+1);
			}
			sb.append(result - 1).append("\n");  // 알몸인 상태 제외 해야하므로 (결과값 - 1)
			
			
			/*for (int i = 0; i < T; i++) {

				HashMap<String, Integer> map = new HashMap<>();

				int N = Integer.parseInt(br.readLine());

				for (int j = 0; j < N; j++) {

					String type = br.readLine().split(" ")[1];

					if (map.containsKey(type)) {

						map.put(type, map.get(type) + 1);

					} else {

						map.put(type, 1);

					}

				}

				int x = 1;

				for (int y : map.values()) {

					x *= y + 1;

				}

				System.out.println(x-1);

			}*/
			
		}
		
		System.out.println(sb);
		
		
	}
}
