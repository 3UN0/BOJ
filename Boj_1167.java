import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Boj_1167 {
	public static StringBuilder sb = new StringBuilder();
	public static boolean[] visit;
	public static ArrayList<Tree>[] list;
	public static int maxDis;
	public static int maxNode;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int V = Integer.parseInt(br.readLine());
		list = new ArrayList[V+1];
		for(int i=1;i<=V;i++) {
			list[i] = new ArrayList<Tree>();
		}
		
		StringTokenizer st;
		for(int i=0;i<V;i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int node = Integer.parseInt(st.nextToken());	// ���� ��ȣ (1~V)
			
			while(true) {
				int next = Integer.parseInt(st.nextToken());	// V�������� ���ϴ� ����
				if(next == -1)
					break;
				int dis = Integer.parseInt(st.nextToken());	// ���ϴ� ���������� �Ÿ�
				list[node].add(new Tree(next, dis));
			}
		}
		// ��Ʈ ��� 1���� ���� �� ��� ã��->�� ��带 maxNode�� ����
		visit = new boolean[V+1];
		dfs(1, 0);

		// visit �迭 �ʱ�ȭ ��, maxNode���� ���� �� ���������� �Ÿ� ���
		visit = new boolean[V+1];
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
			if(!visit[nd.next]) {
				dfs(nd.next, dis + nd.dis);
			}
		}
	}
	
	static class Tree{
		int next;
		int dis;
		
		Tree(int next, int dis){
			this.next = next;
			this.dis = dis;
		}
	}
}

