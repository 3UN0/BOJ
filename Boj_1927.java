import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Boj_1927 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PriorityQueue<Integer> pq = new PriorityQueue<>(comp);
		
		/* Ŭ���� ���� �� �ϰ� �� ���� �ص� ��
		 * PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
		 * 		@Override
		 * 		public int compare(Integer o1, Integer o2) {
		 * 			return o1.compareTo(o2);
		 * 		}
		 * } );
		 */
		
		int N = Integer.parseInt(br.readLine());	
		int[] arr = new int[N];
		
		
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(br.readLine());
			
			if(arr[i] == 0) {
				if(pq.isEmpty())
					sb.append(0 + "\n");
				else 
					sb.append(pq.poll() + "\n");	// ���� ū ��  ���
			} else {
				pq.add(arr[i]);
			}
		}
		
		System.out.println(sb);
		
	}
	
	// �� �迭 (�ּ����̹Ƿ� ������������) (o1 �� o2 ���� ũ�� ��� / ������ 0 / ������ ���� ��ȯ)
	public static Comparator<Integer> comp = new Comparator<Integer>() {
		@Override
		public int compare(Integer o1, Integer o2) {
			return o1-o2;
		}
	};
	
}
