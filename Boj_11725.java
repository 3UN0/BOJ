import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Boj_11725 {
	public static StringBuilder sb = new StringBuilder();
	public static boolean[] visit;
	public static ArrayList<Integer>[] list;
	public static int[] parents;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		list = new ArrayList[N+1];
		for(int i=1;i<=N;i++) {
			list[i] = new ArrayList<Integer>();
		}
		
		StringTokenizer st;
		for(int i=0;i<N-1;i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list[a].add(b);
			list[b].add(a);
		}
		
		visit = new boolean[N+1];
		// parents[i]=j; i ����� �θ� ���� j
		parents = new int[N+1];	
		
		dfs(1);
		
		for(int i=2;i<=N;i++) {
			sb.append(parents[i] + "\n");
		}
		System.out.println(sb);
		
	}
	
	public static void dfs(int v) {
		// ��� �湮 ó��
		visit[v] = true;
		
		for(int i : list[v]) {
			// �̹湮�� ���
			if(!visit[i]) {
				// ��� ����
				parents[i] = v;
				dfs(i);
			}
		}
		
	}
}

