import java.util.*;
class Solution {
    public int solution(String s) {
        int answer = 0;
        
        char now = s.charAt(0);
        int cnt = 0;
        
        for(char c : s.toCharArray()){
            if(cnt == 0) {
                now = c;
                cnt++;
                continue;
            }
            
            if(c == now) cnt++;
            else cnt--;
            
            if(cnt == 0) answer++;
        }
        
        if(cnt > 0) answer++;
         
        return answer;
    }
}