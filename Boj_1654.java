import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj_1654 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());

		int K = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[K];	// ������ �ִ� ���� ���� (K��)
		for(int i=0;i<K;i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(arr);	// 457 539 743 802
		
		long low = 1;
		long high = arr[K-1];
		long mid = 0;
		
		while(low <= high) {
			mid = (high+low)/2;
			int count = 0;	// ������ ���� ����
		
			for(int j=0;j<arr.length;j++) {
				count += arr[j]/mid;	// ���� ������ �� ���� (K��)�� mid ������ ������ ���� ���� �� �ִ� ���� ���� ����
			}
			
			if(count >= N) {	// N������ ���� ����� �͵� N���� ����� �Ϳ� ����
				low = mid + 1;
			} else {			// N������ ���� ��������� ��� high ���� ��ҽ��Ѽ� ���� ��� ��Ŵ
				high = mid - 1;	
			}
			
		}
		
		System.out.println(high);	// N���� �������� ���� �� �ִ� ���� ������ '�ִ밪'�� ���ϴ� ���̹Ƿ� max ��ȯ
		
	}
	
}
