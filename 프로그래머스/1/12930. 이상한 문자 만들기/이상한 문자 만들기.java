import java.util.*;
class Solution {
//     public String solution(String s) {
//        // split("")로 전부 String[]에 String 값으로 저장을 한다.
		
// 		// 처음엔 split(" ")로 String값만 저장하려고 했는데,
// 		// 대소문자를 charAt(idx)로 변환하지 못했다.
// 		String answer = "";
// 		String[] str = s.split("");
		
// 		System.out.println(Arrays.toString(str));
		
// 		int idx = 0;
// 		for(int i=0; i<str.length; i++) { // 문자열 배열을 돌면서
// 			if(str[i].equals(" ")) {
// 				idx=0; // 인덱스 초기화
// 			}
// 			else if(idx%2==0) {
// 				str[i] = str[i].toUpperCase();
// 				idx++;
// 			}
// 			else if(idx%2 !=0) {
// 				str[i] = str[i].toLowerCase();
// 				idx++;
// 			}
// 			answer+=str[i];
// 		}
// 		System.out.println(answer);
//         // solution2(s);
//         return answer;
//     }
    
    public static String solution(String s) {
		String answer = "";
		int cnt=0;
		String[] arr = s.split("");
		for(String ss:arr) {
			// 각 String이 " "인지를 확인하고 아니라면 다음 idx로 넘어간다.
			cnt = ss.equals(" ") ? 0:cnt+1;
			// cnt가 짝수면 소문자, 홀수면 대문자로 변환.
			answer += cnt%2==0 ? ss.toLowerCase() : ss.toUpperCase();
		}
		System.out.println(answer);
        return answer;
	}
}