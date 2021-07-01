import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_6549 {
	final static int number = 1000000007;
	public static long[] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n;
		StringBuilder sb = new StringBuilder();
		while(true) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			if(n==0) {
				break;
			}
			
			arr = new long[n];
			
			for(int i=0;i<n;i++) {
				arr[i] = Long.parseLong(st.nextToken());
			}
			sb.append(getArea(0, n-1) + "\n");
			arr = null;	// �迭 �ʱ�ȭ
		}
		System.out.println(sb);
	}

	// ���� ���ϴ� ���� ����
	public static long getArea(int lo, int hi) {
		
		// ���� ���� 1�� ��� ���� -> ����
		if(lo == hi) {
			return arr[lo];
		}
		
		// 1. ���� �׷������� �߰� ���� ���ϱ�
		int mid = (lo + hi)/2;
		
		// 2. mid �������� ����-������ ���� ���� (lo~mid / mid+1~hi)  1 2 3 4 5 (1 2 3 / 4 5)
		long left = getArea(lo, mid);
		long right = getArea(mid+1, hi);
	
		// 3. 2���� ���� ���� �� ū ���� ����
		long maxarea = Math.max(left, right);
		
		// 4. 3���� ���� ���̿� ���� ��ü ���� (lo~hi) �� ū �� ����
		// mid ������ ���� ���ϱ� -> ���� �� ���̰� ū ������ Ȯ�� -> ���� ���̴� ���� ���̿� Ȯ�� ������ ���� �� ���� �� ���� -> ����/Ȯ�� ���� �� ū �� ����
		maxarea = Math.max(maxarea, midArea(lo, hi, mid));
		return maxarea;
		
	}
	
	// �߰� �ε��� �������� ���� ���ϱ�
	public static long midArea(int lo, int hi, int mid)	{
		int toLeft = mid;	// �߰�->��
		int toRight = mid;	// �߰�->��
		
		long height = arr[mid];	// ���� ����
		
		long area = height;	// �ʱ� ���� (�ʺ� 1, ����->����)
		
		// �� �� ���� ����� ������ �ݺ�
		while(lo < toLeft && toRight < hi) {
			// ���� ���� �� ū �� ���� -> ���� ���̴� ���� ���̺��� �۰ų� ���� ��
			if(arr[toLeft - 1] < arr[toRight+1]) {
				 toRight++;
				 height = Math.min(height, arr[toRight]);
			} else {
				toLeft--;
				height = Math.min(height, arr[toLeft]);
			}
			// �ִ� ���� ����
			area = Math.max(area, height * (toRight - toLeft + 1)); 
		}
		// ������ ���� ������ Ž�� ������ ��� ���� Ž��
		while(toRight < hi) {
			toRight++;
			height = Math.min(height, arr[toRight]);
			area = Math.max(area, height * (toRight - toLeft + 1));
		}
		
		// ���� ���� ������ Ž�� ������ ��� ���� Ž��
		while(toLeft > lo) {
			toLeft--;
			height = Math.min(height, arr[toLeft]);
			area = Math.max(area, height * (toRight - toLeft + 1));
		}
		
		return area;
	}
}

