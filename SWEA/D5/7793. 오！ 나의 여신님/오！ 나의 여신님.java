import java.io.*;
import java.util.*;

public class Solution {

	static int N,M;
	static int sx, sy;
	static int ex, ey;
	static char[][] map;
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};

	static ArrayList<Pos> devil;
	static int ans;
	
	static class Pos {
		int x,y,cnt;
		char type;

		public Pos(int x, int y, int cnt, char type) {
			super();
			this.x = x;
			this.y = y;
			this.cnt = cnt;
			this.type=type;
		}

		@Override
		public String toString() {
			return "Pos [x=" + x + ", y=" + y + "]";
		}
		
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			map = new char[N][M];
			
			devil = new ArrayList<>();
			for(int i=0; i<N; i++) {
				String str = br.readLine();
				for(int j=0; j<M; j++) {
					map[i][j] = str.charAt(j);
					if(map[i][j]=='S') {
						sx=i;
						sy=j;
					}
					else if(map[i][j]=='D') {
						ex=i;
						ey=j;
					}
					else if(map[i][j]=='*') {
						devil.add(new Pos(i,j,0,'*'));
					}
				}
			}
			
			ans = Integer.MIN_VALUE;
			bfs();
			System.out.println("#"+t+" "+ (ans==Integer.MIN_VALUE? "GAME OVER":ans));
		}
		
	
	}
	
	public static void bfs() {
		Queue<Pos> q = new ArrayDeque<>();
		boolean[][] v = new boolean[N][M];
		q.addAll(devil);
		q.add(new Pos(sx,sy,0,'S'));
		v[sx][sy]=true;
		
		L:while(!q.isEmpty()) {
			int size = q.size();
			for(int s=0; s<size; s++) {
				Pos p = q.poll();
				
				if(p.x==ex && p.y==ey) {
					ans = p.cnt;
					break L;
				}
				
				for(int d=0; d<4; d++) {
					int nx=p.x+dr[d];
					int ny=p.y+dc[d];
					if(nx>=0 && nx<N && ny>=0 && ny<M) {
						if(p.type=='*'&&map[nx][ny]!='X' && map[nx][ny]!='D' && map[nx][ny]!='*') {
							map[nx][ny]='*';
							q.offer(new Pos(nx,ny,0,'*'));
						}
						else if(p.type=='S' && map[nx][ny]!='X' && map[nx][ny]!='*' && !v[nx][ny]) {
							v[nx][ny]=true;
							map[nx][ny]='S';
							q.offer(new Pos(nx, ny,p.cnt+1, 'S'));
						}
					}
				}
			}
		}
		return;		
	}
}
