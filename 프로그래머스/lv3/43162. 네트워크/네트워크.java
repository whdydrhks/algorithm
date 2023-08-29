import java.util.*;
class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[][] visited = new boolean[n][n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(computers[i][j]==1 && !visited[i][j]) {
                    bfs(i,j,visited,computers,n);
                    answer++;
                }
            }
        }
        return answer;
    }
    
    public static void bfs(int x, int y, boolean[][] visited, int[][] computers,int n) {
        Queue<int[]> queue = new ArrayDeque<>();
        visited[x][y]=true;
        queue.offer(new int[] {x,y});
        
        while(!queue.isEmpty()) {
            int[] xy = queue.poll();
            
            for(int i=0; i<n; i++){
                if(computers[xy[0]][i]==1 && !visited[xy[0]][i]) {
                    queue.offer(new int[] {xy[0],i});
                    visited[xy[0]][i]=true;
                }
                if(computers[i][xy[1]]==1 && !visited[i][xy[1]]) {
                    queue.offer(new int[] {i, xy[1]});
                    visited[i][xy[1]]=true;
                }
            }
        }
        return;
    }
}