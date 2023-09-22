import java.util.*;
class Solution {
        public int solution(int[] elements) {
            HashSet<Integer> hset = new HashSet<>();
            for(int len=1; len<=elements.length; len++){
                int sum=0;
                // System.out.println("Len: "+len);
                for(int i=0; i<elements.length; i++){
                    sum+=elements[(len+i-1)%elements.length]; // 길이+원소위치-(위치재자리
                    hset.add(sum);    
                    // System.out.println("Sum: "+sum);
                }
                // System.out.println();
            }
            return hset.size();
        }
    }