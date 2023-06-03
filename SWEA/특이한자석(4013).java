import java.io.*;
import java.util.*;

public class Solution_특이한자석_4013 {

    static int N=0, S=1;
    static int[] wheel1; // idx 2번이 인접
    static int[] wheel2; // idx 2,6번이 인접
    static int[] wheel3; // idx 2,6번이 인접
    static int[] wheel4; // idx 6번이 인접
    // 1이면  시계방향, -1이면 반시계 방향.

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        // [회전하는] "톱니바퀴"를 기준으로
        // 붙어있는 "톱니"가 극이 서로 다르다면 반대 방향으로 인접 톱니가 회전한다.
        // 극이 서로 같다면 인접톱니는 회전하지 않는다.
        // 하나가 회전하면 극이 다를때, 인접 톱니바퀴도 회전한다. 다만, 회전 방향은 반대이다.

//        for(int k=1; k<=K; k++) {
//            돌아갈 톱니를 
//            -1, 1 회전하기로 결정.
//            결정된 톱니를 기준으로 인접한 톱니를 확인한다.
//            
//            1: 2->3->4
//            2: 1,3->4
//            3: 2,4->1
//            4: 3->2->1 순으로 확인한다.
//            
//            인접 톱니를 확인하고 같으면 종료
//            다르면 회전시키고 다음 바퀴 검사. 반복.
//        }
        int T = Integer.parseInt(br.readLine());
        for(int t=1; t<=T; t++) {
        	int K = Integer.parseInt(br.readLine());
        	
        	wheel1 = new int[8];
        	wheel2 = new int[8];
        	wheel3 = new int[8];
        	wheel4 = new int[8];
        	String[] str = br.readLine().split(" ");
        	for(int i=0; i<8; i++) {
        		wheel1[i]=Integer.parseInt(str[i]);
        	}
        	String[] str2 = br.readLine().split(" ");
        	for(int i=0; i<8; i++) {
        		wheel2[i]=Integer.parseInt(str2[i]);
        	}
        	String[] str3 = br.readLine().split(" ");
        	for(int i=0; i<8; i++) {
        		wheel3[i]=Integer.parseInt(str3[i]);
        	}
        	String[] str4 = br.readLine().split(" ");
        	for(int i=0; i<8; i++) {
        		wheel4[i]=Integer.parseInt(str4[i]);
        	}
        	
//        	System.out.println(Arrays.toString(wheel1));
//        	System.out.println(Arrays.toString(wheel2));
//        	System.out.println(Arrays.toString(wheel3));
//        	System.out.println(Arrays.toString(wheel4));
        	
        	for(int k=1; k<=K; k++) {
        		st = new StringTokenizer(br.readLine());
        		int wheelNum = Integer.parseInt(st.nextToken()); // 회전할 바퀴
        		int clock = Integer.parseInt(st.nextToken()); // 시계 or 반시계
        		
        		rotate(wheelNum,clock);
        	}
        	
        	int ans=0;
        	if(wheel1[0]==S) ans+=1;
        	if(wheel2[0]==S) ans+=2;
        	if(wheel3[0]==S) ans+=4;
        	if(wheel4[0]==S) ans+=8;
        	System.out.println("#"+t+" "+ans);
        	
        }
        
    }
    
    public static void rotate(int wheelNum, int clock) {
        if(wheelNum==1) { // 1번 톱니바퀴 기준.
            if(wheel1[2]!=wheel2[6]) { // 1번 톱니와 2번 톱니가 상극일때 
                
                if(wheel2[2]!=wheel3[6]) { // 2번 톱니와 3번 톱니가 상극일때
                    
                    if(wheel3[2]!=wheel4[6]) { // 3번 톱니와 4번 톱니가 상극일때
                        // 모든 바퀴가 다 이동
//                        rotateAll(clock);
                    	rotate1(clock);
                    	rotate2(clock*-1);
                    	rotate3(clock);
                    	rotate4(clock*-1);
                        return;
                    }
                    else {
                        rotate1(clock);
                        rotate2(clock*-1);
                        rotate3(clock);
                        return;
                    }
                    
                }
                else {
                    rotate1(clock);
                    rotate2(clock*-1);
                    return;
                }
            }
            else {
                rotate1(clock);
                return;
            }
        }
        
        // 2번 톱니바퀴 기준.
        else if(wheelNum==2) {
        	
        	if(wheel2[2]!=wheel3[6] && wheel3[2]!=wheel4[6]) {
        		if(wheel2[6]!=wheel1[2]) {
        			rotate2(clock);
        			rotate1(clock*-1);
        			rotate3(clock*-1);
        			rotate4(clock);
        			return;
        		}
        		else {
        			rotate2(clock);
        			rotate3(clock*-1);
        			rotate4(clock);
        			return;
        		}
        	}
        	
        	if(wheel2[2]!=wheel3[6]) {
        		if(wheel2[6]!=wheel1[2]) {
        			rotate2(clock);
        			rotate1(clock*-1);
        			rotate3(clock*-1);
        			return;
        		}
        		else {
        			rotate2(clock);
        			rotate3(clock*-1);
        			return;
        		}
        	}
        	
        	if(wheel2[6]!=wheel1[2]) {
        		rotate2(clock);
        		rotate1(clock*-1);
        		return;
        	}
        	else rotate2(clock);  
        }
        
        // 3번 톱니바퀴 기준
        else if(wheelNum==3) {
        	
        	if(wheel3[6]!=wheel2[2] && wheel2[6]!=wheel1[2]) {
        		if(wheel3[2]!=wheel4[6]) {
        			rotate3(clock);
        			rotate2(clock*-1);
        			rotate4(clock*-1);
        			rotate1(clock);
        			return;
        		}
        		else {
        			rotate3(clock);
        			rotate2(clock*-1);
        			rotate1(clock);
        			return;
        		}
        	}
        	
        	if(wheel3[6]!=wheel2[2]) {
        		if(wheel3[2]!=wheel4[6]) {
        			rotate3(clock);
        			rotate2(clock*-1);
        			rotate4(clock*-1);
        			return;
        		}
        		else {
        			rotate3(clock);
        			rotate2(clock*-1);
        			return;
        		}
        	}
        	
        	if(wheel3[2]!=wheel4[6]) {
        		rotate3(clock);
        		rotate4(clock*-1);
        		return;
        	}
        	else rotate3(clock);   
        }
        
        else if(wheelNum==4) {
            if (wheel4[6] != wheel3[2]) { // 4번 톱니와 3번 톱니가 상극일때

                if (wheel3[6] != wheel2[2]) { // 3번 톱니와 2번 톱니가 상극일때

                    if (wheel2[6] != wheel1[2]) { // 3번 톱니와 4번 톱니가 상극일때
                        // 모든 바퀴가 다 이동
                    	rotate1(clock*-1);
                    	rotate2(clock);
                    	rotate3(clock*-1);
                    	rotate4(clock);
                        return;
                    } else {
                        rotate4(clock);
                        rotate3(clock * -1);
                        rotate2(clock);
                        return;
                    }

                } else {
                    rotate4(clock);
                    rotate3(clock * -1);
                    return;
                }
            } else {
                rotate4(clock);
                return;
            }
        }
        
    }
    
    public static void rotate1(int clock) {
        if(clock==1) { // 시계 방향
            Deque<Integer> q = new ArrayDeque();
            for(int i=0; i<8; i++) {
                q.add(wheel1[i]);
            }
            int n = q.pollLast();
            q.addFirst(n);
            int idx=0;
            while(!q.isEmpty()) {
                wheel1[idx++]=q.pollFirst();
            }
        }
        else if(clock==-1) {
            // 1번 (반시계)
            Deque<Integer> q = new ArrayDeque();
            for (int i = 0; i < 8; i++) {
                q.add(wheel1[i]);
            }
            int n = q.pollFirst();
            q.addLast(n);
            int idx = 0;
            while (!q.isEmpty()) {
                wheel1[idx++] = q.pollFirst();
            }
        }
    }
    
    public static void rotate2(int clock) {
        if(clock==1) { // 시계 방향
            Deque<Integer> q = new ArrayDeque();
            for(int i=0; i<8; i++) {
                q.add(wheel2[i]);
            }
            int n = q.pollLast();
            q.addFirst(n);
            int idx=0;
            while(!q.isEmpty()) {
                wheel2[idx++]=q.pollFirst();
            }
        }
        else if(clock==-1) {
            // 1번 (반시계)
            Deque<Integer> q = new ArrayDeque();
            for (int i = 0; i < 8; i++) {
                q.add(wheel2[i]);
            }
            int n = q.pollFirst();
            q.addLast(n);
            int idx = 0;
            while (!q.isEmpty()) {
                wheel2[idx++] = q.pollFirst();
            }
        }
    }
    
    public static void rotate3(int clock) {
        if(clock==1) { // 시계 방향
            Deque<Integer> q = new ArrayDeque();
            for(int i=0; i<8; i++) {
                q.add(wheel3[i]);
            }
            int n = q.pollLast();
            q.addFirst(n);
            int idx=0;
            while(!q.isEmpty()) {
                wheel3[idx++]=q.pollFirst();
            }
        }
        else if(clock==-1) {
            // 1번 (반시계)
            Deque<Integer> q = new ArrayDeque();
            for (int i = 0; i < 8; i++) {
                q.add(wheel3[i]);
            }
            int n = q.pollFirst();
            q.addLast(n);
            int idx = 0;
            while (!q.isEmpty()) {
                wheel3[idx++] = q.pollFirst();
            }
        }
    }
    
    public static void rotate4(int clock) {
        if(clock==1) { // 시계 방향
            Deque<Integer> q = new ArrayDeque();
            for(int i=0; i<8; i++) {
                q.add(wheel4[i]);
            }
            int n = q.pollLast();
            q.addFirst(n);
            int idx=0;
            while(!q.isEmpty()) {
                wheel4[idx++]=q.pollFirst();
            }
        }
        else if(clock==-1) {
            // 1번 (반시계)
            Deque<Integer> q = new ArrayDeque();
            for (int i = 0; i < 8; i++) {
                q.add(wheel4[i]);
            }
            int n = q.pollFirst();
            q.addLast(n);
            int idx = 0;
            while (!q.isEmpty()) {
                wheel4[idx++] = q.pollFirst();
            }
        }
    }
}
