import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_2606 {
	public static int N, M, V, count;
	public static int[][] map;
	public static boolean[] visit;
	public static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());	// ��ǻ�� ���� (���)
		M = Integer.parseInt(br.readLine());	// ����� �� (����)
		
		map = new int[N+1][N+1];
		
		// map �� ���� �ʱ�ȭ
		for(int i=0;i<M;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int s = Integer.parseInt(st.nextToken());	
			int e = Integer.parseInt(st.nextToken());
			map[s][e] = 1;
			map[e][s] = 1;
		}
		
		// �迭 �ʱ�ȭ
		visit = new boolean[N+1];
		dfs(1);

		System.out.println(count - 1);
		
	}
	
	// ���� �켱 Ž�� (���� / ���)
	public static void dfs(int start) {
		// ��� ��� ���
		sb.append(start + " ");
		// ��� �湮 ó��
		visit[start] = true;
		
		for(int i=1;i<=N;i++) {
			// map �� ���� o , �̹湮
			if(map[start][i] == 1 && !visit[i])
				dfs(i);
		}
		
		count++;
	}
	
}
		