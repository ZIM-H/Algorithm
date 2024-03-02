import java.util.*;
class Solution {
    static Long half;
    public int solution(int[] queue1, int[] queue2) {
        int answer = 0;
        Queue<Integer> q1 = new ArrayDeque<>();
        Queue<Integer> q2 = new ArrayDeque<>();
        
        long len = (long) queue1.length * 4;
        long sum1 = 0L, sum2 = 0L;
        for(int i=0; i<queue1.length; i++){
            sum1 += queue1[i];
            sum2 += queue2[i];
            q1.add(queue1[i]);
            q2.add(queue2[i]);
        }
        
        int cnt = 0;
        while(true){
            if(cnt > len) {
                answer = -1;
                break;
            }
            
            if(sum1 > sum2){
                int num = q1.poll();
                q2.add(num);
                sum1 -= num;
                sum2 += num;
            }
            else if(sum1 < sum2){
                int num = q2.poll();
                q1.add(num);
                sum1 += num;
                sum2 -= num;
            }
            else {
                answer = cnt;
                break;
            }
            cnt++;
        }
        
        return answer;
    }
}