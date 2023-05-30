import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N]; // 수열의 수들
		int[] LIS = new int[N]; // 동적테이블 : 각 원소를 끝으로하는 LIS 값.
		
		for(int i=0; i<N; i++) {
			arr[i] = sc.nextInt();
		}
		
		int max=0;
		for(int i=0; i<N; i++) { // 앞쪽부터 모든 원소기준으로 자신을 끝으로하는 LIS 계산
			LIS[i]=1;
			for(int j=0; j<i; j++) {
				if(arr[j]<arr[i] && LIS[i] < LIS[j]+1) { // 내 앞의 숫자가 나보다 작고, 
					// 내 최장길이가 이전 최장길이+1 보다 작다.
					LIS[i] = LIS[j]+1;
				}
			}
			max = Math.max(max, LIS[i]);
		}
		
		System.out.println(max);
	}
}

/*
6
3 2 6 4 5 1
==> 3

10
8 2 4 3 6 11 7 10 14 5
==> 6
 */