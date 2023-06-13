import java.io.*;
import java.util.*;

public class Solution {
	
	static int N;
	static int[][] map;
	static boolean[] v;
	static ArrayList<Pos> people;
	static int ans;
	
	static DistPerson stair1;
	static DistPerson stair2;
	
	static class Pos {
		int x, y;

		public Pos(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

		@Override
		public String toString() {
			return "Pos [x=" + x + ", y=" + y + "]";
		}
		
	}
	
	static class DistPerson implements Comparable<DistPerson> {
		int x, y, d, k;

		public DistPerson(int x, int y, int d, int k) {
			super();
			this.x = x;
			this.y = y;
			this.d = d;
			this.k = k;
		}

		@Override
		public String toString() {
			return "DistPerson [x=" + x + ", y=" + y + ", d=" + d + "]";
		}

		@Override
		public int compareTo(DistPerson dp) {
			return this.d - dp.d;
		}
		
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			
			people = new ArrayList<>();
			boolean isStair = false;
			
			stair1 = null;
			stair2 = null;
			
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if(map[i][j]==1) people.add(new Pos(i,j));
					else if(map[i][j]!=1 && map[i][j]!=0 && !isStair) {
						stair1 = new DistPerson(i,j, map[i][j], map[i][j]);
						stair1.k=map[i][j];
						isStair = true;
					}
					else if(map[i][j]!=1 && map[i][j]!=0) {
						stair2 = new DistPerson(i,j, map[i][j], map[i][j]);
						stair2.k=map[i][j];
					}
				}
			}
			
			
			
//		System.out.println(stair2.toString());
			
