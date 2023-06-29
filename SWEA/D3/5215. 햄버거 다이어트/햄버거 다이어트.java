import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Scanner;

import javax.imageio.stream.FileCacheImageInputStream;

public class Solution {
	static int T, N, max=0;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T=sc.nextInt();
		for(int tc=1; tc<=T; tc++) {
			N=sc.nextInt();
			int limit = sc.nextInt();
			int[] jumsu = new int[N];
			int[] calori = new int[N];
			max=0;
			
			for(int i=0; i<N; i++) {
				jumsu[i]=sc.nextInt();
				calori[i]=sc.nextInt();
			}
			
		//	System.out.println(Arrays.toString(jumsu));
		//	System.out.println(Arrays.toString(calori));
			
			recur(jumsu, calori,0,0,0,limit);
			System.out.println("#"+tc+" "+max);
		}
	}
	
	public static void recur(int[] jumsu, int[] calori, int idx, int jSum, int cSum, int limit) {
		if(cSum>limit) return;
		if(idx>N) return;
		// 모든 재료의 탐색이 끝났으며, 그때의 정수값을 확인한다
		if(idx==N) {
	//		System.out.println(cSum+" "+jSum);
			max = Math.max(max, jSum);
			return;
		}
	// 재료를 담는 경우
	recur(jumsu, calori, idx+1, jSum+jumsu[idx], cSum+calori[idx], limit);
	
	// 재료를 못담는 경우
	recur(jumsu, calori, idx+1, jSum, cSum, limit);
	}
}
