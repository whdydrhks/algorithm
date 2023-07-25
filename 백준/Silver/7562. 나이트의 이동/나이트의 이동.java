import java.io.*;
import java.util.*;

public class Main {
	
	static int N;
	static int[] dr = {-2,-1,1,2,2,1,-1,-2};
	static int[] dc = {-1,-2,-2,-1,1,2,2,1,};
	
	static class Chess {
		int x, y;
		int cnt;
		
		public Chess(int x, int y, int cnt) {
			this.x=x;
			this.y=y;
			this.cnt=cnt;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			N = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			int sx = Integer.parseInt(st.nextToken());
			int sy = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			int ex = Integer.parseInt(st.nextToken());
			int ey = Integer.parseInt(st.nextToken());
			
			int ans = bfs(sx,sy,ex,ey);
			System.out.println(ans);
		}
	}
	
	public static int bfs(int sx, int sy, int ex, int ey) {
		int cnt=Integer.MAX_VALUE;
		Queue<Chess> queue = new ArrayDeque<>();
		queue.offer(new Chess(sx,sy,0));
		boolean[][] visited = new boolean[N][N];
		
		while(!queue.isEmpty()) {
			Chess chess = queue.poll();
			
			if(chess.x==ex && chess.y==ey) return chess.cnt;
			
			for(int d=0; d<8; d++) {
				int nx = chess.x + dr[d];
				int ny = chess.y + dc[d];
				int count = chess.cnt;
				
				if(nx<0 || ny<0 || nx>=N || ny>=N || visited[nx][ny]) continue;
				else if(nx>=0 && nx<N && ny>=0 && ny<N && !visited[nx][ny]) {
					queue.offer(new Chess(nx,ny,count+1));
					visited[nx][ny]=true;
				}
			}
		}
		
		return cnt;
	}
}