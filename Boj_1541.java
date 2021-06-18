import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_1541 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int sum = Integer.MAX_VALUE;
		// 1. ���� �������� ��ū�� �и� (50 - 15+20 ----> 50      15+20
		StringTokenizer st = new StringTokenizer(br.readLine(), "-");
		
		while(st.hasMoreTokens()) {
			int temp = 0;
			
			// 2. �������� ���� ��ū���� �ٽ� �������� �и�	(50   /   15 .  20)
			StringTokenizer add = new StringTokenizer(st.nextToken(), "+");
			
			// 3. �������� ���� ��ū���� ��� ���Ѵ� (15+20 -> 15 20 ��������)
			while(add.hasMoreTokens()) {
				temp += Integer.parseInt(add.nextToken());
			}
			
			// ù ��° ��ū�� ��� temp = ù ��° ��  (50    ->    
			if(sum == Integer.MAX_VALUE) {
				sum = temp;
			} else {
				sum -= temp;
			}
		}
		
		System.out.println(sum);
	}
	
}

		