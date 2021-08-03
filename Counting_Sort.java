import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Counting_Sort {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		
		// 카운팅 정렬: 입력한 값을 배열의 인덱스로 하여 해당 입력 값의 빈도 수 (count) 이용하는 정렬
		int[] number = new int[10001];
		
		// 2입력하면 num[2] = 1 로 증가, 또 2 입력하면 num[2] = 2 로 증가 .... 
		for(int i=0;i<N;i++) {
			number[Integer.parseInt(br.readLine())]++;
		}
		
		StringBuilder sb = new StringBuilder();
		
		// 0은 입력되지 않음(입력 제한 -> 10000이하의 자연수)
		for(int i=1;i<10001;i++) {
			// num[2] = 2 -> 1 -> 0 이면 반복문x
			while(number[i] > 0) {
				sb.append(i+"\n");
				number[i]--;	// 입력된 i값의 빈도수가 0이 될때까지
			}
		}
		
		System.out.println(sb);
	}
}
		