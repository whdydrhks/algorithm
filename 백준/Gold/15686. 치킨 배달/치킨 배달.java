import java.io.*;
import java.util.*;

public class Main {
	static int N,M;
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	static int[][] map;
	static ArrayList<Pos> chickens;
	static ArrayList<Pos> homes;
	
	static int ans;
	static class Pos {
		int x, y;

		public Pos(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

		@Override
		public String toString() {
			return "Pos [x=" + x + ", y=" + y + "]";
		}
		
	}
	
	public static void main(String[] args) throws Exception {
		// 조합을 돈다 M개의 치킨을 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		chickens = new ArrayList();
		homes = new ArrayList();
		ArrayList<Pos> tmp = new ArrayList();
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j]==2) {
					chickens.add(new Pos(i,j));
				}
				else if(map[i][j]==1) {
					homes.add(new Pos(i,j));
				}
			}
		}
		
		ans = Integer.MAX_VALUE;
		
		recur(0,0, tmp);
		System.out.println(ans);
	}
	
	public static void recur(int depth, int start, ArrayList<Pos> tmp) {
		if(depth==M) {
			//System.out.println(tmp.toString());
			ans=Math.min(ans, calc(tmp));
			return;
		}
		
		for(int i=start; i<chickens.size(); i++) {
			tmp.add(chickens.get(i));
			recur(depth+1, i+1, tmp);
			tmp.remove(chickens.get(i));
		}
	}
	
	public static int calc(ArrayList<Pos> list) {
		int dist=0;
		for(int i=0; i<homes.size(); i++) {
			int tmp_dist=Integer.MAX_VALUE;
			for(int j=0; j<list.size(); j++) {
				int tmp = Math.abs(list.get(j).x-homes.get(i).x)+Math.abs(list.get(j).y-homes.get(i).y);
				tmp_dist=Math.min(tmp_dist, tmp);
			}
			dist+=tmp_dist;
		}
		return dist;
	}
}
