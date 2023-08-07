import java.util.*;
class Solution {
    static int len;
    static HashSet<Integer> hset;
    public int solution(String numbers) {
        int answer = 0;
        len = numbers.length();
        hset = new HashSet<>();
        for(int i=1; i<=len; i++){
            boolean[] visited = new boolean[len];
            char[] chrs = new char[i];
            perm(0, numbers, visited, chrs, i);
        }
        
        for(int num : hset) {
            if(isPrime(num)) answer++;
        }
    
        return answer;
    }
    
    public static void perm(int depth, String numbers, boolean[] visited, char[] chrs, int limit) {
        if(depth==limit) {
            String tmp="";
            for(int i=0; i<chrs.length; i++){
                tmp+=chrs[i];
            }
            int num = Integer.parseInt(tmp);
            if(num==0 || num==1) return;
            
            hset.add(num);
            
            return;
        }
        
        for(int i=0; i<len; i++){
            if(visited[i]) continue;
            visited[i]=true;
            chrs[depth]=numbers.charAt(i);
            perm(depth+1, numbers, visited, chrs, limit);
            visited[i]=false;
        }
    }
    

    public static boolean isPrime(int num) {
        if(num==2) return true;
        for(int i=2; i<num; i++){
            if(num%i==0) return false;
        }
        return true;
    }
}