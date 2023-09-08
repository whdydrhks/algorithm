import java.util.*;
class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        int sum=0;
        for(int num:number) sum+=num;
        HashMap<String, Integer> wantHmap = new HashMap<>();
        for(int i=0; i<want.length; i++){
            wantHmap.put(want[i], number[i]);
        }
        
        for(int i=0; i<=discount.length-sum; i++){
            HashMap<String, Integer> hmap = new HashMap<>();
            for(int j=i; j<i+sum; j++){
                hmap.put(discount[j], hmap.getOrDefault(discount[j], 0)+1);
            } 
            
            if(check(wantHmap, hmap)) answer++;
        }
    
        return answer;
    }
    
    public static boolean check(HashMap<String, Integer> wantHmap, HashMap<String, Integer> hmap) {
        for(String key : hmap.keySet()) {
            if(hmap.get(key) != wantHmap.get(key)) return false;
        }
        return true;
    }
}

// want의 sum(number) 만큼 discount 0부터 검색을 한다.
    // 길이가 sum(number)보다 짧으면 안됨
// discount를 돌면서 제품에 대한 hmap으로 이름:갯수를 파악
    // 길이 sum(number)가 되었을 때, want의 제품과 수량이 일치하는지 비교.