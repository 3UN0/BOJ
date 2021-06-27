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
			
			// StringTokenizer�� ���� �����ڸ� ����� ��� ������ ���ڵ��� ���ļ� �Ѱ��ش�
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
		boolean way = true; 	// ������ (��) : true / ������ (��) : false
		
		for(char cmd : p.toCharArray()) {
			if(cmd == 'R') {
				way = !way; // ���� �ٲ���
				continue;
			}
			// cmd == 'D'
			if(way) {	// way == true �� ��
				if(dq.pollFirst() == null) {	// ��ȯ�� ���� ���� ���
					sb.append("error\n");
					return;
				}
			} else {	// way == false �� ��
				if(dq.pollLast() == null) {		// ��ȯ�� ���� ���� ���
					sb.append("error\n");
					return;
				}
			}
		}
		
		printString(dq, way);
		
	}

	public static void printString(ArrayDeque<Integer> dq, boolean way) {
		sb.append("[");
		
		if(dq.size()>0) {	// ��� ���� ���� ��
			if(way) {	// ������
				sb.append(dq.pollFirst());
				// �� ���� ���Һ��ʹ� ������ �߰��Ͽ� ���� ����
				while(!dq.isEmpty()) {
					sb.append("," + dq.pollFirst());
				}
			} else {	// ������
				sb.append(dq.pollLast());
				// �� ���� ���Һ��ʹ� ������ �߰��Ͽ� ���� ����
				while(!dq.isEmpty()) {
					sb.append("," + dq.pollLast());
				}
			}
		}
		
		sb.append("]" + "\n");
		
	}
	
}
