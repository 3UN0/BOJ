import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Boj_1021 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		LinkedList<Integer> dq = new LinkedList<Integer>();		// LinkedList<String> dq = new LinkedList<>();
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int count = 0;
		
		for(int i=1;i<=N;i++) {
			dq.offer(i);	// 덱에 담은 수
		}
		
		int[] arr = new int[M];	// 찾으려는 수
		st = new StringTokenizer(br.readLine(), " ");
		for(int i=0;i<M;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=0;i<M;i++) {
			int half;		// 덱 중간 인덱스 기준으로 2 or 3 연산 결정
			
			if(dq.size() % 2 == 0) {	// 짝수 -> 1 2 3 4 일 때 2 (인덱스 1)
				half  = dq.size()/2 -1;
			} else {		//	 홀수 -> 1 2 3 일 때 2 (인덱스 1)
				half = dq.size()/2;
			}
			
			int target = dq.indexOf(arr[i]);	// 덱에서 뽑고자 하는 숫자의 index
			
			if(target <= half) {	// 중간 보다 찾으려는 원소 위치가 앞일 때 (...원소 ...중간점 ...)
				for(int j=0;j<target;j++) {	// 2번 연산 (앞 -> 뒤) 
					int temp = dq.pollFirst();
					dq.addLast(temp);
					count++;
				}
			} else {	// 중간점 보다 찾으려는 원소 위치가 뒤일 때 (...중간점...원소 ...)
				for(int j=dq.size()-1;j>=target;j--) {	// 3번 연산 (뒤 -> 앞)
					int temp = dq.pollLast();
					dq.addFirst(temp);
					count++;
				}
			}
			dq.pollFirst();	// 맨 앞 원소 삭제 (1번 연산) (첫 원소일 때 or 2/3번 연산 뒤에)
		}
		
		System.out.println(count);
		
	}
	
}
