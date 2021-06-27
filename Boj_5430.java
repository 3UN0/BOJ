import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Boj_5430 {
	public static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		ArrayDeque<Integer> dq;		// LinkedList<String> dq = new LinkedList<>();
		
		int T = Integer.parseInt(br.readLine());
		
		StringTokenizer st;
		
		for(int i=0;i<T;i++) {
			
			String p = br.readLine();
			int n = Integer.parseInt(br.readLine());
			
			// StringTokenizer로 여러 구분자를 사용할 대는 구분할 문자들을 합쳐서 넘겨준다
			st = new StringTokenizer(br.readLine(), "[],");
			
			dq = new ArrayDeque<Integer>();
			
			for(int j=0;j<n;j++) {
				dq.add(Integer.parseInt(st.nextToken()));
			}
			AC(p, dq);
			
		}
		System.out.println(sb);
		
	}

	public static void AC(String p, ArrayDeque<Integer> dq) {
		boolean way = true; 	// 정방향 (왼) : true / 역방향 (오) : false
		
		for(char cmd : p.toCharArray()) {
			if(cmd == 'R') {
				way = !way; // 방향 바꿔줌
				continue;
			}
			// cmd == 'D'
			if(way) {	// way == true 일 때
				if(dq.pollFirst() == null) {	// 반환할 원소 없을 경우
					sb.append("error\n");
					return;
				}
			} else {	// way == false 일 때
				if(dq.pollLast() == null) {		// 반환할 원소 없을 경우
					sb.append("error\n");
					return;
				}
			}
		}
		
		printString(dq, way);
		
	}

	public static void printString(ArrayDeque<Integer> dq, boolean way) {
		sb.append("[");
		
		if(dq.size()>0) {	// 출력 원소 있을 때
			if(way) {	// 정방향
				sb.append(dq.pollFirst());
				// 그 다음 원소부터는 반점을 추가하여 원소 추출
				while(!dq.isEmpty()) {
					sb.append("," + dq.pollFirst());
				}
			} else {	// 역방향
				sb.append(dq.pollLast());
				// 그 다음 원소부터는 반점을 추가하여 원소 추출
				while(!dq.isEmpty()) {
					sb.append("," + dq.pollLast());
				}
			}
		}
		
		sb.append("]" + "\n");
		
	}
	
}
