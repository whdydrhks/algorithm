class Solution {
    public int solution(String t, String p) {
        int answer = 0;
        int len = p.length();
        Long p_val = Long.parseLong(p);
        
        for(int i=0; i<t.length()-len+1; i++){
            Long val = Long.parseLong(t.substring(i, i+len));
            if(val<=p_val) {
                answer++;
            }
        }
        
        return answer;
    }
}