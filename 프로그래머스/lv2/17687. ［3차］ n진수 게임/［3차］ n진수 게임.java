class Solution {
    public String solution(int n, int t, int m, int p) {
        String answer = "";
        int order=0;
        for(int i=0; i<t*m; i++){
            String number = Integer.toString(i, n);
    
            if(number.length()==1) { // 한문자
                order++;
                if(order==m+1) order=1; // 순서 1부터
                if(order==p) { // 내 차례
                    answer = answer + number.toUpperCase();
                    if(answer.length() == t) return answer;
                }
                else {
                    continue;
                }
            }
            else { // 문자열
                for(int j=0; j<number.length(); j++){
                    order++;
                    if(order==m+1) order=1;
                    if(order==p) {
                        answer = answer+String.valueOf(number.charAt(j)).toUpperCase(); 
                        if(answer.length() == t) return answer;
                    }
                    else {  
                        continue;
                    }
                }
            }
        }
        return answer;
    }
}