			ans = Integer.MAX_VALUE;
			v = new boolean[people.size()];
			subset(0);
			System.out.println("#"+t+" "+(ans-1));
			
		}
		// 계단의 입구는 반드시 2개.
		// 1: 사람, 2:계단 입구 - 계단 길이.
		
		// * 가장 가까운 계단으로만 이동하는건 아니다.
	
	}
	
	public static void subset(int depth) {
		if(depth==people.size()) {
			ArrayList<DistPerson> stair1List = new ArrayList<>();
			ArrayList<DistPerson> stair2List = new ArrayList<>();
			for(int i=0; i<v.length; i++) {
				if(v[i]) stair1List.add(new DistPerson(people.get(i).x, people.get(i).y, Math.abs(people.get(i).x - stair1.x)+ Math.abs(people.get(i).y - stair1.y), stair1.k ));
				else stair2List.add(new DistPerson(people.get(i).x, people.get(i).y, Math.abs(people.get(i).x - stair2.x)+ Math.abs(people.get(i).y - stair2.y), stair2.k ));
			}
			
			// 계단 위에는 동시에 최대 3명 까지만 올라가 있을 수 있다. - 이게 걸리네.(List에 담긴 같은 d가 4명 이상이면 안된다는 거)
			//if(overThree(stair1List, stair2List)) return;
			
			// 계단 내려가기 계산.
			ans = Math.min(ans, downStair(stair1List, stair2List));
			return;
		}
		
		v[depth] = false;
		subset(depth+1);
		
		v[depth] = true;
		subset(depth+1);
	}
	
	public static int downStair(ArrayList<DistPerson> stair1List, ArrayList<DistPerson> stair2List) {
		// 제일 가까운 사람 먼저.
		Collections.sort(stair1List);
		Collections.sort(stair2List);
				
		// 계단 내려가는 시간 
		// 입구에 도착하면 1분 후, 아래칸으로 내려갈 수 있다.
		// 계단 위에는 동시에 최대 3명 까지만 올라가 있을 수 있다. - (List에 담긴 같은 d가 4명 이상이면 안된다는 거)
		// 이미 계단을 3명이 내려가고 있는 경우, 그 중 한 명이 계단을 완전히 내려갈 때까지 계단 입구에서 대기해야 한다.
		// K분.
		
		// 먼저 List의 D를 다 더한다.
		// 3명씩 remove.
		
		// 사람 수는 1이상 10이하...
		
		// 1번 계단 내려가기 - LenOne
		int sum1=0;
		int time1=0;

		ArrayList<DistPerson> wait1 = new ArrayList<>();
		
		int len = stair1List.size();
//		System.out.println("stair1 "+stair1List.toString()+" size: "+len);			
		while (true) {
//			System.out.println("here1" + " " + time1);
//			System.out.println("wait1 " + wait1.toString());
//			System.out.println("sum1 " + sum1);
//			System.out.println();
			time1++;

			if (sum1 == len) {
				time1--;
				break;
			}

			if (wait1.size() > 0) {
				for (int i = 0; i < wait1.size(); i++) {
					wait1.get(i).k--;
					if (wait1.get(i).k <= 0) {
						sum1++;
						wait1.remove(wait1.get(i--));
					}
				}
			}

			for (int i = 0; i < stair1List.size(); i++) { // 모든 계단1 사람을 돌면서
				if (stair1List.get(i).d + 1 < time1) { // 계단에 도착!
					if (wait1.size() < 3) { // 계단1에 사람이 3명이 안되면
						wait1.add(new DistPerson(stair1List.get(i).x, stair1List.get(i).y, stair1List.get(i).d,
								stair1.k)); // 계단1에 3명을 넣는다.
						stair1List.remove(stair1List.get(i--));
					}
				}
			}
		}
		
		int sum2=0;
		int time2=0;

		ArrayList<DistPerson> wait2 = new ArrayList<>();
		
		int len2 = stair2List.size();
//		System.out.println("stair1 "+stair1List.toString()+" size: "+len);			
		while (true) {
//			System.out.println("here1" + " " + time1);
//			System.out.println("wait1 " + wait1.toString());
//			System.out.println("sum1 " + sum1);
//			System.out.println();
			time2++;

			if (sum2 == len2) {
				time2--;
				break;
			}

			if (wait2.size() > 0) {
				for (int i = 0; i < wait2.size(); i++) {
					wait2.get(i).k--;
					if (wait2.get(i).k <= 0) {
						sum2++;
						wait2.remove(wait2.get(i--));
					}
				}
			}

			for (int i = 0; i < stair2List.size(); i++) { // 모든 계단1 사람을 돌면서
				if (stair2List.get(i).d + 1 < time2) { // 계단에 도착!
					if (wait2.size() < 3) { // 계단1에 사람이 3명이 안되면
						wait2.add(new DistPerson(stair2List.get(i).x, stair2List.get(i).y, stair2List.get(i).d,
								stair2.k)); // 계단1에 3명을 넣는다.
						stair2List.remove(stair2List.get(i--));
					}
				}
			}
		}
		
		return Math.max(time1, time2);
//		System.out.println("time1 !!!!! : "+time1);
//		return time1;
	}
	
	public static boolean overThree(ArrayList<DistPerson> stair1List, ArrayList<DistPerson> stair2List) {
		Collections.sort(stair1List);
		Collections.sort(stair2List);
		
		boolean check = false;
		int num = stair1List.get(0).d;
		int cnt = 0;
		
		if(stair1List.size()!=1 && stair1List.size()!=0 ) {
			for(int i=1; i<stair1List.size(); i++) {
				if(num==stair1List.get(i).d) cnt++;
				else {
					num = stair1List.get(i).d;
					cnt=0;
				}
				
				if(cnt>3) return true;
			}			
		}
		
		num = stair2List.get(0).d;
		cnt = 0;
		
		if (stair2List.size() != 1 && stair2List.size() != 0) {
			for (int i = 1; i < stair2List.size(); i++) {
				if (num == stair2List.get(i).d)
					cnt++;
				else {
					num = stair2List.get(i).d;
					cnt = 0;
				}

				if (cnt > 3) return true;
			}
		}
		
		return check;
	}
}
