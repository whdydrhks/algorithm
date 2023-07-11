import java.io.*;
import java.util.*;

public class Solution {

	static int N, M, adjMatrix[][];
	static int gtCnt, ltCnt; 
	static int cnt;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			N = Integer.parseInt(br.readLine());
			M = Integer.parseInt(br.readLine());
			
			adjMatrix = new int[N+1][N+1]; // 학생번호 1부터 처리
			
			StringTokenizer st = null;
			for(int m=0; m<M; m++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				adjMatrix[a][b] = 1; // a보다 b가 크다.
			}
			
			int answer = 0;
			for(int i=1; i<=N; i++) { // 모든 학생을 탐색의 시작점으로 하여 반복
				gtCnt = ltCnt = 0; // 초기화
				gtDFS(i, new boolean[N+1]);
				ltDFS(i, new boolean[N+1]);
				if(gtCnt + ltCnt == N-1) answer++;
			}
			System.out.println("#"+t+" "+answer);
		}
	}
	
	static void gtDFS(int cur, boolean[] visited) { // cur 학생부터 키가 큰 학생따라 탐색
			
		visited[cur] = true;
		
		for(int i=1; i<=N; i++) { // 인접행렬에서 자신의 열로 간선정보를 갖고 있는 정점 들여다보기
			if(adjMatrix[cur][i]==1 && !visited[i]) { // i가 cur보다 키가 크고 아직 탐색되지 않았다면
				gtCnt++; // 나보다 큰 학생 카운트
				gtDFS(i, visited);
			}
		}
	}
	
	static void ltDFS(int cur, boolean[] visited) { // cur 학생부터 키가 작은 학생따라 탐색
		
		visited[cur] = true;
		
		for(int i=1; i<=N; i++) { // 인접행렬에서 자신의 열로 간선정보를 갖고 있는 정점 들여다보기
			if(adjMatrix[i][cur]==1 && !visited[i]) { // i가 cur보다 키가 작고 아직 탐색되지 않았다면
				ltCnt++; // 나보다 작은 학생 카운트
				ltDFS(i, visited);
			}
		}
	}
}

/*
input
1
6
6
1 5
3 4
5 4
4 2
4 6
5 2

output
1
 */