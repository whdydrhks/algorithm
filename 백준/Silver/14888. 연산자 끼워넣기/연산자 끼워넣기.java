import java.io.*;
import java.util.*;

public class Main {

	static int N;
	static int[] numbers;
	static int[] operator;
	static int num_max;
	static int num_min;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		N = Integer.parseInt(br.readLine());
		numbers = new int[N];
		operator = new int[4];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			numbers[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<4; i++) {
			operator[i] = Integer.parseInt(st.nextToken());
		}
		
		num_max = Integer.MIN_VALUE;
		num_min = Integer.MAX_VALUE;
		recur(0, numbers[0]);
		System.out.println(num_max);
		System.out.println(num_min);
	}
	
	public static void recur(int depth, int sum) {
		if(depth==N-1) {
			num_max = Math.max(num_max, sum);
			num_min = Math.min(num_min, sum);
			return;
		}
		
		for(int i=0; i<4; i++) {
			if(operator[i]>0) {
				operator[i]--;
				recur(depth+1, calc(sum, i, depth));
				operator[i]++;
			}
		}
	}
	
	public static int calc(int sum, int op, int depth) {

		switch (op) {
		case 0:
			return sum + numbers[depth + 1];
		case 1:
			return sum - numbers[depth + 1];
		case 2:
			return sum * numbers[depth + 1];
		case 3:
			return sum / numbers[depth + 1];
		}
		
		return sum;
	}
	
}
