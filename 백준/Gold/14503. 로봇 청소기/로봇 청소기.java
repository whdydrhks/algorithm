import java.io.*;
import java.util.*;

public class Main {
    static int N,M;
    static int r,c,d;
    static int[][] map;
    static int[] dr= {-1,0,1,0}; // 상우하좌
    static int[] dc= {0,1,0,-1};
    static int cnt;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        map = new int[N][M]; // 빈칸:0, 벽:1
        st = new StringTokenizer(br.readLine());
        r=Integer.parseInt(st.nextToken());
        c=Integer.parseInt(st.nextToken());
        d=Integer.parseInt(st.nextToken()); // 0:상, 1:우, 2:하, 3:좌

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++) {
                map[i][j]=Integer.parseInt(st.nextToken());
            }
        }

       cnt=1;
       dfs(r,c,d);
       System.out.println(cnt);
        
    }
    
    public static void dfs(int r, int c, int dir) {
    	// 현재 위치를 청소한다.
    	map[r][c]=2;
    	
    	// 현재 위치에서 내 방향 기준 왼쪽방향부터 차례로 탐색한다.
    	for(int d=0; d<4; d++) {
    		dir = (dir+3)%4; // 
    		int nx = r+dr[dir];
    		int ny = c+dc[dir];
    		
    		// 현재 청소가 안된곳.
    		if(nx>=0 && nx<N && ny>=0 && ny<M && map[nx][ny]==0) {
    			cnt++;
    			dfs(nx, ny, dir);
    			// return 하지 않으면 아래가 실행되서 후방을 청소하게 된다.
    			return;
    		}
    	}
    	
    	// 네 방향 모두 청소가 이미 되어있거나 벽인 경우에는
    	// 뒤쪽 칸이 벽이 아니라는 전제하에, 바라보는 방향을 유지한 채로 한 칸 후진
    	int backdir = (dir+2)%4;
    	int bx = r+dr[backdir];
    	int by = c+dc[backdir];
    	
    	if(bx>=0 && bx<N && by>=0 && by<M && map[bx][by]!=1) {
    		dfs(bx,by,dir);
    	}
    }
}