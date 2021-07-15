import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_7576 {
	public static int M, N;
	public static int[][] map;
	public static boolean[][] visit;
	public static int[] dx = {-1, 1, 0, 0};	// �����¿�
	public static int[] dy = {0, 0, -1, 1};	// �����¿�

	public static Queue<Coor> queue = new LinkedList<>();
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
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		visit = new boolean[N][M];
		
		// map�� �ش� ��ǥ �� �Է�
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0;j<M;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				// ��ǥ���� 1�� ��� ��찡 ������ (���� �丶�䰡 �ִ� ��ǥ)
				if(map[i][j] == 1) {
					// ���� �丶�䰡 �ִ� ��ǥ ť�� �߰�
					queue.add(new Coor(i, j));
				}
			}
		}

		bfs();

		// int day = Integer.MIN_VALUE;
		int day = 0;
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				// ���� �� ���� �丶�� �����ϸ�(0�� �ִٸ�) -1 ���
				if(map[i][j] == 0) {
					System.out.println("-1");
					System.exit(0);
				}
				// 0 �� ���ٸ� ���� ū �� ����
				else {
					day = Math.max(day, map[i][j]);
				}
			}
		}
		
		// �ɸ� �ϼ� : �ִ밪-1 (ó�� 1���� �����ϹǷ�)
		System.out.println(day - 1);

	}

	
	// �ʺ� �켱 Ž�� (ť)
	public static void bfs() {
		
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
					// ��ǥ���� 0�� ��� (���� ���� �丶�並 ����) , �̹湮
					if(map[nx][ny] == 0 && !visit[nx][ny]) {
						// ������ �湮�� ��ǥ �߰�
						queue.add(new Coor(nx, ny));
						// �湮�� ���� ���� ��ġ�� map�� �ִ� �� (���� �ϼ�) + 1 ���� -> �ִ� �ϼ� ����
						map[nx][ny] = map[coor.x][coor.y] + 1;
						// ���� ��ǥ �湮 ó��
						visit[nx][ny] = true;	// ��ǥ �߰� �ؿ� �ᵵ ��
					}
				}
			}
		}
	}
}
		