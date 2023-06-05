import java.io.*;
import java.util.*;

public class Solution {
	static int D,W,K;
	static int[][] map;
	static boolean flag;
	static int ans;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			st = new StringTokenizer(br.readLine());
			D = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			map = new int[D][W];
			
			for(int i=0; i<D; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<W; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			flag = false;
			// 초기 전체 열 검사
			if(AllCol(map) || K==1) {
				ans=0; 
			}
			else {
				select();
			}
			System.out.println("#"+t+" "+ans);
		}
	}
	
	public static void select() {
		for(int i=1; i<=D; i++) {
			int[] b = new int[i]; // (행-약)을 담는 배열
			int[] type = new int[i]; // 타입을 담는 배열
			comb(0,0,i,b,type); // depth, start, limit, 약, 타입
		}
	}
	
	public static void comb(int depth, int start, int limit, int[] b, int[] type) {
		if(flag) return;
		
		if(depth==limit) {
			flag = injection(b,type);
			if(flag) ans=b.length;
			return;
		}
		
		for(int i=start; i<D; i++) {
			b[depth]=i;
			type[depth]=0;
			comb(depth+1, i+1, limit, b, type);
			
			b[depth]=i;
			type[depth]=1;
			comb(depth+1, i+1, limit, b, type);
		}
	}
	
	public static boolean injection(int[] b, int[] type) {
		// 임시 지도에다가
		// 뽑힌 행에 대하여 type을 주입한다.
		int[][] t_map = new int[D][W];
		for(int i=0; i<D; i++) {
			t_map[i]=map[i].clone();
		}
		
		for(int i=0; i<b.length; i++) {
			for(int col=0; col<W; col++) {
				t_map[b[i]][col]=type[i];
			}
		}			
		
		boolean res = AllCol(t_map);
		return res;
		
	}
	
	public static boolean AllCol(int[][] t_map) {
		boolean res = false;
		for(int i=0; i<W; i++) {
			res = checkCol(i, t_map);
			if(!res) return false;
		}
		return res;
	}
	
	public static boolean checkCol(int col, int[][] t_map) {
		int cntA=0;
		for(int i=0; i<D; i++) {
			if(t_map[i][col]==0) cntA++;
			else if(t_map[i][col]==1) cntA=0;
			
			if(cntA>=K) return true;
		}
		
		int cntB=0;
		for(int i=0; i<D; i++) {
			if(t_map[i][col]==1) cntB++;
			else if(t_map[i][col]==0) cntB=0;
			
			if(cntB>=K) return true;
		}
		return false;
	}
}