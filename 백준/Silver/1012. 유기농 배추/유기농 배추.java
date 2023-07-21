import java.io.*;
import java.util.*;

public class Main {

	static int N,M,K; // 행,열,배추개수
	static int[][] map;
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			map = new int[N][M];
			for(int i=0; i<K; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				map[x][y]=1;
			}
			
			int cnt=0;
			boolean[][] v = new boolean[N][M];
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) {
					if(map[i][j]==1 && !v[i][j]) {
						dfs(v, i,j);
						cnt++;
					}
				}
			}
			
			sb.append(cnt).append("\n");
		}
		System.out.println(sb.toString());
	}
	
	public static void dfs(boolean[][] v, int x, int y) {
		v[x][y]=true;
		
		for(int d=0; d<4; d++) {
			int nx = x+dr[d];
			int ny = y+dc[d];
			if(nx>=0 && nx<N && ny>=0 && ny<M && map[nx][ny]==1 && !v[nx][ny]) {
				dfs(v,nx,ny);
			}
		}
		
		
	}
}
