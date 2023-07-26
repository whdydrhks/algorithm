import java.io.*;
import java.util.*;

public class Main {
	static int V; // 정점
	static int E; // 간선
	static List<Integer>[] network;
	static boolean[] visited;
	static int ans;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		V = Integer.parseInt(br.readLine());
		E = Integer.parseInt(br.readLine());
		
		network = new List[V+1];
		for(int i=0; i<=V; i++) network[i] = new ArrayList<>();
		visited = new boolean[V+1];
	
		for(int i=0; i<E; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			network[from].add(to);
			network[to].add(from);
		}
		
		ans = 0;
		bfs(1);
		System.out.println(ans);
	}
	
	public static void bfs(int virus) {
		Queue<Integer> queue = new ArrayDeque<>();
		visited[virus] = true;
		queue.offer(virus);
		
		while(!queue.isEmpty()) {
			int now = queue.poll();
			
			for(int target : network[now]) {
				if(!visited[target]) {
					visited[target]=true;
					queue.offer(target);
					ans++;
				}
			}
		}
	}
}
