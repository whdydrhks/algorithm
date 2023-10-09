import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static int M;
	static int[] arr;
	static int[] sum;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());
	
		/* solution1 */
//		arr = new int[N];
//		st = new StringTokenizer(br.readLine());
//		for(int i=0; i<N; i++) {
//			arr[i] = Integer.parseInt(st.nextToken());
//		}
//		M = Integer.parseInt(br.readLine());
//		for(int i=0; i<M; i++) {
//			st = new StringTokenizer(br.readLine());
//			int start = Integer.parseInt(st.nextToken())-1;
//			int end = Integer.parseInt(st.nextToken())-1;
//			int sum=0;
//			for(int j=start; j<=end; j++) {
//				sum+=arr[j];
//			}
//			sb.append(sum).append("\n");
//		}
//		System.out.println(sb.toString());
		
		/* solution2 */
		arr = new int[N+1];
		st = new StringTokenizer(br.readLine());
		sum = new int[N+1];
		for(int i=1; i<=N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			if(i==1) {
				sum[i]=arr[i];
				continue;
			}
			sum[i] = sum[i-1]+arr[i];
		}
//		System.out.println(Arrays.toString(sum));
		M = Integer.parseInt(br.readLine());
		for(int i=1; i<=M; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int num = sum[end] - sum[start-1];
			sb.append(num).append("\n");
		}
		System.out.println(sb.toString());
	}
}
