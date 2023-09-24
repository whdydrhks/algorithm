import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static ArrayList<Body> list;
	static class Body {
		int weight, height;

		public Body(int weight, int height) {
			super();
			this.weight = weight;
			this.height = height;
		}
		
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());
		list = new ArrayList<>();
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int weight = Integer.parseInt(st.nextToken());
			int height = Integer.parseInt(st.nextToken());
			list.add(new Body(weight, height));
		}
		ArrayList<Integer> answer = new ArrayList<>();
		for(int i=0; i<N; i++) {
			int count = Rating(i);
			answer.add(count);
		}
		for(int ans:answer) sb.append(ans).append(" ");
		System.out.println(sb.toString());
	}
	
	public static int Rating(int person) {
		int rate=1;
		for(int i=0; i<N; i++) {
			if(i==person) continue;
			else {
				if(list.get(person).weight < list.get(i).weight && list.get(person).height < list.get(i).height) {
					rate++;
				}
			}
		}
		return rate;
	}
}
