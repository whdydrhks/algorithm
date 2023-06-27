import java.util.*;
class Solution {
    public String solution(String s, int n) {
        String answer = "";
        String[] arr = s.split("");
        for(int i=0; i<arr.length; i++){
            String tmp = check(arr[i], n);
            answer+=tmp;
        }
        return answer;
    }
    
    public static String check(String target, int n) {
        String tmp="";
        int sum=0;
        System.out.println("origin : "+target);
        if(target.equals(" ")) {
            return " ";
        }
        else {
            // a:97, z:122 | A:65, Z:90
            sum = target.charAt(0)+n;
            if(target.charAt(0)>='a' && target.charAt(0)<='z' && sum>122) sum = sum-26;
            else if(target.charAt(0)>='A' && target.charAt(0)<='Z' && sum>90) sum = sum-26;
            
            return tmp+(char)sum;
        }
    }
}