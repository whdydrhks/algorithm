import java.util.*;

class Solution {
    public int solution(int k, int m, int[] score) {
        int answer = 0;
		// 1. 배열을 정렬한다.
		Arrays.sort(score);
		
		// 2. 기본형으로 데이터 담기
		Integer[] score2 = new Integer[score.length];
		for(int i=0; i<score.length; i++) {
			score2[i] = score[i];
		}
		
		// 3. 역순 정렬
		Arrays.sort(score2, Collections.reverseOrder());
		
		for(int i=0; i<score2.length; i++) {
			if((i+1)%m==0) answer+=score2[i]*m;
		}
		return answer;
    }
}