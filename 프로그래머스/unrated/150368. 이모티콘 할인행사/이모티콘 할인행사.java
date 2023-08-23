import java.util.*;
class Solution {
    static int[] ratio = {10,20,30,40};
    static int max_subscriber;
    static int max_margin;
    public int[] solution(int[][] users, int[] emoticons) {
        int[] answer = new int[2];
        int[] discount = new int[emoticons.length];
        max_subscriber = Integer.MIN_VALUE;
        max_margin = Integer.MIN_VALUE;

        perm2(0, discount, users, emoticons, emoticons.length);
        answer[0]=max_subscriber;
        answer[1]=max_margin;
        
        // System.out.println(Arrays.toString(answer));
        return answer;
    }
    
    public static void perm2(int depth, int[] discount, int[][] users, int[] emoticons, int limit) {
        if(depth==limit) {
            // 할인율에 대한 이모티콘 가격, users 비교해서 구독, 마진 구하기
            int[] tmp = checkNumber(discount, users, emoticons); // [구독, 마진]
            if(max_subscriber<tmp[0]) {
                max_subscriber = tmp[0];
                max_margin = tmp[1];
            }
            else if(max_subscriber==tmp[0]) {
                max_subscriber=tmp[0];
                max_margin = Math.max(max_margin,tmp[1]);
            }
            return;
        }
        
        for(int i=0; i<4; i++){
            discount[depth] = ratio[i];
            perm2(depth+1, discount, users, emoticons, limit);
        }
    }
    
    public static int[] checkNumber(int[] discount, int[][] users, int[] emoticons) {
        int[] tmp = new int[2];
        int sum=0;
        int subscriber=0;

        for(int i=0; i<users.length; i++){ // 각 유저에 대한
            int sum_price=0;
            for(int j=0; j<emoticons.length; j++){ // 각 이모티콘
                if(users[i][0]<=discount[j]) { // 할인율 비교
                    int price = (100-discount[j])*emoticons[j] / 100;
                    sum_price+=price;
                }
            }
            if(sum_price>=users[i][1]) { // 최소비용 이상이 발생 => 구독
                subscriber+=1;
            }
            else {
                sum+=sum_price;
            }
        }
        tmp[0]=subscriber;
        tmp[1]=sum;
//        System.out.println("--------------");
//        System.out.println("Discount: "+Arrays.toString(discount));
//        System.out.println("Result: "+Arrays.toString(tmp));
//        System.out.println();
        return tmp;
        
    }
}

// 할인율을 중복순열로 설정
// 해당 할인율에 대한 가입자, 마진 구하기.