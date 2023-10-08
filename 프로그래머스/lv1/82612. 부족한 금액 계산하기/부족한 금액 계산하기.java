class Solution {
    public long solution(int price, int money, int count) {  
        long sum=0;
        for(long i=1; i<=count; i++){
            sum+=i;
        }
        long answer = (long)price * sum;
        
        return answer-money<=0 ? 0 : answer-money;
    }
}