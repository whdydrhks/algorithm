class Solution {
    public String solution(String s) {
        String answer = "";
        boolean flag = true;
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i)==' ') {
                flag=true;
                answer+=' ';
                continue;
            }
            if(flag) {
                answer+=String.valueOf(s.charAt(i)).toUpperCase();
                flag=false;
            }
            else {
                answer+=String.valueOf(s.charAt(i)).toLowerCase();
            }
        }
        return answer;
    }
}