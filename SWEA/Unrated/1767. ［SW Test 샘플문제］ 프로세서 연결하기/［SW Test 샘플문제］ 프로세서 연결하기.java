import java.io.*;
import java.util.*;

public class Solution {
	
	static int N;
	static int cntCell;
	static int[][] map;
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	static ArrayList<Pos> list;
	
	static int maxCore;
	static int minWire;
	
	static class Pos {
		int x,y;

		public Pos(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			cntCell=0;
			list = new ArrayList<>();
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if(map[i][j]==1) {
						if(i==0 || j==0 || i==N-1 || j==N-1) continue;
						else {
							cntCell++;
							list.add(new Pos(i,j));
						}
					}
				}
			}
			maxCore = Integer.MIN_VALUE;
			minWire = Integer.MAX_VALUE;
			dfs(0,0,0);
			System.out.println("#"+t+" "+minWire);
		}
	}	
		
	public static void dfs(int depth, int cnt, int sum) {
		if(depth==cntCell) {
			if(cnt>maxCore) {
				maxCore = cnt;
				minWire = sum;
			}
			else if(cnt==maxCore) {
				minWire = Math.min(minWire, sum);
			}
			return;
		}
		
		int x = list.get(depth).x;
		int y = list.get(depth).y;
		
		for(int d=0; d<4; d++) {
			int nx = x;
			int ny = y;
			int count=0;
			
			while(true) {
				nx+=dr[d];
				ny+=dc[d];
				
				if(nx<0 || ny<0 || nx>=N || ny>=N) break;
				if(map[nx][ny]==1) {
					count=0;
					break;
				}
				count++;
			}
			
			if(count==0) {
				dfs(depth+1, cnt, sum);
			}
			else {
				int fill_x=x;
				int fill_y=y;
				for(int i=0; i<count; i++) {
					fill_x+=dr[d];
					fill_y+=dc[d];
					map[fill_x][fill_y]=1;
				}
				
				dfs(depth+1, cnt+1, sum+count);
				
				fill_x=x;
				fill_y=y;
				for(int i=0; i<count; i++) {
					fill_x+=dr[d];
					fill_y+=dc[d];
					map[fill_x][fill_y]=0;
				}
			}
		}
	}
}