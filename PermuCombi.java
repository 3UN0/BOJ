import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class PernuCombi {
	static int[] arr = {1, 2, 3, 4, 5};
	public static void main(String[] args) throws IOException {
		int[] temp = new int[3];
		boolean[] visit = new boolean[arr.length];
		// 순열 
		//permutation(temp, 3, 0, visit);
		// 중복 순열
		//permutation2(temp, 3, 0);
		// 조합
		//combination(temp, 3, 0, 0);
		// 중복 조합
		//combination2(temp, 3, 0, 0);
		
		
	}
	// 순열 구하기 : 순서 고려하여 n개 중 r개 뽑기 (1,2,3 =/= 1,3,2) (r개 뽑아서 순서 다르게 정렬)
	// 결과값 저장 배열, 뽑을 갯수, 현재 갯수, 방문 배열
	public static void permutation(int[] temp, int r, int current, boolean[] visit) {
		// 다 뽑았을 경우
		if(r == current) {
			//배열에 있는 원소 순서대로 출력됨
			System.out.println(Arrays.toString(temp));
		} else {
		// 재귀 호출로 원소 결과 배열에 추가
		// 적용되는 기준 원소 계속 바뀜 -> 1) a .. 2) b .. 
			for(int i=0;i<arr.length;i++) {
				if(!visit[i]) {
					visit[i] = true;
					temp[current] = arr[i];
					permutation(temp, r, current + 1, visit);
				visit[i] = false;
				}
			}
		}
	}
	
	
	// 중복순열 구하기 : 순서 고려하여 중복 포함 n개 중 r개 뽑기 (1,2,2 =/= 2,1,1) (중복된 r개 뽑아서 순서 다르게 정렬)
	// 결과값 저장 배열, 뽑을 갯수, 현재 갯수, 방문 배열
	public static void permutation2(int[] temp, int r, int current) {
		// 다 뽑았을 경우
		if(r == current) {
			//배열에 있는 원소 순서대로 출력됨
			System.out.println(Arrays.toString(temp));
		} else {
		// 재귀 호출로 원소 결과 리스트에 입력
		// 적용되는 기준 원소 계속 바뀜 -> 1) a .. 2) b .. 
			for(int i=0;i<arr.length;i++) {
				temp[current] = arr[i];
				permutation2(temp, r, current + 1);
			}
		}
	}
	
	// 조합 구하기 : 순서 상관없이 n개 중 r개 뽑기 (1,2,3 = 1,3,2) (1,1,2 : X)
	// 결과값 저장 배열, 뽑을 갯수, 현재 갯수, 그 다음 반복분  시작하는 값
	public static void combination(int[] temp, int r, int current, int start) {
		// 다 뽑았을 경우
		if(r == current) {
			System.out.println(Arrays.toString(temp));
		} else {
			// 조합 (중복x 고려)
			for(int i=start;i<arr.length;i++) {
				temp[current] = arr[i];
				// i+1 -> 이미 사용한 값 다시 사용x (조합 조건)
				combination(temp, r, current+1, i+1);
			}
		}
	}
	
	
	// 중복조합 구하기 : 순서 상관없이 중복 포함 n개 중 r개 뽑기 (1,1,2 : O)
	// 결과값 저장 배열, 뽑을 갯수, 현재 갯수, 그 다음 반복분  시작하는 값
	public static void combination2(int[] temp, int r, int current, int start) {
		// 다 뽑았을 경우
		if(r == current) {
			System.out.println(Arrays.toString(temp));
		} else {
			// 중복 고려
			for(int i=start;i<arr.length;i++) {
				temp[current] = arr[i];
				// i -> 중복 가능
				combination(temp, r, current+1, i);
			}
		}
	}
	
	
	
}
