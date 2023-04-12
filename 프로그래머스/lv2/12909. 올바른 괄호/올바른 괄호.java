class Solution {
    boolean solution(String s) {
        boolean answer = true;

        int sum=0;
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i)=='(') sum++;
            else sum--;
            
            if(sum<0) {
                answer=false;
                break;
            }
        }
        if(sum!=0) answer=false;

        return answer;
    }
}