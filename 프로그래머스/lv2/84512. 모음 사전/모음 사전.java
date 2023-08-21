import java.util.*;
class Solution {
    static String[] strarr;
    static String[] arr = {"A","E","I","O","U"};
    static ArrayList<String> list;
    public int solution(String word) {
        int answer = 0;
        
        list = new ArrayList<>();
        for(int i=1; i<=5; i++){
            strarr = new String[i];
            perm2(0,i);
        }
        Collections.sort(list);
        answer = list.indexOf(word)+1;
        return answer;
    }
    
    public static void perm2(int depth,int limit) {
        if(depth==limit) {
            String tmp="";
            for(int i=0; i<strarr.length; i++){
                tmp+=strarr[i];
            }
            list.add(tmp);
            return;
        }
        
        for(int i=0; i<5; i++){
            strarr[depth] = arr[i];
            perm2(depth+1, limit);
        }
    }
}