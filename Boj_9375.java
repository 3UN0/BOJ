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
			HashMap<String, Integer> map = new HashMap<>();	// ����, ���� (�������� ���� ���� -> HashMap Ŭ���� �̿�)
			
			int N = Integer.parseInt(br.readLine());	// �� ����
			
			while(N-->0) {
				st = new StringTokenizer(br.readLine(), " ");
				st.nextToken();	// �� �̸� �ʿ�x
				String cloth = st.nextToken();	// �� ����
			
				// �ش� ������ ���� �ؽøʿ� ���� ��, �ؽø��� ����Ǿ� �ִ� �ش� ���� +1 ����
				// �ش� ������ ���� �ؽøʿ� ���� ��, �ش� ������ ���� 1 �Է�
			
				if(map.containsKey(cloth)) {
					map.put(cloth, map.get(cloth)+1);
				} else {
					map.put(cloth, 1);
				}
			
			}
			
			int result = 1;
			// �� �Դ� ��� ����Ͽ� �� ������ ���� ������ +1 ���� ���� ��� ����
			for(int val : map.values()) {
				result = result * (val+1);
			}
			sb.append(result - 1).append("\n");  // �˸��� ���� ���� �ؾ��ϹǷ� (����� - 1)
			
			
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
