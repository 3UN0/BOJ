import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_11404 {
	public static int n, m, a, b, c;
	public static long[][] dis;	// �ִܰŸ� ����
	public static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());	// ���� ����
		m = Integer.parseInt(br.readLine());	// ���� ����
		
		dis = new long[n+1][n+1];	// 1~N ����
		
		for(long[] a : dis) {
			Arrays.fill(a, Integer.MAX_VALUE);
		}
			
		StringTokenizer st;
		for(int i=0;i<m;i++) {
			st = new StringTokenizer(br.readLine(), " ");
			// ���� ����
			int a = Integer.parseInt(st.nextToken());	// start
			int b = Integer.parseInt(st.nextToken());	// end
			int c = Integer.parseInt(st.nextToken());	// ��� (cost)

			dis[a][b] = Math.min(dis[a][b], c);
		}
		
		floyd();

		for(int i=1;i<=n;i++) {
			for(int j=1;j<=n;j++) {
				// ���� ���� = ���� ���� or �� �� ���� ���� (�ʱ�ȭ �� �״���� ��)
				if(i == j || dis[i][j] >= Integer.MAX_VALUE) {
					sb.append("0 ");
				} else {
					sb.append(dis[i][j] + " ");
				}
			}
			sb.append("\n");
		}
		
		System.out.println(sb);
	}
	
	// �÷��̵� �˰���
	public static void floyd() {
		// i ~ j ������ �ִܰŸ� : i ~ k + k ~ j (�� �ִ� �Ÿ��� ��) : �� ���� ���Ͽ� min ����
		// ��� ������ �ѹ��� ���İ��� k�� �������� ��
		for(int k=1;k<=n;k++) {
			// ����ϴ� ���
			for(int i=1;i<=n;i++) {
				// �����ϴ� ���
				for(int j=1;j<=n;j++) {
					dis[i][j] = Math.min(dis[i][j], dis[i][k] + dis[k][j]);
					
				}
			}
		}
	}
}
