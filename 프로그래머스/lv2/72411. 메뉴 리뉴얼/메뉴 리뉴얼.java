import java.util.*;
class Solution {
    static ArrayList<String> list;
    public String[] solution(String[] orders, int[] course) {
        String[] answer = {};
        list = new ArrayList<>();
        for(int len : course) {
            HashMap<String, Integer> hmap = new HashMap<>();
            
            for(String str : orders) {
                String[] strarr = str.split("");
                Arrays.sort(strarr);
                String[] arr = new String[len];
                comb(0,0,len,strarr,arr,strarr.length, hmap);
            }
            
            int sum=0;
            for(String key : hmap.keySet()) {
                sum = Math.max(sum, hmap.get(key));
            }
            for(String key : hmap.keySet()) {
                int val = hmap.get(key);
                if(val==sum && val>=2) list.add(key);
            }
            
            // System.out.println(hmap.toString());
        }
        Collections.sort(list);
        // System.out.println(list.toString());
        answer = list.toArray(new String[list.size()]);
        return answer;
    }
    
    public static void comb(int depth, int start, int limit, String[] strarr, String[] arr, int N, HashMap<String, Integer> hmap) {
        if(depth==limit) {
            String tmp="";
            
            // System.out.println(Arrays.toString(arr));
            for(String s : arr) tmp+=s;
            hmap.put(tmp, hmap.getOrDefault(tmp, 0)+1);
            
            return;
        }
        
        for(int i=start; i<N; i++){
            arr[depth]=strarr[i];
            comb(depth+1, i+1, limit, strarr, arr, N, hmap);
        }
    }
}

// 1. 코스요리는 최소 2가지 이상의 메뉴
// 2. 최소 2명 이상의 손님으로부터 주문받은 메뉴

// 해결방법
// course에 담긴 길이를 기준으로,
// orders의 각 문자열을 길이에 대한 조합을 만들고 리스트에 담기 [조합, 횟수] - 없으면:1, 있으면+1
// 가장 많은 횟수의 조합을 Answer에 담는다.