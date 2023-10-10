import java.io.*;
import java.util.*;

public class Solution {
	
	static int N,M,R,C,L;
	static int[][] map;
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	static int[][] direction = {
			{0,0,0,0},
			{1,1,1,1}, // +
			{1,0,1,0}, // |
			{0,1,0,1}, // ㅡ
			{1,1,0,0}, // ㄴ
			{0,1,1,0}, // F
			{0,0,1,1}, // ㄱ
			{1,0,0,1}  // d
	};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			map = new int[N][M];
			
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<M; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			int ans = bfs();
			System.out.println("#"+t+" "+ans);
		}
	}
	
	public static int bfs() {
		Queue<int[]> q = new ArrayDeque<>();
		boolean[][] v = new boolean[N][M];
		q.offer(new int[] {R,C});
		v[R][C]=true;
		int ans=1;
		int time=1;
		
		while(!q.isEmpty()) {
			int size = q.size();
			if(time==L) break;
			for(int s=0; s<size; s++) {
				int[] xy = q.poll();				
				for(int d=0; d<4; d++) {
					int[] next_dir = direction[map[xy[0]][xy[1]]];
					if(next_dir[d]==1) {
						int nx = xy[0]+dr[d];
						int ny = xy[1]+dc[d];
						
						if(nx>=0 && nx<N && ny>=0 && ny<M && !v[nx][ny]) {
							
							if(direction[map[nx][ny]][(d+2)%4]==1) {
								v[nx][ny]=true;
								q.offer(new int[] {nx, ny});
								ans++;
							}
							
						}
					}
				}
			}
			time++;
		}
		return ans;
	}
}