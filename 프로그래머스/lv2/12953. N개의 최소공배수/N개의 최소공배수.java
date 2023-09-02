class Solution {
    public int solution(int[] arr) {
        int answer = 1;
        for(int i=0; i<arr.length; i++){
            answer = LCM(answer, arr[i]);
        }
            
        return answer;
    }
    
    public static int LCM(int answer, int num) {
        int a = answer; //Math.min(answer, num);
        int b = num; // Math.max(answer, num);
        int gcd=0, lcm=0;
        
        while(true) {
            int res = a%b;
            if(res==0) {
                gcd=b;  
                break;
            }
            a=b;
            b=res;
        }
        
        lcm = (answer/gcd)*(num/gcd)*gcd;
        return lcm;
    }
}