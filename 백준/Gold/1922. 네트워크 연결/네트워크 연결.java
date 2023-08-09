import java.io.*;
import java.util.*;

public class Main {
	
	static int V,E;
	static Computer[] network;
	static int[] parents; 
	
	static class Computer implements Comparable<Computer> {
		int from, to, weight;
		Computer(int from, int to, int weight) {
			this.from=from;
			this.to=to;
			this.weight=weight;
		}
		
		@Override
		public int compareTo(Computer C) {
			return this.weight-C.weight;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		V = Integer.parseInt(br.readLine());
		E = Integer.parseInt(br.readLine());
		
		network = new Computer[E];
		
		for(int i=0; i<E; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken())-1;
			int to = Integer.parseInt(st.nextToken())-1;
			int weight = Integer.parseInt(st.nextToken());
			network[i] = new Computer(from, to, weight);
		}
		
		make();
		Arrays.sort(network);
		
		int answer=0;
		int count=0;
		
		for(Computer com : network) {
			if(union(com.from, com.to)) {
				answer+=com.weight;
				if(++count==V-1) break;
			}
		}
		
		System.out.println(answer);
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
		return parents[a]=find(parents[a]);
	}

}
