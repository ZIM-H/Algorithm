import java.util.*;
class Solution {
    public int solution(String[][] book_time) {
        int answer = 0;
        int[] booked = new int[24*60 + 10];
        
        for(String[] time : book_time){
            booked[cal(time[0])] += 1;
            booked[cal(time[1])+10] -= 1;
        }
        
        for(int i=1; i<booked.length; i++){
            booked[i] += booked[i-1];
            answer = Math.max(answer, booked[i]);
        }
        
        return answer;
    }
    
    static int cal(String time){
        String[] t = time.split(":"); 
        return Integer.parseInt(t[0])*60 + Integer.parseInt(t[1]);
    }
}