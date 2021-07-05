import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Boj_12015 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());	
		
		ArrayList<Integer> list = new ArrayList<>();	// 증가하는 부분 수열을 리스트에 넣음
		list.add(0);	// 수열 최솟값과 비교하기 위하여 0 미리 넣어줌
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			int value = Integer.parseInt(st.nextToken());
			// value 가 리스트 맨 끝 값보다 크면 저장
			if(value > list.get(list.size()-1))
				list.add(value);
			// value 가 리스트 맨 끝 값보다 작으면 이분탐색->대치
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
		
		System.out.println(list.size()-1);	// 맨 앞에 0 제외	
	}
}
