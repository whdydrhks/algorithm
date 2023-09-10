import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		PriorityQueue<Integer> q = new PriorityQueue(Collections.reverseOrder());
		String str = br.readLine();
		for(int i=0; i<str.length(); i++) {
			q.add(str.charAt(i)-'0');
		}
		
		while(!q.isEmpty()) {
			sb.append(q.poll());
		}
		System.out.println(sb.toString());
	}
}
