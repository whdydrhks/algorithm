import java.io.*;
import java.util.*;

public class Main {
	
	static int N,M,K;
	static int[][] arr;
	static boolean[] v;
	static ArrayList<Operation> a;
	static ArrayList<Operation> b;
	static int ans;
	static int limit;
	
	static class Operation {
		int r,c,s;

		public Operation(int r, int c, int s) {
			super();
			this.r = r;
			this.c = c;
			this.s = s;
		}

		@Override
		public String toString() {
			return "Operation [r=" + r + ", c=" + c + ", s=" + s + "]";
		}
		
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		arr = new int[N][M];
		a = new ArrayList();
		b = new ArrayList();
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=0; i<K; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			a.add(new Operation(r,c,s));
		}
		v = new boolean[a.size()];
		ans = Integer.MAX_VALUE;
		limit = a.size();
		perm(0);
		
//		for(int[] ar:arr) System.out.println(Arrays.toString(ar));
		System.out.println(ans);
		
	}
	
	public static void perm(int depth) {
		if(depth==a.size()) {
			int[][] tmp_arr = new int[N][M];
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) {
					tmp_arr[i][j]=arr[i][j];
				}
			}
			int res = calc(tmp_arr);
			
			
			ans = Math.min(res, ans);
			
//			System.out.println(b.toString());
			
			return;
		}
		
		for(int i=0; i<a.size(); i++) {
			if(v[i]) continue;
			v[i]=true;
			b.add(a.get(i));
			perm(depth+1);
			v[i]=false;
			b.remove(a.get(i));
		}
	}
	
	public static int calc(int[][] tmp_arr) {
		// 담긴 b에 대한 recur 연산.
		// 그냥 배열을 돌리기만 하고 합은 따로 하는게 나을듯.
		for(int i=0; i<b.size(); i++) {
			int lx = b.get(i).r - b.get(i).s;
			int ly = b.get(i).c - b.get(i).s;
			int rx = b.get(i).r + b.get(i).s;
			int ry = b.get(i).c + b.get(i).s;
			
			recur(lx-1,ly-1,rx-1,ry-1, tmp_arr);
						
		}
		
//		for(int[] tmp:tmp_arr) System.out.println(Arrays.toString(tmp));
		
		// 행 합
		int min = Integer.MAX_VALUE;
		for(int i=0; i<N; i++) {
			int tmp=0;
			for(int j=0; j<M; j++) {
				tmp+=tmp_arr[i][j];
			}
			min = Math.min(min, tmp);
		}
		
		return min;
	}
	
	public static void recur(int lx, int ly, int rx, int ry, int[][] tmp_arr) {
		
		if(lx==rx && ly==ry) return;
		
		int[] dr = {1,0,-1,0};
		int[] dc = {0,1,0,-1};
		
		int x = lx;
		int y = ly;
		int val = tmp_arr[lx][ly];
		
		for(int d=0; d<4; d++) {
			while(true) {
				int nx = x+dr[d];
				int ny = y+dc[d];
				
				if(nx>=lx && nx<=rx && ny>=ly && ny<=ry) {
					tmp_arr[x][y]=tmp_arr[nx][ny];
					x=nx;
					y=ny;
				}
				else break;
			}
		}
		tmp_arr[lx][ly+1]=val;
		
//		if(lx>=rx || ly>=ry) return;
		recur(lx+1, ly+1, rx-1, ry-1, tmp_arr);
	}	
}
