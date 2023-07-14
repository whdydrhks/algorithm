import java.util.*;
class Solution {
    static int cnt;
    static int zero_cnt;
    public int[] solution(String s) {
        int[] answer = new int[2];
        cnt=0;
        zero_cnt=0;
        
        while(!s.equals("1")) {
            // 1. 모든 0 제거
            s = replace(s);
            
            if(s.equals("1")) {
                cnt++;
                break;
            }
            
            // 2. 2진법 문자열 변환
            s = trans(s);
            cnt++;
        }
        answer[0]=cnt;
        answer[1]=zero_cnt;
        return answer;
    }
    
    public static String replace(String s) {
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i)=='0') zero_cnt++;
        }
        s = s.replaceAll("0","");
        return s;
    }
    
    public static String trans(String s) {
        int len = s.length();
        String tmp = "";
        
        while(true) { 
            if(len==1) {
                tmp+=1;
                break;
            }
            int mok = len/2; 
            int res = len%2; 
            
            tmp+=res;
            len=mok;
        }
        StringBuffer sb = new StringBuffer(tmp);
        String reversed = sb.reverse().toString();
        return reversed;
    }
}