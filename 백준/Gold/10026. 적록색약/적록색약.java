import java.io.*;
import java.util.*;

public class Main {

	static int N;
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		char[][] arr = new char[N][N];
		boolean[][] normal_visited = new boolean[N][N];
		boolean[][] rg_visited = new boolean[N][N];
		int count=0, rg_count=0;
		
		for(int i=0; i<N; i++) {
			String str = br.readLine();
			for(int j=0; j<N; j++) {
				arr[i][j] = str.charAt(j); 
			}
		}
		
		// 일반인
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(arr[i][j]=='R' && !normal_visited[i][j]) {
					bfs(i,j,arr, normal_visited, 'R');
					count++;
				}
				else if(arr[i][j]=='G' && !normal_visited[i][j]) {
					bfs(i,j,arr, normal_visited, 'G');
					count++;
				}
				else if(arr[i][j]=='B' && !normal_visited[i][j]) {
					bfs(i,j,arr, normal_visited, 'B');
					count++;
				}
			}
		}
		
		// 적록색약
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if((arr[i][j]=='R' || arr[i][j]=='G') && !rg_visited[i][j]) {
					rg_bfs(i,j,arr, rg_visited, arr[i][j]);
					rg_count++;
				}
				else if(arr[i][j]=='B' && !rg_visited[i][j]) {
					rg_bfs(i,j,arr, rg_visited, 'B');
					rg_count++;
				}
			}
		}
		
		System.out.println(count+" "+rg_count);
	}
	
	public static void bfs(int r, int c, char[][] arr, boolean[][] v, char color) {
		Queue<int[]> queue = new ArrayDeque<>();
		queue.offer(new int[] {r,c});
		v[r][c]=true;
		
		while(!queue.isEmpty()) {
			int[] rc = queue.poll();
			
			for(int d=0; d<4; d++) {
				int nr = rc[0]+dr[d];
				int nc = rc[1]+dc[d];
				
				if(nr<0 || nr>=N || nc<0 || nc>=N || v[nr][nc] || arr[nr][nc]!=color) continue;
				else if(nr>=0 && nr<N && nc>=0 && nc<N && !v[nr][nc] && arr[nr][nc]==color) {
					queue.offer(new int[] {nr, nc});
					v[nr][nc]=true;
				}
			}
		}
	}
	
	public static void rg_bfs(int r, int c, char[][] arr, boolean[][] v, char color) {
		Queue<int[]> queue = new ArrayDeque<>();
		queue.offer(new int[] {r,c});
		v[r][c]=true;
		
		while(!queue.isEmpty()) {
			int[] rc = queue.poll();
			
			for(int d=0; d<4; d++) {
				int nr = rc[0]+dr[d];
				int nc = rc[1]+dc[d];
				
				if(color=='R' || color=='G') {
					if(nr<0 || nr>=N || nc<0 || nc>=N || v[nr][nc] || arr[nr][nc]=='B') continue;
					else if(nr>=0 && nr<N && nc>=0 && nc<N && !v[nr][nc] && arr[nr][nc]!='B') {
						queue.offer(new int[] {nr, nc});
						v[nr][nc]=true;
					}
				}
				else {
					if(nr<0 || nr>=N || nc<0 || nc>=N || v[nr][nc] || arr[nr][nc]!='B') continue;
					else if(nr>=0 && nr<N && nc>=0 && nc<N && !v[nr][nc] && arr[nr][nc]=='B') {
						queue.offer(new int[] {nr, nc});
						v[nr][nc]=true;
					}
				}
			}
		}
	}
}