import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_2178 {
	public static int M, N;
	public static int[][] map;
	public static boolean[][] visit;
	public static int[] dx = {-1, 1, 0, 0};	// �����¿�
	public static int[] dy = {0, 0, -1, 1};	// �����¿�

	public static class Coor{
		int x;
		int y;
		
		public Coor(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		visit = new boolean[N][M];
		
		// map�� �ش� ��ǥ �� �Է�
		for(int i=0;i<N;i++) {
			String str = br.readLine();
			for(int j=0;j<M;j++) {
				map[i][j] = str.charAt(j) - '0';
			}
		}

		bfs(0,0);
		
		//(1, 1)~(N, M) ��ġ -> �ε����δ� (0,0)~(N-1, M-1)
		System.out.println(map[N-1][M-1]);
	}

	
	// �ʺ� �켱 Ž�� (ť)
	public static void bfs(int x, int y) {
		Queue<Coor> queue = new LinkedList<>();
		// ���� ��ǥ �߰�
		queue.add(new Coor(x, y));
		
		// ť�� ���� ������
		while(!queue.isEmpty()) {
			// ���� ��ġ�� �ִ� �� ����
			Coor coor = queue.poll();
			for(int i=0;i<4;i++) {
				// �̵��� ��ǥ�� ����
				int nx = coor.x + dx[i];
				int ny = coor.y + dy[i];
				
				// map ���� ����
				if(nx >= 0 && ny >= 0 && nx < N && ny < M) {
				// map �� �� o , �̹湮
					if(map[nx][ny] == 1 && !visit[nx][ny]) {
						// ������ �湮�� ��ǥ �߰�
						queue.add(new Coor(nx, ny));
						//�湮�� ���� ���� map�� �ִ� �� + 1 ���� -> �ּ� ��� ����
						map[nx][ny] = map[coor.x][coor.y] + 1;
						// ���� ��ǥ �湮 ó��
						visit[nx][ny] = true;	// ��ǥ �߰� �ؿ� �ᵵ ��
					}
				}
			}
		}
	}
}
		