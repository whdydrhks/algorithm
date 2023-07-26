class Solution {
    public int solution(int n) {
        int answer = 0;
        for(int i=n+1; i<=1000000; i++){
            String str = Integer.toBinaryString(i);
            if(check(str,n)) return i; 
        }
        return answer;
    }
    
    public static boolean check(String str, int n) {
        String binary_n = Integer.toBinaryString(n);
        int cnt_n=0;
        int cnt_str=0;
        for(int i=0; i<binary_n.length(); i++){
            if(binary_n.charAt(i)=='1') cnt_n++;
        }
        for(int i=0; i<str.length(); i++){
            if(str.charAt(i)=='1') cnt_str++;
        }
        if(cnt_n==cnt_str) return true;
        else return false;
    }
}