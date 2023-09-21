class Solution {
    public int solution(int num) {
        int answer = 0;
        if(num==1) return 0;
        for(int i=1; i<=500; i++){
            if(num%2==0) num/=2;
            else num = 3*num+1;
            answer++;
            if(num==1) return answer;
            if(num<0) return -1;
        }
    
        return -1;
    }
}