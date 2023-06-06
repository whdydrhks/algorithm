import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N]; // 수열의 수들
		int[] C = new int[N]; // 동적테이블 C[k] : 해당(k) 길이를 만족하는 자리 (k자리)에 오는 수의 최소값
		
		for(int i=0; i<N; i++) {
			arr[i] = sc.nextInt();
		}
		
		int size = 0;
		
		for(int i=0; i<N; i++) {
			int pos = Arrays.binarySearch(C, 0, size, arr[i]);
			if(pos>=0) continue; // 대상을 찾았다.
			
			int insertPos = Math.abs(pos)-1; // 맨뒤 or 기존원소 대체 자리.
			C[insertPos] = arr[i];
			
			if(insertPos == size) size++;
		}
		
		System.out.println(size);
	}
}