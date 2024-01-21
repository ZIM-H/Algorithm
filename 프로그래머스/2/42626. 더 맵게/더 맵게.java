import java.util.*;
class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        
        if(K == 0) return 0;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int i : scoville){
            pq.add(i);
        }
            
        while(!pq.isEmpty()){
            int one = pq.poll();
            if(one >= K) break;
            if(pq.size() == 0 && one < K) return -1; 
            
            pq.add(one + (pq.poll()*2));
            answer += 1;
        }
        
        return answer;
    }
}