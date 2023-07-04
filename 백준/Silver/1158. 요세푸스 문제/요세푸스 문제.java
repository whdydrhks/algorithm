import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {
	static int N;
	static int K;
	static StringBuilder sb;
	static Queue<Integer> q;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		K=Integer.parseInt(st.nextToken());
		
		q = new LinkedList<>();
		
		for(int i=1; i<=N; i++) {
			q.offer(i);
		}
		sb=new StringBuilder();
		sb.append("<");
		
		// 마지막에 ,를 뺴고 숫자와 >를 넣기 위해서.
		while(q.size() !=1) {
			for(int i=0; i<K-1; i++) {
				q.offer(q.poll()); // K전까지의 앞 숫자들을 다시 뒤로 넣는다.
			}						// K갯수 이전까지를 넘어가니 뒤로 넘기는 것이다.
			sb.append(q.poll() +", "); // 앞으로 나온 K번째를 넣기.
			
		}
		
		sb.append(q.poll()+">");
		
		System.out.println(sb.toString());
	}
	
}
