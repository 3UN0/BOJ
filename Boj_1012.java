import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Boj_1012 {
	public static int T, M, N, K, count;
	public static int[][] map;
	public static boolean[][] visit;
	public static ArrayList<Integer> list;
	public static int[] dx = {-1, 1, 0, 0};	// �����¿�
	public static int[] dy = {0, 0, -1, 1};	// �����¿�
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		T = Integer.parseInt(br.readLine());	// �׽�ũ���̽�
		
		StringBuilder sb = new StringBuilder();
		for(int t=0;t<T;t++) {
			list = new ArrayList<>();
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			
			map = new int[M][N];
			visit = new boolean[M][N];

			// map�� �ش� ��ǥ �� �ִ� ��� 1 �Է�
			for(int i=0;i<K;i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				map[x][y] = 1;
				
			}
			
			for(int i=0;i<M;i++) {
				for(int j=0;j<N;j++) {
					if(map[i][j] == 1 && !visit[i][j]) {
						count = 0;
						dfs(i, j); // dfs �Լ��� Ž��
						list.add(count);
					}
				}
			}
			sb.append(list.size() + "\n");
		}
		System.out.println(sb);
	}

	
	// ���� �켱 Ž�� (���� / ���)
	public static void dfs(int x, int y) {
		visit[x][y] = true;	// �湮
		count++;
		
		// �����¿��Ǻ�
		for(int i=0;i<4;i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			// map ���� ����
			if(nx >= 0 && ny >= 0 && nx < M && ny < N) {
				if(map[nx][ny] == 1 && !visit[nx][ny]) {
					dfs(nx, ny);
				}
			}
		}
	}
	
}
		