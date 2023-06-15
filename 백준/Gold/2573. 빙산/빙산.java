import java.io.*;
import java.util.*;

public class Main {

	static int N,M;
	static int cnt;
	static int ans;
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	static int[][] map;
	static ArrayList<Ice> list;
	
	static class Ice {
		int x,y;

		public Ice(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

		@Override
		public String toString() {
			return "Ice [x=" + x + ", y=" + y + "]";
		}
		
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		list = new ArrayList();
		cnt=0;
		ans=0;
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
				list.add(new Ice(i,j));
			}
		}
		
		int cnt=splitIce();
		while( (cnt=splitIce()) < 2 ) {
			BFS();
			ans++;
//			for(int[] m:map) System.out.println(Arrays.toString(m));
			if(check()) {
				ans=0;
				break;
			}
			
		}
		System.out.println(ans);
	}
	
	public static int splitIce() {
		int num=0;
		boolean[][] v = new boolean[N][M];
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(map[i][j]>0 && !v[i][j]) {
					DFS(v, i, j); // 매개변수의 v의 DFS 결과가 호출하는 splitIce()까지 결과가 이어진다.
					num++;
				}
			}
		}
		return num;
	}
	
	public static void DFS(boolean[][] v, int sx, int sy) {
		v[sx][sy] = true;
		
		for(int d=0; d<4; d++) {
			int nx = sx+dr[d];
			int ny = sy+dc[d];
			
			if(nx<0 || nx>=N || ny<0 || ny>=M) continue;
			
			if(nx>=0 && nx<N && ny>=0 && ny<M && !v[nx][ny] && map[nx][ny]>0) {
				DFS(v, nx, ny);
			}
		}
	}

	public static void BFS() {
		boolean[][] v = new boolean[N][M];
		Queue<Ice> q = new ArrayDeque();
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(map[i][j]>0) {
					v[i][j]=true;
					q.offer(new Ice(i,j));
				}
			}
		}
		
		while(!q.isEmpty()) {
			Ice ice = q.poll();
			
			int count=0;
			for(int d=0; d<4; d++) {
				int nx = ice.x+dr[d];
				int ny = ice.y+dc[d];
				
				if(nx<0 || nx>=N || ny<0 || ny>=M) continue;
				if(nx>=0 && nx<N && ny>=0 && ny<M && !v[nx][ny] && map[nx][ny]==0) {
					count++;
				}
			}
			
			map[ice.x][ice.y]-=count;
			if(map[ice.x][ice.y]<0) map[ice.x][ice.y]=0;
			
		}
	}
	
	public static boolean check() {
		int count=0;
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(map[i][j]>=1) {
					count++;
					if(count>=2) {
						return false;
					}
				}
			}
		}
		if(count<=1) return true;
		else return false;
	}
}
