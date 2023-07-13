class Solution {
    public int solution(String s) {
        int answer = 0;
        String[] strarr = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        
        for(int i=0; i<strarr.length; i++){
            s = s.replaceAll(strarr[i], Integer.toString(i));
        }
        return Integer.parseInt(s);
    }
}