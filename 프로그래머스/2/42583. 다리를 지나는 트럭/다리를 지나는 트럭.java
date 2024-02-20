import java.util.*;
class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 1;
        
        int truckCnt = 0;
        int sum = 0, cnt = 0, idx = 0;
        Queue<Integer> q = new ArrayDeque<>();
        
        while(truckCnt != truck_weights.length){
            if(idx < truck_weights.length && sum + truck_weights[idx] <= weight && cnt + 1 <= bridge_length) {
                q.add(truck_weights[idx]);
                sum += truck_weights[idx];
                idx++;
                cnt++;
            }
            else {
                q.add(0);
                cnt++;
            }
            
            if(cnt == bridge_length){
                int out = q.poll();
                if(out != 0) {
                    sum -= out;
                    truckCnt++;
                }
                cnt--;
            }
            answer++;
        }
        
        return answer;
    }
}