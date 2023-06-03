import java.io.*;
import java.util.*;

public class Solution {

	static int sx,sy,ex,ey;
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			st = new StringTokenizer(br.readLine());
			sx = Integer.parseInt(st.nextToken())+100;
			sy = Integer.parseInt(st.nextToken())+100;
			ex = Integer.parseInt(st.nextToken())+100;
			ey = Integer.parseInt(st.nextToken())+100;
		
			int row = bfs(0);
			int col = bfs(1);
			System.out.println("#"+t+" "+(Math.min(row,col)));
		}
	}
	
	public static int bfs(int dir) {
		int cnt=0;
		Queue<int[]> q = new ArrayDeque<>();
		q.offer(new int[] {sx,sy});
		boolean[][] v = new boolean[201][201];
		v[sx][sy]=true;
		
		L:while(!q.isEmpty()) {
			int size = q.size();
			for(int s=0; s<size; s++) {
				int[] xy = q.poll();
				if(xy[0]==ex && xy[1]==ey) break L;
				for(int d=0; d<4; d=d+2) {
					int nx=xy[0]+dr[dir+d];
					int ny=xy[1]+dc[dir+d];
					if(nx>=0 && nx<201 && ny>=0 && ny<201 && !v[nx][ny]) {
						v[nx][ny]=true;
						q.offer(new int[] {nx,ny});
					}
				}
			}
			cnt++;
			dir=(dir+1)%2;
		}
		return cnt;
	}	
}