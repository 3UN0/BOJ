import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_2206 {
	public static int N, M, answer;
	public static int[][] map;
	public static int[][] visit;	// �� �մ� Ƚ�� (����Ƚ��)
	public static int[] dx = {-1, 1, 0, 0};	// �����¿�
	public static int[] dy = {0, 0, -1, 1};	// �����¿�

	static class Coor{
		int x;
		int y;
		int dis;	// �̵��Ÿ�
		int check;	// �� �մ� Ƚ��
		
		public Coor(int x, int y, int dis, int check) {
			this.x = x;
			this.y = y;
			this.dis = dis;
			this.check = check;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		visit = new int[N][M];
		
		// map�� ���� �� �Է�
		for(int i=0;i<N;i++) {
			String[] str2 = br.readLine().split("");
			//String str = br.readLine();	// ���ڿ��� �Է� ����
			for(int j=0;j<M;j++) {
				map[i][j] = Integer.parseInt(str2[j]);
				//map[i][j] = str.charAt(j) - '0';	// ���ڿ� ���ڷ� ��ȯ
				visit[i][j] = Integer.MAX_VALUE;	// �ִ����� �ʱ�ȭ
			}
		}
		
		answer = Integer.MAX_VALUE;
		
		bfs(0,0);
		if(answer == Integer.MAX_VALUE)
			System.out.println(-1);
		else
			System.out.println(answer);
	}

	
	// �ʺ� �켱 Ž�� (ť)
	public static void bfs(int x, int y) {
		// �̵��Ÿ� ������Ű��, �� �մ� Ƚ���� �Բ� �Է��Ͽ� ������ ���� ��� �߰�
		Queue<Coor> queue = new LinkedList<>();
		// ���� ��� �߰� (dis -> ó�� ĭ�� �����Ͽ� �̵��Ÿ� ����ϹǷ�)
		queue.add(new Coor(x, y, 1, 0));
		// ó�� �� �մ� Ƚ��
		visit[x][y] = 0;
		
		// ť�� ���� ������
		while(!queue.isEmpty()) {
			// ���� ��ġ�� �ִ� �� ����
			Coor co = queue.poll();
			// ��ǥ (N, M)�� �����ϸ� �̵��Ÿ� return 
			if(co.x == N-1 && co.y == M-1) {
				answer = co.dis;
				break;
			}
			
			for(int i=0;i<4;i++) {
				// �̵��� ��ǥ�� ����
				int nx = co.x + dx[i];
				int ny = co.y + dy[i];
				// map ���� ����
				if (nx >= 0 && ny >= 0 && nx < N && ny < M){
					// map[nx][ny] == 0 -> ������ �� �ִ� ��
					// ������ ���� ����Ƚ�� ���� ���� ������ ũ�� (���� �ִ� �� �� �ν� Ƚ��=0 or �̹湮(�ִ�))
					// => �̵��Ÿ� ���� 
					if(map[nx][ny] == 0 && co.check < visit[nx][ny]) {
		                // ������ �湮�� ��ǥ �߰�
						visit[nx][ny] = co.check;	// ����Ƚ�� �״��
						queue.add(new Coor(nx, ny, co.dis+1, co.check));
					}
					// map[nx][ny] == 1 -> ��
					// ���� ����Ƚ�� 0�� �� (������ ���� x)
					// => �̵��Ÿ�, ����Ƚ�� ����
					else if (map[nx][ny] == 1 && co.check == 0 ){
						visit[nx][ny] = co.check+1;	// ����Ƚ�� ����
						queue.add(new Coor(nx, ny, co.dis+1, co.check+1));
					}
				}
			}
		}
	}
	
}
		