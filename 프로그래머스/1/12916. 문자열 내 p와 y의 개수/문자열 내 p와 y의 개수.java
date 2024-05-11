class Solution {
    boolean solution(String s) {
        boolean answer = true;
        s=s.toLowerCase();
        char[] arr = s.toCharArray();
        
        int num_p=0; int num_s=0;
        for(int i=0; i<arr.length; i++){
            if(arr[i]=='p') num_p++;
            else if(arr[i]=='y') num_s++;
        }
        answer = num_p==num_s ? true:false;
        return answer;
    }
}