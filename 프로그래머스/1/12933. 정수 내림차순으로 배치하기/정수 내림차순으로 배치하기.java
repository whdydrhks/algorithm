import java.util.*;
class Solution {
    public long solution(long n) {
        String str = ""+n;
        String[] strArr = str.split("");
        Arrays.sort(strArr, Collections.reverseOrder());
        str="";
        
        for(String s:strArr) str+=s;
        return Long.parseLong(str);
    }
}