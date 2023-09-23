import java.io.*;
import java.util.*;

public class Main {
	static int R,C,T; // 행
	static int[][] map;
	static class Machine {
		int upX, upY;
		int downX, downY;
		public Machine(int upX, int upY, int downX, int downY) {
			super();
			this.upX = upX;
			this.upY = upY;
			this.downX = downX;
			this.downY = downY;
		}
	}
	
	static Machine machine;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		
		map = new int[R][C];
		boolean isMachine=false;
		machine = null;
		for(int i=0; i<R; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<C; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j]==-1 && !isMachine) { // (0,0) ~ (R,C) 위에서부터 검사하므로 downX는 +1
					machine = new Machine(i,j,i+1,j);
					map[i+1][j]=-1;
					isMachine=true;
				}
			}
		}
		
//		System.out.println("-----origin------");
//		for(int[] m:map) System.out.println(Arrays.toString(m));
		
		for(int t=1; t<=T; t++) {
//			System.out.println("!!!!!!!--- "+t+" !!!!!!!!!!!!!");
			map=dust();
//			System.out.println("--------after dust--------");
//			for(int[] m:map) System.out.println(Arrays.toString(m));
			cleaner();
//			System.out.println("----------after cleaner----------");
//			for(int[] m:map) System.out.println(Arrays.toString(m));
//			System.out.println();
		}
		int ans=0;
		for(int[] ma:map) {
			for(int m:ma) {
				if(m>0) ans+=m; 
			}
		}
		System.out.println(ans);
	}
	
	public static int[][] dust() {
//		미세먼지가 확산된다. 확산은 미세먼지가 있는 모든 칸에서 "동시에" 일어난다. - 하나의 영향이 다른 실행에도 영향을 끼칠 수 있다.
//		(r, c)에 있는 미세먼지는 인접한 네 방향으로 확산된다.
		int[] dr = {-1,0,1,0};
		int[] dc = {0,1,0,-1};
//		인접한 방향에 공기청정기가 있거나, 칸이 없으면 그 방향으로는 확산이 일어나지 않는다.
//		확산되는 양은 Ar,c/5이고 소수점은 버린다.
//		(r, c)에 남은 미세먼지의 양은 Ar,c - (Ar,c/5)×(확산된 방향의 개수) 이다.
		int[][] newmap = new int[R][C]; // 새로운 맵에 값을 추가하는 방식.
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				if(map[i][j]>0) {
					int res = map[i][j]/5;
					int cnt=0;
					for(int d=0; d<4; d++) {
						int nx = i+dr[d];
						int ny = j+dc[d];
						
						if(nx<0 || nx>=R || ny<0 || ny>=C || map[nx][ny]==-1) continue;
						if(nx>=0 && nx<R && ny>=0 && ny<C && map[nx][ny]!=-1) {
							cnt++;
							newmap[nx][ny]+=res;
						}
						
					}
					newmap[i][j]+=map[i][j]-(cnt*res);
					
				}
			}
		}
		newmap[machine.upX][machine.upY]=-1;
		newmap[machine.downX][machine.downY]=-1;
		return newmap;
	}

	public static void cleaner() {
		// 공기청정기는 항상 1번 열에 설치되어 있고, 크기는 "두 행"을 차지한다
//		공기청정기가 작동한다.
//		공기청정기에서는 바람이 나온다.
		windUp();
		windDown();	
		
//		위쪽 공기청정기의 바람은 반시계방향으로 순환하고, 아래쪽 공기청정기의 바람은 시계방향으로 순환한다.
//		바람이 불면 미세먼지가 바람의 방향대로 모두 한 칸씩 이동한다.
//		공기청정기에서 부는 바람은 미세먼지가 없는 바람이고, 공기청정기로 들어간 미세먼지는 모두 정화된다.
		
	}
	
	public static void windUp() {
		int sx = machine.upX;
		int sy = machine.upY;
		// 상, 우, 하, 좌
		for(int d=0; d<4; d++) {
			if(d==0) { // 상 - 위에를 아래로 넣기.
				for(int i=sx+1; i>=0; i--) {
					map[i+1][0]=map[i][0];
				}
			}
			else if(d==1) { // 우 - 오른쪽을 왼쪽으로 넣기
				for(int i=1; i<=C-1; i++) {
					map[0][i-1]=map[0][i];
				}
			}
			else if(d==2) { // 하 - 아래를 위로
				for(int i=1; i<=sx; i++) {
					map[i-1][C-1]=map[i][C-1];
				}
			}
			else if(d==3) { // 좌 - 왼쪽을 오른쪽으로
				for(int i=C-2; i>=1; i--) {
					map[sx][i+1]=map[sx][i];
				}
			}
		}
		map[sx][sy+1]=0;
		map[sx][sy]=-1;
	}
	
	public static void windDown() {
		int sx = machine.downX;
		int sy = machine.downY;
		// 하, 우, 상, 좌
		for(int d=0; d<4; d++) {
			if(d==0) { // 하 - 아래를 위로
				for(int i=sx+1; i<=R-1; i++) {
					map[i-1][0]=map[i][0];
				}
			}
			else if(d==1) { // 우 - 오른쪽을 왼쪽으로 넣기
				for(int i=1; i<=C-1; i++) {
					map[R-1][i-1]=map[R-1][i];
				}
			}
			else if(d==2) { // 상 - 위를 아래로
				for(int i=R-2; i>=sx; i--) {
					map[i+1][C-1]=map[i][C-1];
				}
			}
			else if(d==3) { // 좌 - 왼쪽을 오른쪽으로
				for(int i=C-2; i>=1; i--) {
					map[sx][i+1]=map[sx][i];
				}
			}
		}
		map[sx][sy+1]=0;
		map[sx][sy]=-1;
	}
}
/* 
7 8 1
2 3 4 5 6 7 8 9
1 0 0 0 3 0 0 8
-1 1 2 3 4 5 6 7
-1 1 2 3 4 5 6 7
3 0 0 0 0 10 4 8
2 0 5 0 15 0 0 9
1 2 3 4 5 6 7 8 
*/