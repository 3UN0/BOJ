import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_15649 {
	public static int[] num;
	public static boolean[] visit;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			
		int N = Integer.parseInt(st.nextToken());	// 1~N������ �ڿ���
		int M = Integer.parseInt(st.nextToken());	// M�� ����

		visit = new boolean[N];	// ���� �ߺ����� �ʵ���, �湮 ǥ��
		num = new int[M];
		dfs(N, M, 0);
	}
	
		
	
	public static void dfs(int N, int M, int depth) {
		if(depth == M) {
			for(int val : num) {
				System.out.print(val + " ");
			}
			System.out.println();
			return;
		}
		
		for(int i=0;i<N;i++) {
			// �ش� �� �湮x
			if(visit[i] == false) {
				visit[i] = true;	// �湮 ���·� ����
				num[depth] = i+1; 	// �ش� ���̸� index�� �ؼ� i+1 ����
				dfs(N, M, depth+1);	// ���� �ڽ� ��Ʈ �湮 ���� depth+1 -> ��� 
				
				// �ڽ� ��� �湮 ������ ���ƿ��� �湮��带 �湮x ���� ����
				visit[i] = false;
				
			}
		}
		return;
	}
		
}
		