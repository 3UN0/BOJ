import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_2740 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st;
		// 행렬 A
		st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] aMat = new int[N][M];
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0;j<M;j++) {
				aMat[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 행렬 B
		st = new StringTokenizer(br.readLine(), " ");
		M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[][] bMat = new int[M][K];
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0;j<K;j++) {
				bMat[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		// 결과 행렬
		int[][] cMat = new int[N][K];
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<K;j++) {
				// 각 행/렬의 원소들 곱을 더하는 과정 (총 M개)
				for(int k=0;k<M;k++) { // 누적합
					cMat[i][j] += aMat[i][k]*bMat[k][j];
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<K;j++) {
				sb.append(cMat[i][j] + " ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
		
	}
	
	
}

