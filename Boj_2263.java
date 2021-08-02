import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Boj_2263 {
	public static StringBuilder sb = new StringBuilder();
	public static int[] preor;
	public static int[] inor;
	public static int[] postor;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());	// 노드 개수
		
		inor = new int[100000]; // 인오더
		postor = new int[100000]; // 포스트오더
		preor = new int[100001]; // 프리오더

		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine(), " ");
		for(int i=0;i<N;i++) {
			inor[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine(), " ");
		for(int i=0;i<N;i++) {
			postor[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=0;i<N;i++) {
			preor[inor[i]] = i;
		}
		
		preOrder(0, N-1, 0, N-1);
		
		System.out.println(sb);
	}
	
	
	// 전위 순회
	public static void preOrder(int inStart, int inEnd, int postStart, int postEnd) {
		// 중위, 후위 순회의 시작점은 종료점보다 크면 안됨
		if(inStart > inEnd || postStart > postEnd) {
			return;
		}
		
		// 루트 구하기
		int root = postor[postEnd];
		sb.append(root + " ");
		
		// 중위 순회 -> 루트 인덱스 찾기
		int rootidx = preor[root];
		
		// 중위 순회 -> 루트 기준 왼쪽에 몇 개 있는지 확인
		int left = rootidx - inStart;
		
		// 좌측 자식 노드 구하기
		preOrder(inStart, rootidx-1, postStart, postStart+left-1);
		
		// 우측 좌식 노드 구하기
		preOrder(rootidx+1, inEnd, postStart+left, postEnd-1);

	}
	
}


