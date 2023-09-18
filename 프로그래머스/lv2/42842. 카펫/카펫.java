class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = {};
        
        int brown_limit = (int)Math.sqrt(5000)+1;
        int yellow_limit = 2005000;
        
        for(int i=1; i<=yellow_limit; i++){
            for(int j=1; j<=i; j++) {
                if(i*j==yellow) {
                    if(((i+2)*(j+2)-yellow)==brown) return new int[] {i+2, j+2};
                }
            }
        }
        return answer;
    }
}