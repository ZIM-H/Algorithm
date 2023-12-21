import java.util.PriorityQueue;
import java.util.Collections;
import java.util.Arrays;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        Arrays.sort(tangerine);
        
        int cnt = 1;
        for(int i=1; i<tangerine.length; i++){
            if(tangerine[i-1] != tangerine[i]){
                pq.add(cnt);
                cnt = 1;
                continue;
            }
            cnt++;
        }
        pq.add(cnt);
        
        
        int sum = 0;
        while(sum < k) {
            answer++;
            sum += pq.poll();
        }
        
        return answer;
    }
}