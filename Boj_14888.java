import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_14888 {
	public static int N;
	public static int[] arr;
	public static int[] operator = new int[4];
	public static int maxnum = Integer.MIN_VALUE;
	public static int minnum = Integer.MAX_VALUE;
	
	public static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
		N = Integer.parseInt(br.readLine());	// 1~N������ �ڿ���
		arr = new int[N];
		
		// ����
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		// ������
		st = new StringTokenizer(br.readLine(), " ");
		for(int i=0;i<4;i++) {
			operator[i] = Integer.parseInt(st.nextToken());
		}
		
		dfs(arr[0], 1);	// ó�� ����, ���� ����->�ε��� (���� �������ְ� ���� ������ �����Ƿ�)
		
		System.out.println(maxnum);
		System.out.println(minnum);
	}
	
		
	public static void dfs(int num, int depth) {
		// depth : �ε������� ���� (��� ������ �����)
		if(depth == N) {
			maxnum = Math.max(maxnum, num);
			minnum = Math.min(minnum, num);
			return;
		}
		
		for(int i=0;i<4;i++) {
			// ������ ������ 1 �̻��� ���
			if(operator[i] > 0) {
				operator[i]--; // �ش� ������ 1 ���� (�湮)
				
				switch(i) {
				
				case 0 : dfs(num + arr[depth], depth+1 ); break;
				case 1 : dfs(num - arr[depth], depth+1 ); break;
				case 2 : dfs(num * arr[depth], depth+1 ); break;
				case 3 : dfs(num / arr[depth], depth+1 ); break;
				
				}
				// ���ȣ�� ���� �� �ش� ������ ���� ����
				operator[i]++;
			}
			
		}
	}

}
		