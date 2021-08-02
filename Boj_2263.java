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
		int N = Integer.parseInt(br.readLine());	// ��� ����
		
		inor = new int[100000]; // �ο���
		postor = new int[100000]; // ����Ʈ����
		preor = new int[100001]; // ��������

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
	
	
	// ���� ��ȸ
	public static void preOrder(int inStart, int inEnd, int postStart, int postEnd) {
		// ����, ���� ��ȸ�� �������� ���������� ũ�� �ȵ�
		if(inStart > inEnd || postStart > postEnd) {
			return;
		}
		
		// ��Ʈ ���ϱ�
		int root = postor[postEnd];
		sb.append(root + " ");
		
		// ���� ��ȸ -> ��Ʈ �ε��� ã��
		int rootidx = preor[root];
		
		// ���� ��ȸ -> ��Ʈ ���� ���ʿ� �� �� �ִ��� Ȯ��
		int left = rootidx - inStart;
		
		// ���� �ڽ� ��� ���ϱ�
		preOrder(inStart, rootidx-1, postStart, postStart+left-1);
		
		// ���� �½� ��� ���ϱ�
		preOrder(rootidx+1, inEnd, postStart+left, postEnd-1);

	}
	
}


