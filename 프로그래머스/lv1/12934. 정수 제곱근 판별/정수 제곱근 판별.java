class Solution {
    public long solution(long n) {
        long answer=0;
        long num = (long)Math.sqrt(n);
        if(num*num!=n) answer=-1;
        else {
            answer =(long)Math.pow((num+1),2);
        }
        return answer;
        
    }
}