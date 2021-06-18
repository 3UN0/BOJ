import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Boj_1931 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[][] arr = new int[N][2];

		StringTokenizer st;
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine(), " ");
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}
		
		// 회의 종료 시간 기준으로 정렬
		Arrays.sort(arr, new Comparator<int[]>() {

			@Override
			public int compare(int[] a1, int[] a2) {
				// 종료 시간 같다면 시작 시간 빠른 순으로 정렬
				if(a1[1] == a2[1]) {
					return a1[0] - a2[0];
				}
				return a1[1] - a2[1];
			}
		});
		
		int count=0;
		int prev = 0;
		
		for(int i=0;i<N;i++) {
			// 직전 종료 시간이 다음 시작 시간보다 작다면 (1,4) -> (5,8) ...
			if(prev <= arr[i][0]) {
				prev = arr[i][1];
				count++;
			}
		}
		
		System.out.println(count);
	}
	
}

		