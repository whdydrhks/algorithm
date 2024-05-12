class Solution {
    public int[] solution(int n, int m) {
        int a = n;
        int b = m;
        
        int gcd=0;
        int lcm=0;
        
        while(true) {
            int res = a%b;
            if(res==0) {
                gcd=b;
                break;
            }
            
            a=b;
            b=res;
        }
        
        lcm = (n/gcd)*(m/gcd)*gcd;
        return new int[] {gcd, lcm};
    }
}