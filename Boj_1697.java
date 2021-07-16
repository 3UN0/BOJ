import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_1697 {
	public static int N, K;
	public static int[] map;
	public static boolean[] visit;	// ���� ��� ���ص� ��

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		// ��ġ ���� : 0~100000
		map = new int[100001];
		visit = new boolean[100001];

		System.out.println(bfs(N));
		
	}

	
	// �ʺ� �켱 Ž�� (ť)
	public static int bfs(int n) {
		Queue<Integer> queue = new LinkedList<>();
		// ���� ��� �߰�
		queue.add(n);
		// ��� �湮 ó��
		visit[n] = true;
		
		// ť�� ���� ������
		while(!queue.isEmpty()) {
			// ���� ��ġ�� �ִ� �� ����
			int num = queue.poll();
			// ���� ��ġ = K�̸� �� ��ȯ
			if(num == K)
				return map[num];
			int[] check = {num - 1, num + 1, 2*num};
			for(int i=0;i<3;i++) {
				// �̵��� ��ǥ�� ����
				int next = check[i];
				// map ���� ����
				if (next >= 0 && next <= 100000 && !visit[next]) {
	                // ������ �湮�� ��ǥ �߰�
					queue.add(next);
					// �湮�� ���� ���� map�� �ִ� �� + 1 ���� -> �ּ� �ð� ����
					map[next] = map[num] + 1;
					// ���� ��ǥ �湮 ó��
					visit[next] = true;	// ��ǥ �߰� �ؿ� �ᵵ ��
				}
			}
		}
		return 0;
	}
	
}
		