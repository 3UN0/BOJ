import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_15650 {
	public static int N, M;
	public static int[] num;
	public static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			
		N = Integer.parseInt(st.nextToken());	// 1~N������ �ڿ���
		M = Integer.parseInt(st.nextToken());	// M�� ����

		num = new int[M];
		dfs(1, 0);
		System.out.println(sb);
	}
	
		
	// at : ���� ��ġ (��𼭺��� �����ϴ��� �ǹ��ϴ� ����)
	public static void dfs(int at, int depth) {
		if(depth == M) {
			for(int i=0;i<M;i++) {
				sb.append(num[i] + " ");
				//System.out.print(num[i] + " ");
			}
			sb.append("\n");
			//System.out.println();
			return;
		}
		
		for(int i=at;i<=N;i++) {
			// ���� ���̸� index�� �Ͽ� �ش� ��ġ�� i�� ����
			num[depth]=i;
			
			// ���纸�� ���� ��ġ ���� �� Ŀ����
			dfs(i+1, depth+1);
			
		}
		return;
	}
		
}
		