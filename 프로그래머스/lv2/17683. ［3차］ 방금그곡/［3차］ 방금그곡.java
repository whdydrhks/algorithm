import java.util.*;
class Solution {
    static class Music{
        String title;
        int len;
        Music(String title, int len) {
            this.title=title;
            this.len=len;
        }
    }
    
    static ArrayList<Music> list;
    
    public String solution(String m, String[] musicinfos) {        
        String answer = "";
        list = new ArrayList<>();
        m=m.replace("C#", "Q");
        m=m.replace("D#", "W");
        m=m.replace("F#", "S");
        m=m.replace("G#", "X");
        m=m.replace("A#", "Y");
        // System.out.println(m);
        for(int i=0; i<musicinfos.length; i++){
            String[] tmp = musicinfos[i].split(",");
            String start = tmp[0];
            String end = tmp[1];
            String title = tmp[2];
            String music = tmp[3];
            music=music.replace("C#", "Q");
            music=music.replace("D#", "W");
            music=music.replace("F#", "S");
            music=music.replace("G#", "X");
            music=music.replace("A#", "Y");
            int len = timeDiff(start, end);
            // if(len<m.length()) continue;
            
            String repeat="";
            if(len<music.length()) {
                repeat = music.substring(0,len);
            }
            else {
                repeat = makeMusic(music, len);
            }
            check(m,repeat,len,title);      
        }
        
        // for(Music tm:list) {
        //     System.out.println("Title: "+tm.title);
        //     System.out.println("Len: "+tm.len);
        // }
        
        if(list.size()>0) {
            int max=0;
            for(Music mus : list) {
                if(mus.len>max) {
                    max=mus.len;
                }
            }
            
            for(Music mus:list) {
                if(mus.len==max) {
                    answer= mus.title;
                    break;   
                }
            }
            return answer;
        }
        else return "(None)";
        
    }
    
    public static String makeMusic(String music, int len) {
        String tmp="";
        for(int i=0, idx=0; i<len; i++, idx++){
            if(idx==music.length()) {
                idx=0;
            }
            tmp+=music.charAt(idx);
        }
        // System.out.println(tmp);
        return tmp;
    }
    
    public static int timeDiff(String start, String end) {
        String startHour = start.substring(0,2);
        String endHour = end.substring(0,2);
        String startMinute = start.substring(3,5);
        String endMinute = end.substring(3,5);
        
        int start_minute = Integer.parseInt(startMinute);
        int end_minute = Integer.parseInt(endMinute);
        int start_hour = Integer.parseInt(startHour);
        int end_hour = Integer.parseInt(endHour);
        
        if(start_minute>end_minute) {
            end_hour-=1;
            end_minute+=60;
        }
        int minute_diff = end_minute-start_minute;
        int hour_diff = end_hour - start_hour;
        return hour_diff*60 + minute_diff;
        
    }
    
    public static void check(String m, String music, int len, String title) {
        if(music.contains(m)) {
            list.add(new Music(title, len));
        }
    }
}

// 음악끝-음악시작으로 총 길이 구하기. M
// 악보의 길이 구하기. N
// M-N>=0 : 총길이가 더 길다.
// M-N<0 : 악보가 더 길다. -> substring? 문제 다시

// 입력 m
// N/m : mok
// N*mok 해서 길이 구하기.

// 조건이 일치하는 음악이 여러 개일 때에는 라디오에서 재생된 시간이 제일 긴 음악 제목을 반환한다. 
// 재생된 시간도 같을 경우 먼저 입력된 음악 제목을 반환한다.