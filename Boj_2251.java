import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static int[][] arr;
	public static int N, count;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[] bottle = new int[3];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i=0;i<3;i++) {
			bottle[i] = Integer.parseInt(st.nextToken());
		}
		// 물 옮길 수 있는 6가지 경우
		// c->a , c->b , b->a , b->c , a->b , a->c
		int[] from = {0, 0, 1, 1, 2, 2};
		int[] to = {1, 2, 0, 2, 0, 1};
		
		boolean[][] check = new boolean[201][201];
		boolean[] answer = new boolean[201];
		
		//bfs로 완전탐색
		Queue<Pair> q = new LinkedList<>();
		
		q.add(new Pair(0, 0));
		check[0][0] = true;
		// c 물통 방문 표시
		answer[bottle[2]] = true;
		
		while(!q.isEmpty()) {
			Pair p = q.poll();
			int nx = p.x;
			int ny = p.y;
			// c에 남은 물의 양 (총 물의 양 - a, b 물통 양)
			int nw = bottle[2] - nx - ny;
			
			for(int i=0;i<6;i++) {
				int[] next = {nx, ny, nw};
				// 물통 물 옮기기
				next[to[i]] += next[from[i]];
				next[from[i]] = 0;
				
				// 물통의 용량보다 물 많을 때 (넘칠 때)
				if(next[to[i]] > bottle[to[i]]) {
					// 넘친 양만큼 다시 넣어주고
					next[from[i]] = next[to[i]] - bottle[to[i]];
					// 용량에 가득 찬 물 넣어줌
					next[to[i]] = bottle[to[i]];
				}
				if(!check[next[0]][next[1]]) {
					check[next[0]][next[1]] = true;
					q.add(new Pair(next[0], next[1]));
					if(next[0] == 0) {
						answer[next[2]] = true;
					}
				}
			}
		}
		
		for(int i=0;i<=bottle[2];i++) {
			if(answer[i])
				System.out.print(i + " ");
		}
		
	}
}

class Pair{
	int x;
	int y;
	
	public Pair(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
