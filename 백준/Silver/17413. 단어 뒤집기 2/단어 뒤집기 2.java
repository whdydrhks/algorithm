import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		StringBuilder sb = new StringBuilder();
		boolean flag=true; // true: 스택, false: 큐
		Stack<Character> stack = new Stack<>();
		Queue<Character> queue = new ArrayDeque<>();
		for(int i=0; i<str.length(); i++) {
			char ch = str.charAt(i);
			if(ch=='<') {
				if(!stack.isEmpty()) {
					while(!stack.isEmpty()) {
						sb.append(stack.pop());
					}
				}
				
				sb.append(ch);
				flag=false;
			}
			else if(ch=='>') {
				while(!queue.isEmpty()) {
					sb.append(queue.poll());
				}
				sb.append(ch);
				flag=true;
			}
			else if(ch==' ') {
				if(!stack.isEmpty()) {
					while(!stack.isEmpty()) {
						sb.append(stack.pop());
					}
					sb.append(ch);
					flag=true;
				}
				else if(!flag) {
					queue.offer(ch);
				}
				else {
					stack.push(ch);
				}
			}
			
			else if(i==str.length()-1) {
				stack.push(ch);
				while(!stack.isEmpty()) {
					sb.append(stack.pop());
				}
			}
			
			else if(flag) {
				stack.push(ch);
			}
			
			else if(!flag) {
				queue.offer(ch);
			}
		}
		
		System.out.println(sb.toString());
	}
}
