import java.io.*;
import java.util.*;

public class Main {

	static int N, M;
	static int[][] map;
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	static int ans;
	static class Info {
		int x,y,cnt,wall;

		public Info(int x, int y, int cnt, int wall) {
			super();
			this.x = x;
			this.y = y;
			this.cnt = cnt;
			this.wall = wall;
		}
		
	}
		
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		for(int i=0; i<N; i++) {
			String str = br.readLine();
			for(int j=0; j<M; j++) {
				map[i][j] = str.charAt(j)-'0';
			}
		}
		
		ans = Integer.MAX_VALUE;
		bfs();
		System.out.println(ans==Integer.MAX_VALUE? -1:ans);
	}
	
	public static void bfs() {
		Queue<Info> q = new ArrayDeque<>();
		boolean[][][] v = new boolean[N][M][2];
		
		q.offer(new Info(0,0,1,0) );
		v[0][0][0] = true;
		
		while(!q.isEmpty()) {
			Info inf = q.poll();
			
			if(inf.x==N-1 && inf.y==M-1) {
				ans = Math.min(ans, inf.cnt);
				continue;
			}
			
			for(int d=0; d<4; d++) {
				int nx = inf.x+dr[d];
				int ny = inf.y+dc[d];
				
				if(nx>=0 && nx<N && ny>=0 && ny<M) {
					if(map[nx][ny]==0 && !v[nx][ny][inf.wall]) { // 맵의 0인 값이며, 방문하지 않았을때! (현재 inf의 wall 정보를 그대로 가져간다)
						v[nx][ny][inf.wall]=true;
						q.offer(new Info(nx, ny, inf.cnt+1, inf.wall));
					} 
					else if(map[nx][ny]==1 && inf.wall==0) { // 맵의 1인 값이며, 벽을 부쉈는지(1) / 안부쉈는지(0) + 맵이1인 경우는 당연 방문하지 않은 곳이다.
						v[nx][ny][1]=true;				// wall이 1인 경우는 벽을 이미 부쉈으므로 어차피 못간다.
						q.offer(new Info(nx, ny, inf.cnt+1, 1));
					}
				}
			}
		}
	}
}