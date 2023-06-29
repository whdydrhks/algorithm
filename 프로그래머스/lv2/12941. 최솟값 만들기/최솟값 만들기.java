// A 배열을 오름차순으로 정렬하고,
// B 배열을 내림차순으로 정렬해서 sum을 최솟값으로 맞춘다.
import java.util.*;
class Solution
{
    public int solution(int []A, int []B)
    {
        Arrays.sort(A);
        Integer[] tmp = new Integer[B.length];
        for(int i=0; i<B.length; i++){
            tmp[i]=B[i];
        }
        Arrays.sort(tmp, Collections.reverseOrder());
        int sum = 0;
        for(int i=0; i<tmp.length; i++){
            sum+=A[i]*tmp[i];
        }
        return sum;
    }
}