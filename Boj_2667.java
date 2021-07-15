import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Boj_2667 {
	public static int N, count;
	public static int[][] map;
	public static boolean[][] visit;
	public static int[] dx = {-1, 1, 0, 0};	// �����¿�
	public static int[] dy = {0, 0, -1, 1};	// �����¿�
	public static ArrayList<Integer> list = new ArrayList<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());	// ��ǻ�� ���� (���)
		
		map = new int[N][N];
		visit = new boolean[N][N];
		
		// map�� ���� �� �Է�
		for(int i=0;i<N;i++) {
			// String str2 = br.readLine().split("");
			String str = br.readLine();	// ���ڿ��� �Է� ����
			for(int j=0;j<N;j++) {
				// map[i][j] = Integer.parseInt(str2[j]);
				map[i][j] = str.charAt(j) - '0';	// ���ڿ� ���ڷ� ��ȯ
			}
		}
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(map[i][j] == 1 && !visit[i][j]) {
					count = 0;
					dfs(i, j); // dfs �Լ��� Ž��
					list.add(count);
				}
			}
		}
		
		Collections.sort(list);
		System.out.println(list.size());
		for(int num : list)
			System.out.println(num);
	}

	
	// ���� �켱 Ž�� (���� / ���)
	public static void dfs(int x, int y) {
		visit[x][y] = true;	// �湮
		count++;
		
		for(int i=0;i<4;i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			// map ���� ����
			if(nx >= 0 && ny >= 0 && nx < N && ny < N) {
				if(map[nx][ny] == 1 && !visit[nx][ny]) {
					dfs(nx, ny);
				}
			}
		}
	}
	
}
		