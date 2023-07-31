import java.io.*;
import java.util.*;
public class Main {
    static int R,C;
    static int[] dr = {-1,0,1,0};
    static int[] dc = {0,1,0,-1};
    static int[][] map;
    static boolean[][] visited;
    static class Person {
        int r,c,time;
        char type;
        Person(int r, int c, int time, char type) {
            this.r=r;
            this.c=c;
            this.time=time;
            this.type=type;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        int T = Integer.parseInt(br.readLine());
        for(int t=1; t<=T; t++){
            st = new StringTokenizer(br.readLine());
            C = Integer.parseInt(st.nextToken());
            R = Integer.parseInt(st.nextToken());
            map = new int[R][C];
            visited = new boolean[R][C];
            int sx=0, sy=0;
            Queue<Person> queue = new ArrayDeque<>();
            for(int i=0; i<R; i++){
                String str = br.readLine();
                for(int j=0; j<C; j++){
                    map[i][j] = str.charAt(j);
                    if(map[i][j]=='@') {
                        sx=i;
                        sy=j;
                    }
                    else if(map[i][j]=='*') {
                        queue.offer(new Person(i,j,0,'*'));
                        visited[i][j]=true;
                    }
                    else if(map[i][j]=='#') visited[i][j]=true;
                }
            }
            queue.offer(new Person(sx,sy,1,'@'));

            int answer = bfs(queue);

            System.out.println(answer==0 ? "IMPOSSIBLE" : answer);
        }

    }

    public static int bfs(Queue<Person> queue) {
        while(!queue.isEmpty()) {
            int len = queue.size();

            for(int i=0; i<len; i++){
                Person person = queue.poll();

                for(int d=0; d<4; d++){
                    int nr = person.r+dr[d];
                    int nc = person.c+dc[d];

                    if(person.type=='*') {
                        if(nr<0 || nc<0 || nr>=R || nc>=C || visited[nr][nc] || map[nr][nc]=='#' || map[nr][nc]=='*') continue;
                        else if(nr>=0 && nc>=0 && nr<R && nc<C && !visited[nr][nc] && map[nr][nc]=='.') {
                            map[nr][nc]='*';
                            queue.offer(new Person(nr,nc,0,'*'));
                            visited[nr][nc]=true;
                        }
                    }
                    else if(person.type=='@') {
                        if(nr<0 || nc<0 || nr>=R || nc>=C) {
                            return person.time;
                        }
                        else if(visited[nr][nc] || map[nr][nc]=='#' || map[nr][nc]=='*') continue;
                        else if(nr>=0 && nc>=0 && nr<R && nc<C && !visited[nr][nc] && map[nr][nc]=='.') {
                            map[person.r][person.c]='.';
                            map[nr][nc]='@';
                            queue.offer(new Person(nr,nc,person.time+1,'@'));
                            visited[nr][nc]=true;
                        }
                    }
                }
            }
        }
        return 0;
    }
}

/*
'.': 빈 공간
'#': 벽
'@': 상근이의 시작 위치
'*': 불
 */
// 가장 빠른 시간을 출력한다. 빌딩을 탈출할 수 없는 경우에는 "IMPOSSIBLE"을 출력한다.