import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Boj_12015 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());	
		
		ArrayList<Integer> list = new ArrayList<>();	// �����ϴ� �κ� ������ ����Ʈ�� ����
		list.add(0);	// ���� �ּڰ��� ���ϱ� ���Ͽ� 0 �̸� �־���
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			int value = Integer.parseInt(st.nextToken());
			// value �� ����Ʈ �� �� ������ ũ�� ����
			if(value > list.get(list.size()-1))
				list.add(value);
			// value �� ����Ʈ �� �� ������ ������ �̺�Ž��->��ġ
			else {
				int low = 0;
				int high = list.size()-1;
				
				while(low < high) {
					int mid = (low+high)/2;
					if(value <= list.get(mid))
						high = mid;
					else
						low = mid + 1; 
				}
				list.set(high, value);
			}
		}
		
		System.out.println(list.size()-1);	// �� �տ� 0 ����	
	}
}
