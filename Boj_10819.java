import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj_10819 {
	public static StringBuilder sb = new StringBuilder();
	public static int N;
	public static int[] arr;	// 입력 배열
	public static int[] temp;	// 임시 배열
	public static boolean[] visit;	// 방문 확인
	public static int result;	// 결과값
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 입력 숫자
		N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		arr = new int[N];
		temp = new int[N];
		visit = new boolean[N];
		result = 0;
		
		
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		// Arrays.sort(arr);
		solve(0);
		System.out.println(result);
		
	}
	
	public static void solve(int count) {
		System.out.println("count : " + count);
		if(count == N) {
			int sum = 0;	// 초기화
			// 배열 계산
			for(int i=0;i<N-1;i++) {
				// |arr[0]-arr[1]| + .. + |arr[n-2]-arr[n-1]| 
				sum += Math.abs(temp[i] - temp[i+1]);
			}
			result = Math.max(result, sum);
			System.out.println("sum: " + sum + ", result: " + result);
			return;
		}
		
		// 각순열 케이스 생성
		for(int i=0;i<N;i++) {
			System.out.println(i);
			if(visit[i] == true){
				continue;
			}
			System.out.println("ffff");
			visit[i] = true;	// 방문
			temp[count] = arr[i];	// 새로운 배열 만들기
			System.out.println("temp : " + count + ", arr[i] : " + arr[i] );
			solve(count + 1);	// 재귀
			System.out.println("1c:"+count);
			visit[i] = false;	// 방문 해제
			System.out.println("2i:"+i);
			//System.out.println(i);
		}
		
	}
}
