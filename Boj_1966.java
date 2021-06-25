import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Boj_1966 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		StringTokenizer st;
		for(int i=0;i<T;i++) {
			LinkedList<int[]> queue = new LinkedList<>();
			
			st = new StringTokenizer(br.readLine(), " "); 
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());

			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0;j<N;j++) {
				// 중요도
				queue.offer(new int[] { j, Integer.parseInt(st.nextToken()) });
			}
			
			int count = 0; // 출력 횟수
			
			while(!queue.isEmpty()) {	// 큐가 빌 때까지
				int[] now = queue.poll();  	// 가장 처음 원소
				boolean max = true;	// 가장 큰 원소인지
				
				// 중요도 비교
				for(int k=0;k<queue.size();k++) {
					// 첫 원소보다 큐에 있는 k번째 원소가 중요도가 더 클 경우
					if(now[1] < queue.get(k)[1]) {
						queue.offer(now);	// 큐 맨 뒤로 보냄
						for(int x=0;x<k;x++) {
							queue.offer(queue.poll());
						}
						// now 원소가 가장 큰 원소가 아니었으므로 false로 변경
						max = false;
						break;
					}
				}
				
				// now 원소가 가장 큰 원소가 아니면 -> 다음 반복문
				if(max == false) {
					continue;
				}
				
				// now 원소가 가장 큰 원소면 해당 원소의 횟수 증가 
				count++;
				if(now[0] == M) {	// 찾으려는 원소 M 이면 출력
					break;
				}
				
			}
			sb.append(count + "\n");
		}
		System.out.println(sb);
		
	}
	
}
