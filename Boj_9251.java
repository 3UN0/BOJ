import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_9251 {
	public static char[] str1;
	public static char[] str2;
	public static Integer[][] dp;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		str1 = br.readLine().toCharArray();	// toCharArray() : ���ڿ��� char[] ������ ��ȯ
		str2 = br.readLine().toCharArray();	
		
		dp = new Integer[str1.length][str2.length];
		
		System.out.println(LCS(str1.length - 1, str2.length - 1));
		
		
		/* Bottom-up ������� Ǯ���� �� (for�� ���)
		 * 
		 * dp = new Integer[str1.length+1][str2.length+1];	// ������ ǥ��

		 * for(int i=1;i<str1.length;i++) {
			for(int j=1;j<str2.length;j++) {
				// i-1 ���� == j-1 ���� (str[0] ���� �˻�, i-1 j-1 ���� ���ؼ� i, j�� 1���� ����
				if(str1[i-1] == str2[j-1]) {
					// �밢�� �� (x-1, y-1) = (i-1, j-1) �� dp+1 ������ ����
					dp[i][j] = dp[i-1][j-1]+1;
				}
				else { 
					dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
				}
			}
		}
		System.out.println(dp[str1.length][str2.length]);

		*/
		
	}
	

	public static int LCS(int x, int y) {
		if(x == -1 || y	== -1) { // ������ (�ε��� ��)
			return 0;
		}
		
		if(dp[x][y] == null) {	
			dp[x][y] = 0; 
			
			// str1�� x��° ���� == str2�� y��° ����
			if(str1[x] == str2[y]) {
				dp[x][y] = LCS(x-1, y-1)+1;
			}
			
			else {
				dp[x][y] = Math.max(LCS(x-1, y), LCS(x, y-1));
			}
			
		}
		return dp[x][y];
	}
	
}
		