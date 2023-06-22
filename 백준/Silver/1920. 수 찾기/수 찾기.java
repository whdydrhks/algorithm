import java.io.*;
import java.util.*;
public class Main {
	public static int[] arr;
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
 
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arr);
		
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for(int i=0; i<M; i++) {
			if(binarySearch(Integer.parseInt(st.nextToken()))>=0) {
				sb.append(1).append("\n");
			}
			else sb.append(0).append("\n");
		}
		System.out.println(sb.toString());
			
	}
	
	public static int binarySearch(int num ) {
		int left = 0;
		int right=arr.length-1;
		
		while(left<=right) {
			
			int mid = (left+right)/2;
			
			if(arr[mid]>num) {
				right = mid-1;
			}
			else if(arr[mid]<num) {
				left = mid+1;
			}
			else {
				return mid;
			}
		}
		return -1;
	}
}
