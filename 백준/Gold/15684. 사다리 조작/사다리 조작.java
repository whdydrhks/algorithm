import java.io.*;
import java.util.*;

public class Main {
	static int N,M,H;
	static int[][] map;
	static int ans;
	static boolean flag;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		
		map = new int[H][N];
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken())-1;
			int y = Integer.parseInt(st.nextToken())-1;
			map[x][y]=1;
			map[x][y+1]=-1;
		}
		
		ans = -1;
		flag = false;
		for(int i=0; i<=3; i++) {
			recur(0,0,0,i);
			if(flag) {	
				break;
			}
		}
		System.out.println(ans);
		
	}
	
	public static void recur(int x, int y, int depth, int limit) {
		if(flag) return;
		
		if(depth==limit) {
			// 모든 열 체크
//			for(int[] m:map) System.out.println(Arrays.toString(m));
//			System.out.println();
			for(int col=0; col<N; col++) {
				if(!colCheck(col)) return;
			}
			ans = limit;
			flag=true;
			
			return;
		}
		
		for(int row=x; row<H; row++) {
			for(int col=y; col<N-1; col++) {
				if(map[row][col]==0 && map[row][col+1]==0) {					
					map[row][col]=1;
					map[row][col+1]=-1;
					recur(row,col+2,depth+1,limit);
					
					map[row][col]=0;
					map[row][col+1]=0;
				}		
			}		
			y=0;
		}
	}
	
	public static boolean colCheck(int start) {
		int col=start;
		for(int r=0; r<H; r++) {
			if(map[r][start]==0) { // 0이면 한 칸 아래로
				continue;
			}
			else if(map[r][start]==1) { // 1이면 오른쪽으로.
				start+=map[r][start];
			}
			else if(map[r][start]==-1) {
				start+=map[r][start];
			}
		}
		
		if(start==col) return true;
		else return false;
	}
}
