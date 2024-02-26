import java.util.*;
class Solution {
    public int solution(String s) {
        int answer = 0;
        char[] alpha = s.toCharArray();
        
        boolean flag = false;
        char now = '0';
        int cnt = 0;
        for(int i=0; i<alpha.length; i++){
            if(!flag) {
                flag = true;
                now = alpha[i];
                cnt++;
                continue;
            }
            
            if(alpha[i] == now) cnt++;
            else cnt--;
            
            if(cnt == 0) {
                answer++;
                flag = false;
            }
        }
        cnt = flag == false ? cnt : 1;
         
        return answer + cnt;
    }
}