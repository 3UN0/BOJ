import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Boj_1655 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// PriorityQueue<Integer> pq= new PriorityQueue<>(comp);
		// �ּ���
		PriorityQueue<Integer> pq_min = new PriorityQueue<>(new Comparator<Integer>() {
			public int compare(Integer o1, Integer o2) {
				return o1.compareTo(o2);
			}	// return o1-o2; (��������)
		});
		// �ִ���
		PriorityQueue<Integer> pq_max = new PriorityQueue<>(new Comparator<Integer>() {
			public int compare(Integer o1, Integer o2) {
				return o2.compareTo(o1);
				// return o2-o1; (��������)
			}
		});
		
		// 1. �� ���� pq -> minHeap, maxHeap ����
		// 2. �� pq�� ũ�Ⱑ ������ -> maxHeap�� �Էµ� �� �߰� (�Է��� ���� minHeap�� peek���� ũ�ٸ� ���� swap)
		// 3. �� pq�� ũ�Ⱑ �ٸ��� -> minHeap�� �Էµ� �� �߰� (�Է��� ���� maxHeap�� peek���� �۴ٸ� ���� swap)
		// 4. �ִ����� peek() < �ּ����� peek() �����Ǿ�� �� !! -> ����X : �ִ��� peek() �� �ּ��� peek() swap!! (�� pool ���� add)
		// 5. maxHeap�� top�� ��ġ�� ���� �߰� �� (��� ��)
		int N = Integer.parseInt(br.readLine());	
		
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<N;i++) {
			int num = Integer.parseInt(br.readLine());
			if(pq_min.size() == pq_max.size()) {
				pq_max.add(num);
			} else {
				pq_min.add(num);
			}	
			if(!pq_max.isEmpty() && !pq_min.isEmpty()) {
				if(pq_max.peek() > pq_min.peek()) {	// �ִ��� peek < �ּ��� peek �����Ǿ�� ��!!
					pq_max.add(pq_min.poll());
					pq_min.add(pq_max.poll());
				}
			}
			sb.append(pq_max.peek() + "\n");
		}
		
		System.out.println(sb);
		
	}
	
	// Ŭ���� ������
/*	public static Comparator<Integer> comp = new Comparator<Integer>() {
		@Override
		public int compare(Integer o1, Integer o2) {
			return o1-o2;
		}
	};
*/	
}
