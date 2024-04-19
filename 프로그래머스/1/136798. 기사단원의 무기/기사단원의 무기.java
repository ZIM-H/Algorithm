import java.util.*;
class Solution {
    public int solution(int number, int limit, int power) {
        int answer = 0;
        Queue<Integer> q = new ArrayDeque<>();
        for(int i=1; i<=number; i++){
            int cnt = 0;
            for(int j=1; j*j<=i; j++){
                if(j*j == i) {
                    cnt++;
                    continue;
                }
                if(i%j==0) cnt+=2;
                
            }
            q.add(cnt);
        }
        
        while(!q.isEmpty()){
            int value = q.poll();
            if(value > limit) answer += power;
            else answer += value;
        }
        return answer;
    }
}