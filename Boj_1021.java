import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Boj_1021 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		LinkedList<Integer> dq = new LinkedList<Integer>();		// LinkedList<String> dq = new LinkedList<>();
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int count = 0;
		
		for(int i=1;i<=N;i++) {
			dq.offer(i);	// ���� ���� ��
		}
		
		int[] arr = new int[M];	// ã������ ��
		st = new StringTokenizer(br.readLine(), " ");
		for(int i=0;i<M;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=0;i<M;i++) {
			int half;		// �� �߰� �ε��� �������� 2 or 3 ���� ����
			
			if(dq.size() % 2 == 0) {	// ¦�� -> 1 2 3 4 �� �� 2 (�ε��� 1)
				half  = dq.size()/2 -1;
			} else {		//	 Ȧ�� -> 1 2 3 �� �� 2 (�ε��� 1)
				half = dq.size()/2;
			}
			
			int target = dq.indexOf(arr[i]);	// ������ �̰��� �ϴ� ������ index
			
			if(target <= half) {	// �߰� ���� ã������ ���� ��ġ�� ���� �� (...���� ...�߰��� ...)
				for(int j=0;j<target;j++) {	// 2�� ���� (�� -> ��) 
					int temp = dq.pollFirst();
					dq.addLast(temp);
					count++;
				}
			} else {	// �߰��� ���� ã������ ���� ��ġ�� ���� �� (...�߰���...���� ...)
				for(int j=dq.size()-1;j>=target;j--) {	// 3�� ���� (�� -> ��)
					int temp = dq.pollLast();
					dq.addFirst(temp);
					count++;
				}
			}
			dq.pollFirst();	// �� �� ���� ���� (1�� ����) (ù ������ �� or 2/3�� ���� �ڿ�)
		}
		
		System.out.println(count);
		
	}
	
}
