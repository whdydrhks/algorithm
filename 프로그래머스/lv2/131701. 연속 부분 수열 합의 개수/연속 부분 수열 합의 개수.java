import java.util.*;

class Solution {
        public int solution(int[] elements) {
            Set<Integer> set = new HashSet<>();
            int[] dp = new int[elements.length];
            for(int len = 1;len <= elements.length; len++){
                for(int i = 0;i<elements.length;i++){
                    dp[i] += elements[(len+i-1)%elements.length];
                    set.add(dp[i]);
                }
            }
            return set.size();
        }
    }