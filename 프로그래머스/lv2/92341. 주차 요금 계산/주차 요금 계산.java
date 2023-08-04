import java.util.*;
class Solution {
    public int[] solution(int[] fees, String[] records) {
        int[] answer = {};
        HashMap<String, Integer> hmap = new HashMap<>(); // car_num, time
        for(int i=records.length-1; i>=0; i--) {
            String[] strarr = records[i].split(" ");
            String car_number = strarr[1];
            int time = whatTime(strarr[0]);

            String type = strarr[2];
            if(type.equals("IN")) {
                if(!hmap.containsKey(car_number)) { // 당일 출차 안함
                    int tmp_time = whatTime("23:59");
                    hmap.put(car_number, tmp_time-time);
                }
                else if(hmap.containsKey(car_number)) {
                    int my_time = hmap.get(car_number);
                    hmap.put(car_number, my_time-time);
                }
            }
            else if(type.equals("OUT")) {
                if(!hmap.containsKey(car_number)) hmap.put(car_number, time);
                else {
                    int my_time = hmap.get(car_number);
                    hmap.put(car_number, my_time + time);
                }
            }
        }
        
        ArrayList<String> list = new ArrayList<>();
        for(String car : hmap.keySet()) {
            list.add(car);
        }
        
        Collections.sort(list);
        answer = new int[list.size()];
        for(int i=0; i<answer.length; i++){
            // System.out.println("Car: "+list.get(i));
            int time = hmap.get(list.get(i));
            // System.out.println("Time: "+time);
            int money = fees[1];
            
            if(time>fees[0]) {    
                if((time-fees[0])%fees[2] != 0) {
                    int tmp_money = ((int)((time-fees[0])/fees[2])+1)*fees[3];
                    money+=tmp_money;
                }
                else {
                    int tmp_money = ((time-fees[0])/fees[2])*fees[3];
                    money+=tmp_money;
                }
            }
            

            if(money<fees[1]) {
                money=fees[1];
            }
            // System.out.println("Money: "+money);
            // System.out.println();

            answer[i]=money;
        }
        
        return answer;
    }
    
    public static int whatTime(String str) {
        int hour = (str.charAt(0)-'0') * 10 +(str.charAt(1)-'0');
        int minute = (str.charAt(3)-'0')*10 + (str.charAt(4)-'0');
        return hour*60+minute;
    }
}

// < ? >
// list에 Car객체(String, int) 를 담는데,
// list.contains( )로 String만 검사가 가능한지.