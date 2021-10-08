import java.io.IOException;
import java.util.ArrayList;

public class Reculsion {
	public static void main(String[] args) throws IOException {
		
		ArrayList<String> str = new ArrayList<>();
		
		str.add("a");
		str.add("b");
		str.add("c");
		
		ArrayList<String> result = new ArrayList<>();
		// 전체 원소 중 2개 선택
		recursion(str, result, str.size(), 2);
	}

	// 순열 구하기
	// 원본 리스트, 결과 리스트, 전체 갯수, 뽑을 갯수
	public static void recursion(ArrayList<String> str, ArrayList<String> result, int n, int p) {
		// 뽑을 갯수 0 일 경우
		if(p == 0) {
			// list에 있는 원소 순서대로 출력됨
			System.out.println(result.toString());
			return;
		}
		// 재귀 호출로 원소 결과 리스트에 입력
		// 적용되는 기준 원소 계속 바뀜 -> 1) a .. 2) b .. 
		for(int i=0;i<n;i++) {
			result.add(str.remove(i));
			recursion(str, result, n-1, p-1);
			// 가장 최근에 빠진 원소(result의 마지막 원소) 다시 있던 자리에 복구
			str.add(result.remove(result.size()-1));
		}
		
	}
	
	// 중복 순열 구하기
	// 원본 리스트, 결과 리스트, 전체 갯수, 뽑을 갯수
	public static void recursionOver(ArrayList<String> str, ArrayList<String> result, int n, int p) {
		// 뽑을 갯수 0 일 경우
		if(p == 0) {
			// list에 있는 원소 순서대로 출력됨
			System.out.println(result.toString());
			return;
		}
		// 재귀 호출로 원소 결과 리스트에 입력
		// 적용되는 기준 원소 계속 바뀜 -> 1) a .. 2) b .. 
		for(int i=0;i<n;i++) {
			result.add(str.get(i));
			recursion(str, result, n, p-1);
			// 가장 최근에 빠진 원소(result의 마지막 원소) 삭제
			result.remove(result.size()-1);
		}
		
	}

}
