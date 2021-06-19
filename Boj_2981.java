import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Boj_2981 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		
		// M : (6-34) �� (34-38)�� ����� (�ִ����� ã�� �̰��� ����� ã���� ��)
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(arr);	// �������� �ʵ��� ����
		
		int gcd = arr[1] - arr[0]; // �������� �ʵ��� ū �� - ���� ��
		
		for(int i=2;i<N;i++) {
			gcd = gcd(gcd, arr[i] - arr[i-1]);	// �ִ������� ���� ������ �ִ������� ���ؼ� ����
		}
		
		// �ִ������� ����� ã��
		for(int i=2;i<=gcd;i++) {
			if(gcd % i == 0) {
				System.out.print(i + " ");
			}
		}
		

		/*StringBuilder sb = new StringBuilder();
		
		// �ִ������� ����� ã�� (���ݱ����� Ž��)
		for(int i = 2; i <= gcd / 2; i++) {
	    
			if(gcd % i == 0) {
				sb.append(i + " ");
			}
		}
		
		// ������ �ִ����� �� ����ؾ���
		sb.append(gcd);
        
		System.out.println(sb);*/
		
	}
	
	public static int gcd(int a, int b) {
		int tmp;
		
		if(a<b) {
			tmp = a;
			a = b;
			b = tmp;
		}
		while(b!=0) {
			int r = a%b;
			a = b;
			b = r;
		}
		return a;
	}
	
	
}

		