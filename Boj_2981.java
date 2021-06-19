import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Boj_2981 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		
		// M : (6-34) 와 (34-38)의 공약수 (최대공약수 찾고 이것의 약수들 찾으면 됨)
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(arr);	// 음수되지 않도록 정렬
		
		int gcd = arr[1] - arr[0]; // 음수되지 않도록 큰 수 - 작은 수
		
		for(int i=2;i<N;i++) {
			gcd = gcd(gcd, arr[i] - arr[i-1]);	// 최대공약수와 다음 수들의 최대공약수를 구해서 갱신
		}
		
		// 최대공약수의 약수들 찾기
		for(int i=2;i<=gcd;i++) {
			if(gcd % i == 0) {
				System.out.print(i + " ");
			}
		}
		

		/*StringBuilder sb = new StringBuilder();
		
		// 최대공약수의 약수들 찾기 (절반까지만 탐색)
		for(int i = 2; i <= gcd / 2; i++) {
	    
			if(gcd % i == 0) {
				sb.append(i + " ");
			}
		}
		
		// 마지막 최대공약수 꼭 출력해야함
		sb.append(gcd);
        
		System.out.println(sb);*/
		
	}
	
	public static int gcd(int a, int b) {
		int tmp;
		
		if(a<b) {
			tmp = a;
			a = b;
			b = tmp;
		}
		while(b!=0) {
			int r = a%b;
			a = b;
			b = r;
		}
		return a;
	}
	
	
}

		