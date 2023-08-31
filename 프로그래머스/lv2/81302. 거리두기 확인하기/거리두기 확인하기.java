import java.util.*;
class Solution {
    static class Pos implements Comparable<Pos> {
        int x,y;
        Pos(int x, int y) {
            this.x=x;
            this.y=y;
        }
        
        @Override 
        public int compareTo(Pos p) {
            if(this.x==p.x) return this.y-p.y;
            return this.x-p.x;
        }
    }
    
    public int[] solution(String[][] places) {
        int[] answer = new int[places.length];
        ArrayList<Pos> list;
        for(int i=0; i<places.length; i++){
            list = new ArrayList<>();
            String[] place = places[i];
            // System.out.println("Idx: "+i);
            kakao(place, list, i, answer);
            // System.out.println();
        }   
        
        return answer;
    }
    
    public static void kakao(String[] place, ArrayList<Pos> list, int idx, int[] answer) {
        char[][] map = new char[5][5];
        for(int i=0; i<place.length; i++){
            for(int j=0; j<5; j++){
                map[i][j] = place[i].charAt(j);
                if(map[i][j]=='P') {
                    list.add(new Pos(i,j));  
                } 
            }
        }
        
        int ans=1;
        boolean flag=false;
        for(int i=0; i<list.size(); i++){
            for(int j=0; j<list.size(); j++){
                if(i==j) continue; // 자기자신
                
                if(distance(list.get(i).x, list.get(i).y, list.get(j).x, list.get(j).y)) { // 맨하튼 거리2 이하   
                    // System.out.println("맨하튼 거리2 이하!");
                    // X 체크.                    
                    if(check(list.get(i).x, list.get(i).y, list.get(j).x, list.get(j).y, map)) { // 파티션이 없다.
                        // ans=0;
                        // answer[idx]=0;
                        // return;    
                        flag=true;
                    }
                } 
                // else break;
            }
        } 
        if(flag) answer[idx]=0;
        else answer[idx]=1;
    }
    
    public static boolean check(int sx, int sy, int ex, int ey, char[][] map) {
        int startx, starty, endx, endy;
        if(sx>ex) {
            startx=ex;
            endx=sx;
        }
        else {
            startx=sx;
            endx=ex;
        }
        if(sy>ey) {
            starty=ey;
            endy=sy;
        }
        else {
            starty=sy;
            endy=ey;
        }
        
        boolean flag = false;
        for(int i=startx; i<=endx; i++){
            for(int j=starty; j<=endy; j++){
                if(map[i][j]=='O') return true;
                else if(map[i][j]=='X') flag = true;
            }
        }
        if(flag) return false;
        else return true;
        
    }
   
    public static boolean distance(int sx, int sy, int ex, int ey) {
        int num = Math.abs(sx-ex)+Math.abs(sy-ey);
        if(num<=2) return true;
        return false;
    }
}

// x,y를 담는 클래스
// p를 담는 리스트
// 맨하튼 거리는 자신 주변 8방까지.
// 자신과 상대방 위치 사이에 X가 있는지 검사 없으면 0, 모두 다 있으면 1