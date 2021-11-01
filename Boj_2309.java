import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static int[] arr;
	public static boolean chk = false;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		arr = new int[9];
		for(int i=0;i<9;i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(arr);
		
		int[] ans = new int[7];
		
		recur(ans, 7, 0, 0, 0);
	}
	
	public static void recur(int[] ans, int p, int cur, int start, int sum) {
		// 난쟁이 뽑은 후 경우의 수 확인 필요 x -> return
		if(chk)
			return;
		
		if(cur == p) {
			if(sum == 100) {
				for(int i=0;i<ans.length;i++) {
					System.out.println(ans[i]);
				}
				// 7명 난쟁이의 키 합 100 인 거 확인 -> true
				chk = true;
			}
			return;
			
		} else {
			for(int i=start;i<arr.length;i++) {
				ans[cur] = arr[i];
				recur(ans, p, cur+1, i+1, sum + ans[cur]);

			}
		}

	}
}
