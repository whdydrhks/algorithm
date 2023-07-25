import java.util.*;
class Solution {
    static int row, col;
    static boolean[] visited;
    static int[] bucket;
    static int ans;
    public int solution(int k, int[][] dungeons) {
        ans = -1;
        row = dungeons.length;
        col = dungeons[0].length;
        visited = new boolean[row];
        bucket = new int[row];
        
        perm(0, k, dungeons);
        
        
        return ans;
    }
    
    public static void perm(int depth, int k, int[][] dungeons) {
        if(depth==row) {
            ans = Math.max(ans, check(k, dungeons));
            return;
        }
        
        for(int i=0; i<row; i++){
            if(visited[i]) continue;
            visited[i] = true;
            bucket[depth] = i;
            perm(depth+1, k, dungeons);
            visited[i]=false;
        }
    }
    
    public static int check(int k, int[][] dungeons) {
        int count=0;
        for(int i=0; i<bucket.length; i++){
            int number = bucket[i];
            if(k>=dungeons[number][0]) {
                k-=dungeons[number][1];
                if(k>=0) count++;
                else return count;
            }
        }
        return count;
    }
    
}

// 이차원 배열 람다식 정렬
// 이차원 배열 정렬 방법 (comparator, comparable)
