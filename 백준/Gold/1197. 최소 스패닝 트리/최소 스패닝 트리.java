import java.io.*;
import java.util.*;

public class Main {
	static int V, E;
	static Node[] graph;
	
	static int[] parents;
	
	static class Node implements Comparable<Node> {
		int from, to, weight;
		Node(int from, int to, int weight) {
			this.from=from;
			this.to=to;
			this.weight=weight;
		}
		
		@Override
		public int compareTo(Node o) {
			return this.weight-o.weight;
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		graph = new Node[E]; // 크루스칼은 간선 중심
		
		for(int i=0; i<E; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken())-1;
			int to = Integer.parseInt(st.nextToken())-1;
			int weight = Integer.parseInt(st.nextToken());
			graph[i] = new Node(from, to, weight);
		}
		
		make();
		Arrays.sort(graph);
		
		int result=0;
		int count=0;
		
		for(Node node : graph) {
			if(union(node.from, node.to)) {
				result+=node.weight;
				if(++count==V-1) break;
			}
		}
		System.out.println(result);
	}
	
	public static void make() {
		parents = new int[V];
		for(int i=0; i<V; i++) {
			parents[i]=i;
		}
	}
	
	public static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		
		if(aRoot==bRoot) return false;
		parents[bRoot] = aRoot;
		return true;
	}
	
	public static int find(int a) {
		if(parents[a]==a) return a;
		return parents[a] = find(parents[a]);
	}
}
