class Solution {
    public int solution(int n, int m, int[] section) {
        int answer = 0;
        int start=section[0], end=section[0]+m;
        boolean flag=false;
        for(int i=0; i<section.length; i++){
            if(section[i]>=start && section[i]<end) {
                if(!flag) {
                    flag=true;
                    answer++;
                }
            }
            else {
                flag=false;
                start=section[i];
                end=section[i]+m;
                i--;
            }
        }
        return answer;
    }
}