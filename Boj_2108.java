import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Boj_2108 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		
		int[] arr = new int[N];
		int[] number = new int[8002];
		ArrayList<Integer> list = new ArrayList<Integer>();
		int max=0;
		double sum=0;
		for(int i=0;i<N;i++) {
			arr[i]=Integer.parseInt(br.readLine());
			sum += arr[i];
			number[arr[i]+4000]++;
		}
		// »ê¼úÆò±Õ
		System.out.println((int)Math.round(sum/N));
		// Áß¾Ó°ª
		Arrays.sort(arr);
		System.out.println(arr[N/2]);
		
		//ÃÖºó°ª -2 1 2 3 8
		for(int i=0;i<8001;i++) {
			if(number[i]>=max) {
				max = number[i];
			}
		}
		for(int i=0;i<8001;i++) {
			if(number[i]==max) {
				list.add(i-4000);
			}
		}
		if(list.size()==1) {
			System.out.println(list.get(0));
		} else {
			System.out.println(list.get(1));
		}
		
		// ¹üÀ§
		System.out.println(arr[N-1]-arr[0]);
		
	}
}
		