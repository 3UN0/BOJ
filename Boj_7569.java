import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_7569 {
	public static int M, N, H;
	public static int[][][] map;
	public static boolean[][][] visit;
	public static int[] dx = {0, 0, -1, 1, 0, 0};	// ���Ʒ������¿�
	public static int[] dy = {0, 0, 0, 0, -1, 1};	// ���Ʒ������¿�
	public static int[] dz = {1, -1, 0, 0, 0, 0,};	// ���Ʒ������¿�
	public static Queue<Coor> queue = new LinkedList<>();
	
	static class Coor{
		int x;
		int y;
		int h;
		
		public Coor(int x, int y, int h) {
			this.x = x;
			this.y = y;
			this.h = h;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		map = new int[N][M][H];
		visit = new boolean[N][M][H];
		
		// map�� �ش� ��ǥ �� �Է�
		for(int h=0;h<H;h++) {
			for(int i=0;i<N;i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for(int j=0;j<M;j++) {
					map[i][j][h] = Integer.parseInt(st.nextToken());
					// ��ǥ���� 1�� ��� ��찡 ������ (���� �丶�䰡 �ִ� ��ǥ)
					if(map[i][j][h] == 1) {
						// ���� �丶�䰡 �ִ� ��ǥ ť�� �߰�
						queue.add(new Coor(i, j, h));
					}
				}
			}
			
		}

		bfs();

		// int day = Integer.MIN_VALUE;
		int day = 0;
		for(int h=0;h<H;h++) {
			for(int i=0;i<N;i++) {
				for(int j=0;j<M;j++) {
					// ���� �� ���� �丶�� �����ϸ�(0�� �ִٸ�) -1 ���
					if(map[i][j][h] == 0) {
						System.out.println("-1");
						System.exit(0);
					}
					// 0 �� ���ٸ� ���� ū �� ����
					else {
						day = Math.max(day, map[i][j][h]);
					}
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
			for(int i=0;i<6;i++) {
				// �̵��� ��ǥ�� ����
				int nx = coor.x + dx[i];
				int ny = coor.y + dy[i];
				int nz = coor.h + dz[i];
				
				// map ���� ����
				if(nx >= 0 && ny >= 0 && nz >= 0 && nx < N && ny < M && nz < H) {
					// ��ǥ���� 0�� ��� (���� ���� �丶�並 ����) , �̹湮
					if(map[nx][ny][nz] == 0 && !visit[nx][ny][nz]) {
						// ������ �湮�� ��ǥ �߰�
						queue.add(new Coor(nx, ny, nz));
						// �湮�� ���� ���� ��ġ�� map�� �ִ� �� (���� �ϼ�) + 1 ���� -> �ִ� �ϼ� ����
						map[nx][ny][nz] = map[coor.x][coor.y][coor.h] + 1;
						// ���� ��ǥ �湮 ó��
						visit[nx][ny][nz] = true;	// ��ǥ �߰� �ؿ� �ᵵ ��
					}
				}
			}
		}
	}
}
		