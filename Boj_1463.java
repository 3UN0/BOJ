import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_1463 {
	public static Integer[] dp;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		dp = new Integer[N+1];
		
		dp[0] = 0;
		dp[1] = 0;
		
		System.out.println(one(N));
		
	}
	
	
	public static int one(int n) {
		if(dp[n] == null) {
			if(n%6 == 0) {	// 6���� �������� ���
				dp[n] = Math.min(one(n-1), Math.min(one(n/3), one(n/2)))+1;
			}
			else if(n%3 == 0) {	// 3���θ� �������� ���
				dp[n] = Math.min(one(n/3), one(n-1))+1;
			} else if(n%2 == 0) {	// 2�θ� �������� ���
				dp[n] = Math.min(one(n/2), one(n-1))+1;
			} else	// �׿�
				dp[n] = one(n-1)+1;
		}
		return dp[n];
	}
	
	
}
		