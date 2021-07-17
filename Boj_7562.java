import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_7562 {
	public static int A, B, N, M, I;
	public static int[][] map;
	public static boolean[][] visit;
	public static int[] dx = {-2, -2, -1, -1, 1, 1, 2, 2};	// �����¿�
	public static int[] dy = {-1, 1, 2, -2, 2, -2, -1, 1};	// �����¿�

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
		
		int T = Integer.parseInt(br.readLine());
		
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		// map�� �ش� ��ǥ �� �Է�
		for(int t=0;t<T;t++) {
			I = Integer.parseInt(br.readLine());
			map = new int[I][I];
			visit = new boolean[I][I];
			
			// ������
			st = new StringTokenizer(br.readLine(), " ");
			A = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());
			
			// ������
			st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			sb.append(bfs(A,B) + "\n");
		}
		System.out.println(sb);

	}

	
	// �ʺ� �켱 Ž�� (ť)
	public static int bfs(int x, int y) {
		Queue<Coor> queue = new LinkedList<>();
		// ���� ��ǥ �߰�
		queue.add(new Coor(x, y));
		visit[x][y] = true;
		
		// ť�� ���� ������
		while(!queue.isEmpty()) {
			// ���� ��ġ�� �ִ� �� ����
			Coor coor = queue.poll();
			if(coor.x == N && coor.y == M)
				return map[coor.x][coor.y];
			for(int i=0;i<8;i++) {
				// �̵��� ��ǥ�� ����
				int nx = coor.x + dx[i];
				int ny = coor.y + dy[i];
				
				// map ���� ����
				if(nx >= 0 && ny >= 0 && nx < I && ny < I) {
				// map �� �� o , �̹湮
					if(map[nx][ny] == 0 && !visit[nx][ny]) {
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
		return 0;
	}
}
		