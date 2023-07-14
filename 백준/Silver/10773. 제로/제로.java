import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		Stack<Integer> s = new Stack();
		
		int sum=0;
		for(int i=0; i<N; i++) {
			int n = Integer.parseInt(br.readLine());
			if(n!=0) {
				s.push(n);
				sum+=n;
			}
			else {
				int k=s.pop();
				sum-=k;
			}
		}
		System.out.println(sum);
	}
}
