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
				// �߿䵵
				queue.offer(new int[] { j, Integer.parseInt(st.nextToken()) });
			}
			
			int count = 0; // ��� Ƚ��
			
			while(!queue.isEmpty()) {	// ť�� �� ������
				int[] now = queue.poll();  	// ���� ó�� ����
				boolean max = true;	// ���� ū ��������
				
				// �߿䵵 ��
				for(int k=0;k<queue.size();k++) {
					// ù ���Һ��� ť�� �ִ� k��° ���Ұ� �߿䵵�� �� Ŭ ���
					if(now[1] < queue.get(k)[1]) {
						queue.offer(now);	// ť �� �ڷ� ����
						for(int x=0;x<k;x++) {
							queue.offer(queue.poll());
						}
						// now ���Ұ� ���� ū ���Ұ� �ƴϾ����Ƿ� false�� ����
						max = false;
						break;
					}
				}
				
				// now ���Ұ� ���� ū ���Ұ� �ƴϸ� -> ���� �ݺ���
				if(max == false) {
					continue;
				}
				
				// now ���Ұ� ���� ū ���Ҹ� �ش� ������ Ƚ�� ���� 
				count++;
				if(now[0] == M) {	// ã������ ���� M �̸� ���
					break;
				}
				
			}
			sb.append(count + "\n");
		}
		System.out.println(sb);
		
	}
	
}
