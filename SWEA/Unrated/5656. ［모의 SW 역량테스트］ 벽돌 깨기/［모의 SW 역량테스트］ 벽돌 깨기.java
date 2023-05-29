import java.util.*;
import java.io.*;

public class Solution {

    static int N,W,H, min;
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        
        for(int t=1; t<=T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            
            N = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            H = Integer.parseInt(st.nextToken());
            
            int[][] map = new int[H][W];
            
            for(int i=0; i<H; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<W; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            
            min = Integer.MAX_VALUE;
            go(map, 0);
            System.out.println("#"+t+" "+min);
        }
        
    }
    
    // 구슬 던지기 게임
    static boolean go(int[][] map, int cnt) { // map : 직전구슬까지 던진 상태의 배열
        
    	int result = getRemain(map);
    	if(result==0) {
    		min = result;
    		return true;
    	}
    	
    	if(cnt==N) { // 구슬을 다 던진 상태
            // 남은 벽돌 수 카운트 최소값 갱신
            if(min>result) min = result;
            return false;
            
        }
        
        // 구슬 던지기 (중복 순열) 
        int[][] newMap = new int[H][W];
        for(int c=0; c<W; c++) {
            // 구슬에 맞는 시작벽돌 찾기
            int r = 0;
            while(r<H && map[r][c]==0) ++r; // 한 열에 대한, 모든 행 검사

            if(r==H) { // 맞는 시작벽돌이 없는 상태
                continue;
            } else { // 맞는 시작벽돌이 있는 상태
                copy(map, newMap); 
                // 제거될 벽돌 연쇄 처리
                boom(newMap, r, c, newMap[r][c]);
                // 벽돌 중력 처리
                down(newMap);
                // 다음 구슬 던지기
                if(go(newMap, cnt+1)) return true;
            }
        }
        return false;
    }
    
    static Stack<Integer> stack = new Stack<Integer>();
    private static void down(int[][] map) {
    	for(int c=0; c<W; c++) {
    		// 윗행부터 남은 벽돌 스택에 넣기
    		for(int r=0; r<H; r++) {
    			if(map[r][c]>0) {
    				stack.push(map[r][c]);
    				map[r][c]=0;
    			}
    		} // 남은 벽돌은 스택에 들어있고 모든 칸은 빈칸 상태
    		int nr = H-1;
    		while(!stack.isEmpty()) {
    			map[nr--][c]=stack.pop();
    		}
    	}
	}

	private static int getRemain(int[][] map) {
        int result = 0;
        for(int r=0; r<H; r++) {
            for(int c=0; c<W; c++) {
                if(map[r][c]>0) result++;
            }
        }
        return result;
    }

    private static void copy(int[][] map, int[][] newMap) {
        for(int r=0; r<H; r++) {
            newMap[r] = map[r].clone();
        }
    }
    
    private static void boom(int[][] map, int r, int c, int cnt) { // DFS
       
        map[r][c] = 0; // 방문처리 ==> 제거처리
        if(cnt==1) return;
        
       
            // 벽돌의 크기 -1 만큼 주변 벽돌(4방) 연쇄 처리
            for(int d=0; d<4; d++) {
                int nr = r;
                int nc = c;
                for(int k=1; k<cnt; k++) { // 현재 방향에서 cnt-1 벽돌 보기
                    nr += dr[d];
                    nc += dc[d];
                    if(nr>=0 && nr<H && nc>=0 && nc<W && map[nr][nc]>0) {
                       boom(map,nr,nc,map[nr][nc]);
                    }
                    
                }
            }
        
    }
    
    static class Point {
    	int r, c, cnt;
    	public Point(int r, int c, int cnt) {
    		super();
    		this.r=r;
    		this.c=c;
    		this.cnt=cnt;
    	}
    }
}