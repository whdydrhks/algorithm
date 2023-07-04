// class Solution {
//     public String solution(int[] food) {
//         String front = "";
//         int idx=food.length/2;
        
//         for(int i=1; i<food.length; i++){
//             int val=food[i]/2;
//             for(int j=0; j<val; j++){
//                 front+=i;
//             }
//         }
//         String back="";
//         for(int i=front.length()-1; i>=0; i--) {
//             back+=front.charAt(i);
//         }
        
//         return front+"0"+back;
//     }
// }
class Solution {
    public String solution(int[] food) {
        String answer = "0";

        for (int i = food.length - 1; i > 0; i--) {
            for (int j = 0; j < food[i] / 2; j++) {
                answer = i + answer + i; 
            }
        }

        return answer;
    }
}
