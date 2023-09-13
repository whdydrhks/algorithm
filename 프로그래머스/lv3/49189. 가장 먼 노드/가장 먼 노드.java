import java.util.*;
class Solution {
    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    public int solution(int n, int[][] edge) {
        graph = new ArrayList[n+1];
        for(int i=0; i<=n; i++) graph[i] = new ArrayList<>();
        for(int[] vertex : edge) {
            int from = vertex[0];
            int to = vertex[1];
            
            graph[from].add(to);
            graph[to].add(from);
        }
        
        visited = new boolean[n+1];
        return bfs();
    }
    
    public static int bfs() {
        int answer=0;
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[] {1,0});
        visited[1]=true;
        int maxDepth = 0;
        
        while(!queue.isEmpty()) {
            int[] node = queue.poll();
            int depth = node[1];
            
            if(maxDepth==depth) answer++;
            else if(maxDepth<depth) {
                maxDepth=depth;
                answer=1;
            }
            
            for(int near_node : graph[node[0]]) {
                if(!visited[near_node]) {
                    visited[near_node]=true;
                    queue.offer(new int[] {near_node, depth+1});
                }
            }
        }
        return answer;
    }
}