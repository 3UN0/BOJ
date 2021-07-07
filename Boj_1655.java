import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Boj_1655 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// PriorityQueue<Integer> pq= new PriorityQueue<>(comp);
		// 최소힙
		PriorityQueue<Integer> pq_min = new PriorityQueue<>(new Comparator<Integer>() {
			public int compare(Integer o1, Integer o2) {
				return o1.compareTo(o2);
			}	// return o1-o2; (오름차순)
		});
		// 최대힙
		PriorityQueue<Integer> pq_max = new PriorityQueue<>(new Comparator<Integer>() {
			public int compare(Integer o1, Integer o2) {
				return o2.compareTo(o1);
				// return o2-o1; (내림차순)
			}
		});
		
		// 1. 두 개의 pq -> minHeap, maxHeap 선언
		// 2. 두 pq가 크기가 같으면 -> maxHeap에 입력된 값 추가 (입력한 값이 minHeap의 peek보다 크다면 둘을 swap)
		// 3. 두 pq가 크기가 다르면 -> minHeap에 입력된 값 추가 (입력한 값이 maxHeap의 peek보다 작다면 둘을 swap)
		// 4. 최대힙의 peek() < 최소힙의 peek() 성립되어야 함 !! -> 성립X : 최대힙 peek() 과 최소힙 peek() swap!! (각 pool 값을 add)
		// 5. maxHeap의 top에 위치한 값이 중간 값 (출력 값)
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
				if(pq_max.peek() > pq_min.peek()) {	// 최대힙 peek < 최소힙 peek 유지되어야 함!!
					pq_max.add(pq_min.poll());
					pq_min.add(pq_max.poll());
				}
			}
			sb.append(pq_max.peek() + "\n");
		}
		
		System.out.println(sb);
		
	}
	
	// 클래스 재정의
/*	public static Comparator<Integer> comp = new Comparator<Integer>() {
		@Override
		public int compare(Integer o1, Integer o2) {
			return o1-o2;
		}
	};
*/	
}
