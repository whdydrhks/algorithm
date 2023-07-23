class Solution {
    public int solution(int n) {
        int answer = 0;
        for(int i=1; i<=n; i++){
            if(finn(i,n)) {
                answer++;    
            }
        }
        return answer;
    }
    
    public static boolean finn(int start, int n) {
        int sum=0;
        for(int i=start; i<=n; i++){
            sum+=i;
            if(sum==n) return true;
            if(sum>n) return false;
        }
        return false;
    }
}