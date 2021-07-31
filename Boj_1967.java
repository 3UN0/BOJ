import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Boj_1967 {
	public static StringBuilder sb = new StringBuilder();
	public static boolean[] visit;
	public static ArrayList<Tree>[] list;
	public static int maxDis = 0;
	public static int maxNode = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());	// ��� ����
		list = new ArrayList[n+1];
		for(int i=0;i<=n;i++) {
			list[i] = new ArrayList<Tree>();
		}
		
		StringTokenizer st;
		for(int i=0;i<n-1;i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int parent = Integer.parseInt(st.nextToken());	// �θ� ���
			int child = Integer.parseInt(st.nextToken());	// �ڽ� ���
			int weight = Integer.parseInt(st.nextToken());	// ����ġ
			list[parent].add(new Tree(child, weight));
			list[child].add(new Tree(parent, weight));
		}
		// ��Ʈ ��� 1���� ���� �� ��� ã��->�� ��带 maxNode�� ����
		visit = new boolean[n+1];
		dfs(1, 0);
		// visit �迭 �ʱ�ȭ ��, maxNode���� ���� �� ���������� �Ÿ� ���
		visit = new boolean[n+1];
		dfs(maxNode, 0);

		System.out.println(maxDis);
		
	}
	
	public static void dfs(int v, int dis) {
		// ��� �湮 ó��
		visit[v] = true;
		
		// ���� ����� �Ÿ���  max ���� ũ�ٸ� ���� ��� �Ÿ� ����
		if(dis > maxDis) {
			maxDis = dis;
			maxNode = v;
		}
		
		for(Tree nd : list[v]) {
			// �̹湮�� ���
			if(!visit[nd.child]) {
				dfs(nd.child, dis + nd.weight);
			}
		}
	}
	
	static class Tree{
		int child;
		int weight;
		
		public Tree(int child, int weight){
			this.child = child;
			this.weight = weight;
		}
	}
}

