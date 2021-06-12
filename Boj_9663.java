import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_9663 {
	public static int N;
	public static int[] arr;
	public static int count;
	public static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
		N = Integer.parseInt(br.readLine());	// 1~N까지의 자연수
		arr = new int[N];
		
		nQueen(0);
		System.out.println(count);
	}
	
		
	public static void nQueen(int depth) {
		// 행을 다 채우면 카운트 증가 후 return
		if(depth == N) {
			count++;
			return;
		}
		
		for(int i=0;i<N;i++) {
			// 현재 열을 index로 하여 해당 위치에 i값(칸) 저장
			arr[depth]=i;
		
			// 해당 열에서 i번째 행에 놓을 수 있는지 검사하는 함수 (놓을 수 있으면 재귀함수 호출)
			if(Possibility(depth)) {
				nQueen(depth+1);
			}
		}
		return;
	}

	// 다른 퀸으로부터 위협받는지 검사하는 함수
	public static boolean Possibility(int col) {
		for(int i=0;i<col;i++) {
			// 해당 열의 행과 i열의 행이 일치할 경우(같은 행에 위치)
			if(arr[col] == arr[i]) {
				return false; // 퀸X
			}
			
			//대각선에 위치
			else if(Math.abs(col-i) == Math.abs(arr[col] - arr[i])) {
				return false;	// 퀸X
			}
		} // 그 외는 퀸 O
		return true;
	}
		
}
		