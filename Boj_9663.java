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
			
		N = Integer.parseInt(br.readLine());	// 1~N������ �ڿ���
		arr = new int[N];
		
		nQueen(0);
		System.out.println(count);
	}
	
		
	public static void nQueen(int depth) {
		// ���� �� ä��� ī��Ʈ ���� �� return
		if(depth == N) {
			count++;
			return;
		}
		
		for(int i=0;i<N;i++) {
			// ���� ���� index�� �Ͽ� �ش� ��ġ�� i��(ĭ) ����
			arr[depth]=i;
		
			// �ش� ������ i��° �࿡ ���� �� �ִ��� �˻��ϴ� �Լ� (���� �� ������ ����Լ� ȣ��)
			if(Possibility(depth)) {
				nQueen(depth+1);
			}
		}
		return;
	}

	// �ٸ� �����κ��� �����޴��� �˻��ϴ� �Լ�
	public static boolean Possibility(int col) {
		for(int i=0;i<col;i++) {
			// �ش� ���� ��� i���� ���� ��ġ�� ���(���� �࿡ ��ġ)
			if(arr[col] == arr[i]) {
				return false; // ��X
			}
			
			//�밢���� ��ġ
			else if(Math.abs(col-i) == Math.abs(arr[col] - arr[i])) {
				return false;	// ��X
			}
		} // �� �ܴ� �� O
		return true;
	}
		
}
		