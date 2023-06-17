import java.util.*;
class Solution {
    public String solution(String[] participant, String[] completion) {
        HashMap<String, Integer> hmap = new HashMap<>();
        for(String parti : participant) {
            hmap.put(parti, hmap.getOrDefault(parti, 0)+1); // 입력한 데이터의 중복을 고려하여 카운트.
        } // ex) {"a"=1, "b"=3, "c"=1}
        
        for(String comple : completion) {
            hmap.put(comple, hmap.get(comple)-1); // 중복된 이름이 있어도 value의 값-1로 갱신된다. 
        } 
        
        for(String key : hmap.keySet()) {
            if(hmap.get(key)>=1) return key;
        }
        return "";
    }
}