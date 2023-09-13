class Solution {
    static int answer;
    public int solution(int[] numbers, int target) {
        answer = 0;
        dfs(numbers, target, numbers.length, 0, 0);
        return answer;
    }
    
    public static void dfs(int[] numbers, int target, int n, int depth, int sum) {
        if(depth==n) {
            if(sum==target) 
                answer++;
            return;
        }
        
        dfs(numbers, target, n, depth+1, sum+numbers[depth]);
        dfs(numbers, target, n, depth+1, sum-numbers[depth]);
    }
}