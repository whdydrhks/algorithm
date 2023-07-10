import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for(int t=0; t<T; t++) {
			ArrayList<Character> list = new ArrayList<>();
			String str = br.readLine();
			Stack<Character> left = new Stack<>(); 
			Stack<Character> right = new Stack<>();
			for(int i=0; i<str.length(); i++) {
				
				if(str.charAt(i)=='<') {
					if(left.isEmpty()) continue;
					else {
						right.push(left.pop());
					}
				}
				else if(str.charAt(i)=='>') {
					if(right.isEmpty()) continue;
					else {
						left.push(right.pop());
					}
				}
				else if(str.charAt(i)=='-') {
					if(left.isEmpty()) continue;
					left.pop();
				}
				else {
					left.push(str.charAt(i));
				}
			}

			while(!left.isEmpty()) {
				right.push(left.pop());
			}
			
			while(!right.isEmpty()) {
				sb.append(right.pop());
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
}