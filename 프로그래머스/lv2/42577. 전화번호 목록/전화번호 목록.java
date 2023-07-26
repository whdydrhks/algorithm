import java.util.*;
class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        HashSet<String> hset = new HashSet<>();
        for(String phone : phone_book) {
            hset.add(phone);
        }
        
        for(String phone : phone_book) {
            for(int i=1; i<phone.length(); i++){
                String tmp = phone.substring(0,i);
                if(hset.contains(tmp)) return false;
            }
        }
        return answer;
        }
}

// 1) 해시셋에 전부 넣는다.
// 2) 다시 반복을 하되, 자신의 길이-1 만큼을 넣는다.
// 3) 이미 있다면 return