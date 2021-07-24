import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class DfsBfs {
	public static int N, M, V;
	public static int[][] map;
	public static boolean[] visit;
	public static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());
		
		map = new int[N+1][N+1];
		
		// map �� ���� �ʱ�ȭ
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int s = Integer.parseInt(st.nextToken());	
			int e = Integer.parseInt(st.nextToken());
			map[s][e] = 1;
			map[e][s] = 1;
		}
		
		// �迭 �ʱ�ȭ
		visit = new boolean[N+1];
		dfs(V);
		
		sb.append("\n");
		
		// �迭 �ʱ�ȭ�ϱ� ���ؼ� �ٽ� ����
		visit = new boolean[N+1];
		bfs(V);

		System.out.println(sb);
		
	}
	
	
	/*
	 * DFS - �����̳� ����Լ��� Ǯ �� �ִ�.
	 * �� ��忡�� �� �� �ִ� ��� �� �ϳ��� �����Ѵ�
	 * ������ ��忡�� �� �� �ִ� ��� �� �ϳ��� �����Ѵ�. �� �� �̹� �湮�� ���� �����ϰ� �����Ѵ�.
	 * �� �� �ִ� ��尡 �������� ������ ���� ���� ���ƿͼ� �� �� �ִ� ��� �� �ϳ��� �����Ѵ�.
	 * ���� �������� �ݺ��Ǹ� ��θ� Ž���Ѵ�.
	 
	 * BFS - ť�� Ǯ �� �ִ�.
	 * �� ��忡�� �� �� �ִ� ��带 ť�� �߰��Ѵ�.
	 * ť���� ��带 �ϳ� ������ ���� ��忡�� �� �� �ִ� ��带 ť�� �߰��Ѵ�.
	 * ť�� ��尡 �������� ������ break�Ѵ�.
	 * ���� �������� �ݺ��Ǹ� ��θ� Ž���Ѵ�.
	  
	 * DFS�� �ѳ�忡�� ������ ������ ���� Ž�������� BFS�� ���������� ���� ���� ó�� Ž���Ѵ�.
	 * 
	 * */
	
	
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
		
	}
	/*
	public static void dfs_stack(int start) {
		Stack<Integer> stack = new Stack<>();
		stack.add(start);
		visit[start] = true;
		
		while(!stack.isEmpty()) {
			int nums = stack.pop();
			sb.append(nums + " ");
			
			for(int i=1;i<=N;i++) {
				if(map[nums][i] == 1 && !visit[i]) {
					stack.add(i);
					visit[i] = true;
				}
			}
		}
		
	}
	*/
	// �ʺ� �켱 Ž�� (ť)
	public static void bfs(int start) {
		Queue<Integer> queue = new LinkedList<>();
		// ���� ��� �߰�
		queue.add(start);
		// ��� �湮 ó��
		visit[start] = true;
		
		// ť�� ���� ������
		while(!queue.isEmpty()) {
			int num = queue.poll();
			// ��� ��� ���
			sb.append(num + " ");
			
			for(int i=1;i<=N;i++) {
				// map �� ���� o , �̹湮
				if(map[num][i] == 1 && !visit[i]) {
					// ��� �߰�
					queue.add(i);
					// ��� �湮 ó��
					visit[i] = true;
				}
			}
			
		}
	}
	
}
		