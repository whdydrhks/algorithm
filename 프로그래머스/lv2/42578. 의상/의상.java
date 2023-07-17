import java.util.*;
class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        HashMap<String, Integer> hmap = new HashMap<>();
        
        for(int i=0; i<clothes.length; i++){
            hmap.put(clothes[i][1], hmap.getOrDefault(clothes[i][1], 1)+1);
        }
        
        for(int num : hmap.values()) {
            answer*=num;
        }
        return answer-1;
    }
}

/*
<옷의 종류> : [의상 수]
1) <hg> : [3] => (3+1)-1 = 3
2) <hg> : [2]
   <bd> : [1] 
   => (2+1) * (1+1) -1 = (3)*(2)-1 = 5
3) <hg> : [3]
   <bd> : [2]
   <fc> : [1]
   => (3+1) * (2+1) * (1+1) -1
   = (4)*(3)*(2)-1
   = 23

// 해쉬맵을 통해 옷의 종류에 대한 의상 수를 센다.
*/