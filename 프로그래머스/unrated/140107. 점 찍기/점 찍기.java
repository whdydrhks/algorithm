import java.util.*;
class Solution {
    public long solution(int k, int d) {
        long answer = 0;
        
        for(int i=0; i<=d/k; i++){
            long kx = (long)i*k; // k가 곱해진 가로 kx
            long y = (long)Math.sqrt((long)Math.pow(d,2) - (long)Math.pow(kx,2)) / k; // 구하고자 하는 y좌표(x의 좌표와 거리 d가 계산된 y)
            // 점 한개씩이 아닌, 각 x마다의 y점의 갯수가 더해진다. (+1을 해서 0을 포함)
            // System.out.println("x: "+kx/k+" y: "+y);
            
            answer = answer+y+1;
            // System.out.println("ans: "+answer+" (y:"+y+"까지의 정수 갯수에, 0까지 포함한 갯수)");
        }
        
        return answer;
    }
}

// dist = Math.sqrt(x^2+y^2)
// dist^2 = x^2+y^2
// y^2 = dist^2-x^2
// y = Math.sqrt(dist^2-x^2)

// 0부터 d/k까지라는 경계값을 확실히
// 변수도 x가 아닌 k가 곱해진 가로이므로 kx