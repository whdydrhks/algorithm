import java.util.*;
class Solution {
    static final int INF = 100_000_000;
    static class Node implements Comparable<Node> {
        int to, weight;
        Node(int to, int weight) {
            this.to=to;
            this.weight=weight;
        }
        
        @Override 
        public int compareTo(Node N) {
            return this.weight-N.weight;
        }
    }
    
    public int solution(int N, int[][] road, int K) { // 정점(마을), 그래프, 제한시간
        int answer = 0;
        int V = N;
        int E = road.length;
        
        int start = 1;
        ArrayList<ArrayList<Node>> adjList = new ArrayList<>();
        for(int i=0; i<=V; i++){
            adjList.add(new ArrayList<>());
        }
        
        for(int i=0; i<E; i++){
            int from = road[i][0];
            int to = road[i][1];
            int weight = road[i][2];
            
            adjList.get(from).add(new Node(to, weight));
            adjList.get(to).add(new Node(from, weight));
        }
        
        int[] dist = new int[V+1];
        Arrays.fill(dist, INF);
        dist[start]=0;
        boolean[] visited = new boolean[V+1];
        
        for(int i=1; i<=V; i++){
            int min = Integer.MAX_VALUE;
            int idx = 0;
            for(int j=1; j<=V; j++){
                if(!visited[j] && dist[j] < min) {
                    min = dist[j];
                    idx=j;
                }
            }
            visited[idx]=true;
            for(Node n : adjList.get(idx)) {
                if(dist[n.to] > dist[idx] + n.weight) {
                    dist[n.to] = dist[idx] + n.weight;
                }
            }
        }
                                      
        for(int i=1; i<=V; i++){
            if(dist[i]<=K) answer++;
        }                              
    
        System.out.println(Arrays.toString(dist));

        return answer;
    }
}