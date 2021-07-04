import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj_2110 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());	// ���� ����
		int C = Integer.parseInt(st.nextToken());	// �������� ����
		
		int[] arr = new int[N];	// ���� ���� ���� (N��)
		
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(arr);	
		
		int low = 1;	// ������ �� �ּ� �Ÿ�
		int high = arr[N-1]-arr[0];	// ������ �� �ִ� �Ÿ� (���� ū �� - ���� ���� ��)
		int dis = 0;
		int ans = 0;
		
		// Ư�� ���� �������� ������ ��ġ�� ������ ��ġ
		// ��ġ �� �Ǵ� -> ������ �� ���ؾ� �Ѵٸ� ���� ���� or ������ �� �ٿ��� �Ѵٸ� ���� �ø�
		while(low <= high) {
			int mid = (high+low)/2;	// ����
			int start = arr[0];
			int cnt = 1;
			
			for(int i=0;i<N;i++) {	// �������� �˻�
				dis = arr[i] - start;
				if(dis >= mid) {	// ù��° ������ �Ÿ��� �� ũ�ٸ� cnt++, ã�� ���� �̹� �� �Է�
					cnt++;
					start = arr[i];
				}
			}
			
			if(cnt >= C) {	// ������ �� ���̱� -> ���� ������
				ans = mid;
				low = mid + 1;
			} else {		// ������ �� ���̱� -> ���� ������
				high = mid - 1;
			}
		}
		
		System.out.println(ans);	
		
	}
	
}
