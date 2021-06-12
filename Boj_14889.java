import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_14889 {
	public static int N;
	public static int[][] arr;
	public static boolean[] visit;
	public static int MIN = Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
		N = Integer.parseInt(br.readLine());	// 1~N������ �ڿ���
		arr = new int[N][N];
		visit = new boolean[N];
		
		// �ɷ�ġ
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for(int j=0;j<N;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		
		dfs(0, 0);	
		
		System.out.println(MIN);
	}
	
		
	// idx : �ε���, count : ���� ����(��� ����)
	public static void dfs(int idx, int count) {
		// �� ���� �Ϸ�� ��
		if(count == N/2) {
			// �湮 ��, �湮x �� -> �� ���� ���� ���ϰ� �ּڰ�(����) ã��
			Score();
			return;
		}
		
		for(int i=idx;i<N;i++) {
			// �湮 x
			if(!visit[i]) {
				visit[i] = true;	// �湮���� ����
				dfs(i+1, count+1);	// ��� ȣ��
				visit[i] = false;	// ��� ȣ�� ������ �湮x�� ����
			}
			
		}
	}

	// �� ���� �ɷ�ġ ���
	private static void Score() {
		int team_start = 0;
		int team_link = 0;
		
		for(int i=0;i<N-1;i++) {
			for(int j=i+1;j<N;j++) {
				// i��° ����� j��° ����� true ��� ��ŸƮ�� ���� ����
				if(visit[i] == true && visit[j] == true) {
					team_start += arr[i][j];
					team_start += arr[j][i];
				}
				// i��° ����� j��° ����� false ��� ��ũ�� ���� ����
				else if(visit[i] == false && visit[j] == false) {
					team_link += arr[i][j];
					team_link += arr[j][i];
				}
			}
		}
		// �� ���� ���� ����
		int val = Math.abs(team_start - team_link);
		
		// �� ���� ������ 0�̶�� ���� ���� �ּڰ��̹Ƿ� Ž�� x -> 0 ��� �� ����
		if(val == 0) {
			System.out.println(val);
			System.exit(0);
		}
		MIN = Math.min(val, MIN);
		
	}

}
		