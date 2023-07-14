class Solution {
    public int[] solution(String s) {
        int[] answer = {0,0};
        
        while( !s.equals("1") ) {
            int len = s.length();
            s = s.replaceAll("0", "");
            answer[1]+=len-s.length();
            s = Integer.toBinaryString(s.length());
            answer[0]++;
        }
        return answer;  
    }
}