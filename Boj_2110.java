import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj_2110 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[N];	// ���� ���� ���� (N��)
		
		st = new StringTokenizer(br.readLine());
		
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);	// 10 15 17 20
		
		long low = 0;
		long high = arr[N-1];
		long mid = 0;
		
		while(low <= high) {
			mid = (high+low)/2;
			int height = 0;		// ������ �� �ִ� ���� ����
		
			for(int j=0;j<arr.length;j++) {
				if(arr[j] > mid) {
					height += arr[j]-mid;	// ���� ������ �� ���� (K��)�� mid ������ ������ ���� ���� �� �ִ� ���� ���� ����
				}
			}
			
			if(height >= M) {	// ��� M���� ���� �������� �� (M�̻��̸� OK)	
				low = mid + 1;	
				// if (high < mid) 	high = mid;
			} else {			// M���� �̸� ���� �������� X (high ���� ��Ű�鼭 ���ܱ� ���� �ִ� ã��)
				high = mid - 1;
			}
		}
		
		System.out.println(high);	
		
	}
	
}
