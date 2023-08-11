import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		long A = Long.parseLong(st.nextToken());
		long B = Long.parseLong(st.nextToken());
		long C = Long.parseLong(st.nextToken());
		
		long answer = recur(A, B, C);
		System.out.println(answer);
	}
	
	// 아직 모듈러 연산을 하지 않을 때
//	public static long recur(long A, long B,long C) { // 밑, 지수
//		if(B==1) { // 지수가 1까지 나눠졌다.
//			return A;
//		}
//		
//		long half = recur(A, B/2, C); 
//		
//		if(B%2==1) {
//			return half * half * A;
//		}
//		return half * half ; // A^9 = A^4 * A^4 * A
//		
//	}
	
	// (%C 추가) 
//	public static long recur(long A, long B,long C) { // 밑, 지수
//	if(B==1) { // 지수가 1까지 나눠졌다.
//		return A%C;
//	}
//	
//	long half = recur(A, B/2, C); 
//	
//	if(B%2==1) {
//		return half * half * A %C;
//	}
//	return half * half %C; // A^9 = A^4 * A^4 * A
//	
//	}
//	=> 위에처럼 단순히 뒤에 %C만 추가하면 바로 터져버린다.
	
	// 모듈러 연산을 추가한다. (A * B) % C = ((A % C)*(B%C)) %C 
	// 위에서 나머지 1이 있는 half * half * A %C의 경우,
	// half * (half*A) %C 로 치환이 된다.
	// 여기서, (half*A) %C 에 대해서 
	// [ (A * B) % C = ((A % C)*(B%C)) %C  ] 공식을 적용하는 것이다.
	//  A=half*half, B=A 가 되는 것.
	// 	(((half * half % C)*(A % C)) % C    
	//  (((half * half % C) % C)*(A % C)) %C
	//  ((half * half % C) * A) % C
	public static long recur(long A, long B,long C) { // 밑, 지수
	if(B==1) { // 지수가 1까지 나눠졌다.
		return A%C;
	}
	
	long half = recur(A, B/2, C); 
	
	if(B%2==1) {
		return (half * half % C) * A % C;
	}
	return half * half %C; // A^9 = A^4 * A^4 * A
	
	}
}

// 지수법칙과 모듈러 연산을 사용
// 지수법칙
// A^B = A^(B/2) * A^(B/2)
//     = A^(B/4) * A^(B/4) * A^(B/4) * A^(B/4)
// 모듈러
// (a*b)%c = (a%c * b%c)%c
// 
// 최소한도로 지수의 승을 낮춘다.

