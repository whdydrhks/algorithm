import java.util.*;
class Solution {
    static HashSet<Integer> hset;
    public int solution(int[] elements) {
        int[] newElements = new int[elements.length*2];
        for(int i=0, idx=0; i<newElements.length; i++, idx++){
            if(idx==elements.length) idx=0;
            newElements[i] = elements[idx];
        }
        
        hset = new HashSet<>();
        for(int element : elements) hset.add(element);
        
        for(int i=2; i<=elements.length; i++){
            check(i, newElements, elements.length-i+1);
        }
        return hset.size();
    }
    
    public static void check(int len, int[] newElements, int size) {
        int totalCount=0;
        for(int i=0; i<newElements.length; i++){
            if(totalCount==size) break;
            int sum=0, count=0;
            for(int start=i; start<newElements.length; start++){
                if(count==len) {
                    hset.add(sum);
                    break;
                }
                sum+=newElements[start];
                count++;
            }
        }
    }
}