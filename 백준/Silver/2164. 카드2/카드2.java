import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

class Main {

	static Queue<Integer> arr;
	static int N;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		arr=new LinkedList<Integer>();
		
		boolean discard = true;
		boolean bottom = false;
		for(int i=1; i<=N; i++) {
			arr.offer(i);
		}
		
		while(arr.size()!=1) {
			if(discard) {
				arr.poll();
				discard=false;
				bottom=true;
			}
			if(bottom) {
				int tmp=arr.peek();
				arr.offer(tmp);
				arr.poll();
				bottom=false;
				discard=true;
			}
			
		}
		System.out.println(arr.poll());
		
	} // end main
	
}
