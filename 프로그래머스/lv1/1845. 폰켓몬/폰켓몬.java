import java.util.*;
class Solution {
    public int solution(int[] nums) {
        HashSet<Integer> hset = new HashSet<>();
        for(int i=0; i<nums.length; i++){
            hset.add(nums[i]);
        }
        int answer = 0;
        if(hset.size() < (nums.length/2)) answer=hset.size();
		else answer=nums.length/2;
        return answer;
    }
}