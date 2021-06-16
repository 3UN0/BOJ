import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Boj_2565 {
	public static int[][] arr;
	public static Integer[] dp;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		arr = new int[N][2];
		dp = new Integer[N];	// 123 ��������

		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr, new Comparator<int[]>(){
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[0] - o2[0];
			}
		});
		
		int max = 0;
		for(int i=0;i<N;i++) {
			max = Math.max(dp(i), max);
		}
		
		System.out.println(N-max);
		
	}
	
	public static int dp(int n) {
		if(dp[n] == null) {	
			dp[n]= 1; // �ּڰ� 1�� �ʱ�ȭ
			
			for(int i=n+1;i<dp.length;i++) {
				// a�� ����Ǿ� ���� n��° ������ b�����뿡 ����Ǿ��� ��,
				// a�� i��° ������ ������ b�����뿡 ������ �ͺ��� �ڿ� �����ؾ��� 
				if(arr[n][1] < arr[i][1]) {
					dp[n] = Math.max(dp[n], dp(i)+1);
				}
				
			}
			
		}
		return dp[n];
	}
	
}
		