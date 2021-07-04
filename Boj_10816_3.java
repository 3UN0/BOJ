import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Boj_10816_3 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		HashMap<Integer, Integer> map = new HashMap<>();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			int num = Integer.parseInt(st.nextToken());
			if(map.containsKey(num))	// �̹� Ű �ԷµǾ����� '�ش� Ű�� ���� ��+1'
				map.put(num, map.get(num)+1);
			else						// Ű�� ���� ���� 1 �Է� (�ʱ�->Ű �� �Է�)
				map.put(num, 1);
		}

		int M = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		st = new StringTokenizer(br.readLine());
		
		for(int i=0;i<M;i++) {
			int temp = Integer.parseInt(st.nextToken());
			if(!map.containsKey(temp))
				sb.append(0 + " ");		// Ű �� ������ 0
			else
				sb.append(map.get(temp) + " ");	// Ű �� ������ �ش� �� ��ȯ
		}
		
		System.out.print(sb);

	}
	
}
