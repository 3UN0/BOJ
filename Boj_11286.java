import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Boj_11286 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PriorityQueue<Integer> pq = new PriorityQueue<>(comp);
		
		/* 클래스 따로 안 하고 한 번에 해도 됨
		 * PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
		 * 		@Override
		 * 		public int compare(Integer o1, Integer o2) {
		 * 			if(Math.abs(o1) == Math.abs(o2))
		 * 				return o2.compareTo(o1);
		 * 			return
		 * 				Math.abs(o1).compareTo(Math.abs(o2));
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
	
	// 비교 배열 (절댓값 오름차순)
	public static Comparator<Integer> comp = new Comparator<Integer>() {
		@Override
		public int compare(Integer o1, Integer o2) {
			if(Math.abs(o1) == Math.abs(o2)) {
				return o1-o2;
			} else {
				return Math.abs(o1) - Math.abs(o2);
			}
		}
	};
	
}
