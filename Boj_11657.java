import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj_11657 {
	public static int N, M;
	public static long[] dis;	// �ִܰŸ� ����
	public static StringBuilder sb = new StringBuilder();
	public static ArrayList<Node11657>[] list;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());	// ������ ����
		M = Integer.parseInt(st.nextToken());	// ������ ����

		list = new ArrayList[N+1];
		dis = new long[N+1];	// 1~N ����
		Arrays.fill(dis, Integer.MAX_VALUE);
		
		for(int i=1;i<=N;i++) {
			list[i] = new ArrayList<Node11657>();
		}
		
		// ���� to ���� �ִܰ�� (���) -> ���� ����Ŭ ������ ���� ���� -> ���ͽ�Ʈ��X, ��������O
		// ����-���� �˰���: �ִܰŸ��� �������� �����ϴ� �ּҺ���� �����ϴ� (��� ���� ���� ��� �������� �� ����)
		// V���� ������ ��尡 E���� ��� ������ �̿��Ͽ� �ּҺ�� ���� (���� ��� �����X) (���� 1��, 2�� .. n��)
		// ���� ����Ŭ ���ٸ� V�� ��ŭ ���� ���� ���� ���� -> V�� ���� ���鼭 ������Ʈ �ȴ� = ���� ����Ŭ ����
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine(), " ");
			// ���� ����
			int a = Integer.parseInt(st.nextToken());	// start
			int b = Integer.parseInt(st.nextToken());	// end
			int c = Integer.parseInt(st.nextToken());	// �ð� (weight)
			
			list[a].add(new Node11657(b, c));
		}
		
		if(bellmanFord()) {
			sb.append("-1\n"); // ���� X
		} else {
			for(int i=2;i<=N;i++) {
				if(dis[i] == Integer.MAX_VALUE) {
					sb.append("-1\n");
				} else {
					sb.append(dis[i] + "\n");
				}
			}
		}
		
		System.out.println(sb);
		

	}
	
	// ����-���� �˰���
	public static boolean bellmanFord() {
		// ó�� �ִ� �Ÿ� �Է�
		dis[1] = 0;
		boolean update = false;
		
		// ��� ���� N��ŭ ������Ʈ (check ������ ǥ��)
		for(int i=1; i<=N; i++) {
			update = false;
			for(int j=1; j<=N; j++) {
				for(Node11657 node : list[j]) {
					// update �� �ǰ� �ʱⰪ �״���� ���
					if(dis[j] == Integer.MAX_VALUE) {
						break;
					}
					// update ���� (�ּ� ��� ����)
					if(dis[node.end] > dis[j] + node.weight) {
						dis[node.end] = dis[j] + node.weight;
						update = true;
					}
				}
			}
			if(!update) {	// ������Ʈ �߻� X
				break;
			}
		}
		// N==2 �� �� ��������Ŭ ��� update = true �̹Ƿ� ���� �߰�
		// N-1 ��°���� �������� �� ������ ������ N��°�� ������Ʈ �ϹǷ� ���� ����Ŭ �����Ѵٰ� ������ �� ����
		return update && N>2 ? true : false;
	}
	
}

class Node11657 implements Comparable<Node11657>{
	int end;
	int weight;
	
	public Node11657(int end, int weight) {
		this.end = end;
		this.weight = weight;
	}
	// weight ������ ����
	@Override
	public int compareTo(Node11657 o) {
		return weight-o.weight;
	}
	
}
