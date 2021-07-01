import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_6549 {
	final static int number = 1000000007;
	public static long[] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n;
		StringBuilder sb = new StringBuilder();
		while(true) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			if(n==0) {
				break;
			}
			
			arr = new long[n];
			
			for(int i=0;i<n;i++) {
				arr[i] = Long.parseLong(st.nextToken());
			}
			sb.append(getArea(0, n-1) + "\n");
			arr = null;	// 배열 초기화
		}
		System.out.println(sb);
	}

	// 넓이 구하는 분할 정복
	public static long getArea(int lo, int hi) {
		
		// 막대 폭이 1일 경우 높이 -> 넓이
		if(lo == hi) {
			return arr[lo];
		}
		
		// 1. 막대 그래프에서 중간 지점 구하기
		int mid = (lo + hi)/2;
		
		// 2. mid 기준으로 왼쪽-오른쪽 넓이 구함 (lo~mid / mid+1~hi)  1 2 3 4 5 (1 2 3 / 4 5)
		long left = getArea(lo, mid);
		long right = getArea(mid+1, hi);
	
		// 3. 2에서 구한 넓이 중 큰 넓이 저장
		long maxarea = Math.max(left, right);
		
		// 4. 3에서 구한 넓이와 구간 전체 넓이 (lo~hi) 중 큰 값 저장
		// mid 막대의 넓이 구하기 -> 양쪽 중 높이가 큰 쪽으로 확장 -> 갱신 높이는 기존 높이와 확장 막대의 높이 중 작은 것 선택 -> 기존/확장 넓이 중 큰 값 선택
		maxarea = Math.max(maxarea, midArea(lo, hi, mid));
		return maxarea;
		
	}
	
	// 중간 인덱스 기준으로 넓이 구하기
	public static long midArea(int lo, int hi, int mid)	{
		int toLeft = mid;	// 중간->왼
		int toRight = mid;	// 중간->오
		
		long height = arr[mid];	// 기존 높이
		
		long area = height;	// 초기 넓이 (너비 1, 높이->넓이)
		
		// 양 끝 범위 벗어나기 전까지 반복
		while(lo < toLeft && toRight < hi) {
			// 양쪽 높이 중 큰 값 선택 -> 갱신 높이는 기존 높이보다 작거나 같은 것
			if(arr[toLeft - 1] < arr[toRight+1]) {
				 toRight++;
				 height = Math.min(height, arr[toRight]);
			} else {
				toLeft--;
				height = Math.min(height, arr[toLeft]);
			}
			// 최대 넓이 갱신
			area = Math.max(area, height * (toRight - toLeft + 1)); 
		}
		// 오른쪽 구간 끝까지 탐색 못했을 경우 마저 탐색
		while(toRight < hi) {
			toRight++;
			height = Math.min(height, arr[toRight]);
			area = Math.max(area, height * (toRight - toLeft + 1));
		}
		
		// 왼쪽 구간 끝까지 탐색 못했을 경우 마저 탐색
		while(toLeft > lo) {
			toLeft--;
			height = Math.min(height, arr[toLeft]);
			area = Math.max(area, height * (toRight - toLeft + 1));
		}
		
		return area;
	}
}

