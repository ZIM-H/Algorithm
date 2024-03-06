import java.util.*;
class Solution {
    public int solution(int n) {
        int answer = n+1;
        int cnt = Integer.bitCount(n);
        while(answer <= 1000000){
            if(Integer.bitCount(answer) == cnt) break;
            answer++;
        }
        return answer;
    }
}