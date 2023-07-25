
class Solution {
    public static boolean check[];
    public static int ans = 0;
    public int solution(int k, int[][] dungeons) {
        check = new boolean[dungeons.length];
        dfs(k, dungeons, 0);
        return ans;
    }
    public static void dfs(int tired, int[][] dungeons, int cnt){
        for(int i=0; i<dungeons.length; i++){ // 전체 길이
            if(!check[i] && dungeons[i][0]<=tired){ // 방문안한 상태, 피로도 검사
                check[i] = true; // 방문 설정
                dfs(tired-dungeons[i][1], dungeons, cnt+1);
                check[i] = false; // 원위치
            }
        }
        ans = Math.max(ans, cnt);
    }
}