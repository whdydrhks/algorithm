import java.util.*;
class Solution
{
    static int idx;
    public int solution(int []A, int []B)
    {
        Arrays.sort(A);
        Integer[] tmp = new Integer[B.length];
        for(int i=0; i<B.length; i++){
            tmp[i]=B[i];
        }
        Arrays.sort(tmp, Collections.reverseOrder());
        System.out.println(Arrays.toString(tmp));
        int sum = 0;
        for(int i=0; i<tmp.length; i++){
            sum+=A[i]*tmp[i];
        }
//         int idx = 0;
//         int min = Integer.MAX_VALUE;
        
//         for(int i=0; i<B.length; i++){
//             min = Math.min(min, check(A, B, idx++));
//         }
        
        return sum;
    }
    
//     public static int check(int[] A, int[] B, int idx) {
//         int sum=0;
//         int[] tmp = new int[B.length];
        
//         for(int i=idx, count=0; count<B.length; i++, count++){
//             if(i==B.length) i=0;
//             tmp[count] = B[i];
//         }
//         System.out.println("************");
//         System.out.println(Arrays.toString(tmp));
//         for(int i=0; i<A.length; i++){
//             sum+=A[i]*tmp[i];
//         }
        
//         return sum;
//     }
}