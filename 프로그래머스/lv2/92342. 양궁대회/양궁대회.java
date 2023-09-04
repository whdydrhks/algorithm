import java.util.*;
class Solution {
    static int maxDiff;
    static ArrayList<int[]> list;
    public int[] solution(int n, int[] info) {
        int[] answer = new int[11];
        maxDiff=0; // 최대 점수 차
        list = new ArrayList<>();

        for(int i=0; i<11; i++){
            lionInfo(answer, i, info, 0, 0, n);
        }
        if(maxDiff==0) {
            int[] ans = {-1};
            return ans;
        }
        else {
            // 리스트 정렬. 
            Collections.sort(list, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    for (int i = 10; i >= 0; i--) {
                        if (o1[i] != o2[i]) {
                            return o2[i] - o1[i];
                        }
                    }
                return 0;
                }
            });

            return list.get(0);
        }
    }
    
    public static int calculation(int[] answer, int[] info) {
        int appeach=0;
        int lion=0;
        for(int i=0; i<11; i++){
            if(answer[i]>info[i]) {
                lion += (10-i);
            }
            else if(answer[i]==0 && info[i]==0) continue;
            else {
                appeach += (10-i);
            }
        }
        return lion-appeach;
    }

    public static void lionInfo(int[] answer, int idx, int[] info, int depth, int count, int n) {
        if( (idx>=11 || depth==11) && count==n) {
             int diffScore = calculation(answer, info);
             if(diffScore==maxDiff) {
                 list.add(answer.clone());
             }
             else if(diffScore > maxDiff) {
                 maxDiff=diffScore;
                 list = new ArrayList<>();
                 list.add(answer.clone());
             }
             return;
        }
        else if( (idx>=11 || depth==11) && count!=n) return;

        for(int i=0; i<=info[idx]+1; i++){
            answer[idx]=i;
            lionInfo(answer, idx+1, info, depth+1, count+i, n);
            answer[idx]=0;
        }
    }
    
}

// 고려사항 => 라이언 우승이 목표
// 1. a=b의 경우 어피치가 점수를 가져간다.
// 2. 최종 점수가 같으면 어피치가 우승.
// 3. 어떻게해도 라이언이 우승을 못하면 [-1]: 무조건 지거나, 비기는 경우
// 4. 우승의 경우의 수가 여러개인 경우 -> 가장 낮은 점수를 더 많이 맞힌 경우를 return
// 5. 최대 점수 차

// 과정
// 1. 라이언의 info 배열을 만든다.
// 2. 최대 점수 차가 만들어지는 배열을 리스트에 담는다.
//    - 최대 점수가 아니면 제거.
// 3. 리스트의 배열을 고려사항4번을 체크한다.
// 4. 리스트가 0이면 -1 리턴.

// 식
// 1. 각 k점의 라이언의 화살 수는 어피치의 화살수보다 +1이면 계산하고 리턴.

// 배운점
// list에 int[]를 담고 오름차순, 내림차순 정렬을 할 때,
// Comparable-compareTo는 안된다. Comparator-compare를 사용하기