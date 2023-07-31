import java.util.*;
class Solution {
    static int R,C;
    static int[] dr = {-1,0,1,0};
    static int[] dc = {0,1,0,-1};
    static int[][] map;
    static boolean[][] visited;
    
    static class ROR {
        int x,y,cnt;
        ROR(int x, int y, int cnt) {
            this.x=x;
            this.y=y;
            this.cnt=cnt;
        }
    }
    public int solution(int[][] maps) {
        int answer = 0;
        R = maps.length;
        C = maps[0].length;
        
        map = new int[R][C];
        visited = new boolean[R][C];
        answer = bfs(maps);
        
        return answer;
    }
    
    public static int bfs(int[][] maps) {
        Queue<ROR> queue = new ArrayDeque<>();
        queue.offer(new ROR(0,0,1));
        visited[0][0] = true;
        
        while(!queue.isEmpty()) {
            ROR ror = queue.poll();
            if(ror.x==R-1 && ror.y==C-1) return ror.cnt;
            
            for(int d=0; d<4; d++){
                int nr = ror.x+dr[d];
                int nc = ror.y+dc[d];
                
                if(nr<0 || nc<0 || nr>=R || nc>=C || visited[nr][nc] || maps[nr][nc]==0) continue;
                else if(nr>=0 && nc>=0 && nr<R && nc<C && !visited[nr][nc] && maps[nr][nc]==1) {
                    visited[nr][nc]=true;
                    queue.offer(new ROR(nr, nc, ror.cnt+1));
                }
            }
        }
        
        return -1;
    }
}