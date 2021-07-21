import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj_1956 {
	public static int V, E;
	public static long[][] dis;	// �ִܰŸ� ����
	public static boolean[] visit;	// �湮 üũ
	public static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		V = Integer.parseInt(st.nextToken());	// ������ ����
		E = Integer.parseInt(st.nextToken());	// ������ ����

		dis = new long[V+1][V+1];	// 1~N ����
		
		for(long[] a : dis) {
			Arrays.fill(a, Integer.MAX_VALUE);
		}
			
		// 1 - v1 - v2 - n ������ ��� (=> 1 - v2 - v1 - n)
		for(int i=0;i<E;i++) {
			st = new StringTokenizer(br.readLine(), " ");
			// ���� ����
			int a = Integer.parseInt(st.nextToken());	// start
			int b = Integer.parseInt(st.nextToken());	// end
			int c = Integer.parseInt(st.nextToken());	// �Ÿ� (weight)
			
			dis[a][b] = Math.min(dis[a][b], c);
		}
		
		floyd();

		long ans = Integer.MAX_VALUE;
		for(int i=1;i<=V;i++) {
			// �� �� ���� ���� (�ʱ�ȭ �� �״���� ��) (��� x)
			ans = Math.min(ans, dis[i][i]);
		}	
		
		if(ans == Integer.MAX_VALUE) {
			System.out.println("-1");
		} else {
			System.out.println(ans);
		}
	}
	
	// �÷��̵� �˰���
	public static void floyd() {
		// i ~ j ������ �ִܰŸ� : i ~ k + k ~ j (�� �ִ� �Ÿ��� ��) : �� ���� ���Ͽ� min ����
		// ��� ������ �ѹ��� ���İ��� k�� �������� ��
		for(int k=1;k<=V;k++) {
			// ����ϴ� ���
			for(int i=1;i<=V;i++) {
				// �����ϴ� ���
				for(int j=1;j<=V;j++) {
					dis[i][j] = Math.min(dis[i][j], dis[i][k] + dis[k][j]);
					
				}
			}
		}
	}
	
	
}
