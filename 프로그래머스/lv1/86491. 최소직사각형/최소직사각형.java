import java.util.*;
class Solution {

    public int solution(int[][] sizes) {
        int answer = Integer.MAX_VALUE;
        int row = sizes.length;
        int max_width=0;
        int max_height=0;
        for(int i=0; i<row; i++){
            int width=sizes[i][0];
            int height=sizes[i][1];
            if(width>height) {
                sizes[i][0]=height;
                sizes[i][1]=width;
            }
            max_width=Math.max(max_width, sizes[i][0]);
            max_height=Math.max(max_height, sizes[i][1]);
        }
        answer=max_width*max_height;
        return answer;
    }
}