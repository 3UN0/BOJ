import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Boj_18870 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		
		int[] arr = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] sortnum = arr.clone();	// 배열 복사
		Arrays.sort(sortnum); // 정렬 (중복 제거)
		
		Map<Integer, Integer> map = new HashMap<>();
		int cnt=0;
		for(int i=0;i<sortnum.length;i++) {
			if(!map.containsKey(sortnum[i])) {
				map.put(sortnum[i], cnt++);
			}
		}
		
		StringBuilder sb = new StringBuilder();
		
		for(int i=0;i<arr.length;i++) {
			sb.append(map.get(arr[i])+" ");
		}
		System.out.print(sb);
	}
}
		