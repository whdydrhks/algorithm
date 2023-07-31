import java.util.*;
class Solution {
    public int solution(int n, int k) {
        int answer = -1;
        String transform = converter(n, k);
        answer = prime(transform);
        return answer;
    }
    
    public static String converter(int n, int k) {
        String tmp = "";
        while(n!=0) {
            tmp = n%k + tmp;
            n/=k;
        }       
        return tmp;        
    }
    
    public static int prime(String transform) {    
        int sum=0;
        
        String[] arr = transform.split("0");
        for(int i=0; i<arr.length; i++){
            if(arr[i].equals("")) continue;
            if(isPrime(arr[i])) sum++;
        }
        
        return sum;
    }
    
    public static boolean isPrime(String str) {
        int count=0;
        long num = Long.parseLong(str);
        if(num==1) return false;
        
        for(int i=2; i<=Math.sqrt(num); i++){
            if(num%i==0) return false;
        }
        
        return true;
    }
}

// 진법 변환을 하고 (역정렬)
// 0으로 split 하고
// 소수임을 판별
