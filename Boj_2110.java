import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj_2110 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());	// 집의 개수
		int C = Integer.parseInt(st.nextToken());	// 공유기의 개수
		
		int[] arr = new int[N];	// 현재 나무 높이 (N개)
		
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(arr);	
		
		int low = 1;	// 공유기 간 최소 거리
		int high = arr[N-1]-arr[0];	// 공유기 간 최대 거리 (가장 큰 것 - 가장 작은 것)
		int dis = 0;
		int ans = 0;
		
		// 특정 간격 기준으로 가능한 위치에 공유기 설치
		// 설치 후 판단 -> 공유기 수 더해야 한다면 간격 줄임 or 공유기 수 줄여야 한다면 간격 늘림
		while(low <= high) {
			int mid = (high+low)/2;	// 기준
			int start = arr[0];
			int cnt = 1;
			
			for(int i=0;i<N;i++) {	// 집집마다 검색
				dis = arr[i] - start;
				if(dis >= mid) {	// 첫번째 집과의 거리가 더 크다면 cnt++, 찾는 집에 이번 집 입력
					cnt++;
					start = arr[i];
				}
			}
			
			if(cnt >= C) {	// 공유기 수 줄이기 -> 간격 넓히기
				ans = mid;
				low = mid + 1;
			} else {		// 공유기 수 늘이기 -> 간격 좁히기
				high = mid - 1;
			}
		}
		
		System.out.println(ans);	
		
	}
	
}
