import java.io.*;
import java.util.*;
public class Main {
    static int N,M,H;
    static int[] dr = {-1,0,1,0,0,0};
    static int[] dc = {0,1,0,-1,0,0};
    static int[] dh = {0,0,0,0,1,-1};
    static int answer;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        int[][][] arr = new int[N][M][H];
        boolean[][][] visited = new boolean[N][M][H];

        Queue<int[]> queue = new ArrayDeque<>();
        // 1: 익은 토마토, 0: 익지 않은 토마토, -1: 토마토가 들어있지 않은 칸
        for(int k=0; k<H; k++){
            for(int i=0; i<N; i++){
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<M; j++){
                    arr[i][j][k] = Integer.parseInt(st.nextToken());
                    if(arr[i][j][k]==1) {
                        queue.offer(new int[] {i,j,k});
                        visited[i][j][k]=true;
                    }
                }
            }
        }
        boolean flag=true;
        for(int[][] ar:arr)
            for(int[] a:ar)
                for(int ta:a)
                    if(ta==0) flag=false;

        answer = 0;
        bfs(arr, visited, queue);
        int num = check(arr);
        if(flag) System.out.println(0);
        else {
            System.out.println(num==-1 ? -1 : answer);
        }

    }

    public static void print(int[][][] arr) {
        for(int k=0; k<H; k++){
            for(int i=0; i<N; i++){
                for(int j=0; j<M; j++){
                    System.out.print(arr[i][j][k]+" ");
                }
                System.out.println();
            }
        }
    }

    public static int check(int[][][] arr) {
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++){
                for(int k=0; k<H; k++){
                    if(arr[i][j][k]==0) return -1;
                }
            }
        }
        return answer;
    }

    public static void bfs(int[][][] arr, boolean[][][] visited, Queue<int[]> queue) {
        while(!queue.isEmpty()) {
            boolean flag = check_full(arr);
            if(flag) return;
            int len = queue.size();
            for(int i=0; i<len; i++) {
                int[] xyz = queue.poll();
                for(int d=0; d<6; d++){
                    int nr = xyz[0]+dr[d];
                    int nc = xyz[1]+dc[d];
                    int nh = xyz[2]+dh[d];

                    if(nr<0 || nc<0 || nh<0 || nr>=N || nc>=M || nh>=H || arr[nr][nc][nh]!=0 || visited[nr][nc][nh]==true) continue;
                    else if(nr>=0 && nr<N && nc>=0 && nc<M && nh>=0 && nh<H && arr[nr][nc][nh]==0 && visited[nr][nc][nh]==false) {
                        arr[nr][nc][nh]=1;
                        visited[nr][nc][nh]=true;
                        queue.offer(new int[] {nr, nc, nh});
                    }
                }
            }
            answer++;
//            System.out.println("---------");
//            print(arr);
//            System.out.println();
        }
    }

    public static boolean check_full(int[][][] arr) {
        boolean flag=false;
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++){
                for(int k=0; k<H; k++){
                    if(arr[i][j][k]==0) return false;
                }
            }
        }
        return true;
    }
}
