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
			if(map.containsKey(num))	// 이미 키 입력되었으면 '해당 키에 대한 값+1'
				map.put(num, map.get(num)+1);
			else						// 키에 대한 값을 1 입력 (초기->키 값 입력)
				map.put(num, 1);
		}

		int M = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		st = new StringTokenizer(br.readLine());
		
		for(int i=0;i<M;i++) {
			int temp = Integer.parseInt(st.nextToken());
			if(!map.containsKey(temp))
				sb.append(0 + " ");		// 키 값 없으면 0
			else
				sb.append(map.get(temp) + " ");	// 키 값 있으면 해당 값 반환
		}
		
		System.out.print(sb);

	}
	
}
