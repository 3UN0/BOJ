import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Boj_11279 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PriorityQueue<Integer> pq = new PriorityQueue<>(comp);
		
		/* 클래스 따로 안 하고 한 번에 해도 됨
		 * PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
		 * 		@Override
		 * 		public int compare(Integer o1, Integer o2) {
		 * 			return o2.compareTo(o1);
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
					sb.append(pq.poll() + "\n");	// 가장 큰 값  출력
			} else {
				pq.add(arr[i]);
			}
		}
		
		System.out.println(sb);
		
	}
	
	// 비교 배열 (최대힙이므로 내림차순으로) (o2 가 o1 보다 크면 양수 / 같으면 0 / 작으면 음수 반환)
	public static Comparator<Integer> comp = new Comparator<Integer>() {
		@Override
		public int compare(Integer o1, Integer o2) {
			return o2-o1;
		}
	};
	
}
