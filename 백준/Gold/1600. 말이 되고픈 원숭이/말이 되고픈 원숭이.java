import java.io.*;
import java.util.*;

public class Main {
	static int K, W, H;
	static int[][] map;
						// 상(-1,0), 하(1,0), 좌(0,-1), 우(0,1), 좌최상(-2,-1) 좌상(-1,-2), 우최상(-2,1), 우상(-1,2), 좌최하(2,-1), 좌하(1,-2), 우최하(2,1) 우하(1,2)
	static int[] dr = {-1,1,0,0,-2,-1,-2,-1,2,1,2,1};
	static int[] dc = {0,0,-1,1,-1,-2,1,2,-1,-2,1,2};
	static int ans;
	
	static class Info {
		int x, y, skill, cnt;

		public Info(int x, int y, int skill, int cnt) {
			super();
			this.x = x;
			this.y = y;
			this.skill = skill;
			this.cnt = cnt;
		}

		@Override
		public String toString() {
			return "Info [x=" + x + ", y=" + y + ", skill=" + skill + ", cnt=" + cnt + "]";
		}
		
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		K = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		map = new int[H][W];
		for(int i=0; i<H; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<W; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		ans = Integer.MAX_VALUE;
		bfs();
		if(ans==Integer.MAX_VALUE) ans=-1;
		System.out.println(ans);
	}
	
	public static void bfs() {
		Queue<Info> q = new ArrayDeque();
		boolean[][][] v = new boolean[H][W][K+1];
		v[0][0][K]=true;
		q.offer(new Info(0,0,K,0));
		
		while(!q.isEmpty()) {
			Info inf = q.poll();
			//System.out.println(inf.toString());
			if(inf.x==H-1 && inf.y==W-1) {
				ans = Math.min(ans, inf.cnt);
				
			}
			
			for(int d=0; inf.skill>0? d<12:d<4; d++) {
				int nx = inf.x+dr[d];
				int ny = inf.y+dc[d];
				int nk = d<4? inf.skill:inf.skill-1;
				
				if(nx>=0 && nx<H && ny>=0 && ny<W && map[nx][ny]!=1 && !v[nx][ny][nk]) {
					v[nx][ny][nk]=true;
					q.offer(new Info(nx,ny,nk, inf.cnt+1));
//					if(d>=4) {
//						v[nx][ny]=true;
//						q.offer(new Info(nx,ny,inf.skill-1, inf.cnt+1));
//					}
//					else if(d<4) {
//						v[nx][ny]=true;
//						q.offer(new Info(nx,ny,inf.skill, inf.cnt+1));
//					}
				}
			}
			
		}
		
	}
}