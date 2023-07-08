import java.io.*;
import java.util.*;

public class Main {
	static int R=12, C=6;
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	static boolean[][] v;
	static char[][] map;
	static int answer=0;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		map = new char[R][C];
		
		for(int i=0; i<R; i++) {
			String str = br.readLine();
			for(int j=0; j<C; j++) {
				map[i][j]=str.charAt(j);
			}
		}
		// 1) 맵 전체 bfs 탐색을 한다. (방문 안한애, '.'가 아닌애)
		// 2) bfs는 cnt를 리턴하는데, 그 값이 0이면 탐색 종료
		// 2-1) bfs (i,j)을 기준으로 같은 색을 탐색. list에 좌표를 담는다.
		//		list의 사이즈가 4이상이면 '.'으로 좌표를 바꾸고 리턴.
		
		while(true) {
			v = new boolean[R][C];
			int cnt=0;
			for(int i=0; i<R; i++) {
				for(int j=0; j<C; j++) {
					if(!v[i][j] && map[i][j]!='.') {
						cnt += bfs(i,j);
					}
				}
			}
			
//			System.out.println("----after bfs---");
//			for(char[] m:map) System.out.println(Arrays.toString(m));
	
			if(cnt==0) break;
			gravity();
			
//			System.out.println("----after gravity---");
//			for(char[] m:map) System.out.println(Arrays.toString(m));
			
			answer++;
		}
		
		System.out.println(answer);
	}
	
	public static int bfs(int x, int y) {
		ArrayList<int[]> list = new ArrayList();
		Queue<int[]> q = new ArrayDeque();
		char color = map[x][y];
		v[x][y]=true;
		list.add(new int[] {x,y});
		q.offer(new int[] {x,y});		
		
		while(!q.isEmpty()) {
			int[] xy = q.poll();
			for(int d=0; d<4; d++) {
				int nx = xy[0]+dr[d];
				int ny = xy[1]+dc[d];
				
				if(nx>=0 && nx<R && ny>=0 && ny<C && map[nx][ny]==color && !v[nx][ny]) {
					v[nx][ny]=true;
					list.add(new int[] {nx,ny});
					q.offer(new int[] {nx, ny});
				}
			}
		}
		
		if(list.size()>=4) {
			for(int i=0; i<list.size(); i++) {
				map[list.get(i)[0]][list.get(i)[1]]='.';
			}
			return list.size();
		}
		else {
			return 0;
		}
	}
	
	public static void gravity() {
		for(int j=0; j<C; j++) { // 아래에서부터 위로 검사
			for(int i=R-1; i>=0; i--) {
				if(map[i][j]!='.') { // 빈칸이 아닌 애부터 위쪽의 결과를 땡긴다.
					int nextR = i;
					while(true) {
						nextR++; // 색깔을 찾고 그 위애부터 쭉 검사
						if(nextR>=0 && nextR<R && map[nextR][j]=='.') { // 범위 안이고 '.'이면 땡긴다. 
							map[nextR][j]=map[nextR-1][j];
							map[nextR-1][j]='.';
						}
						else {
							break;
						}		
					}
				}
			}
		}
	}
}
