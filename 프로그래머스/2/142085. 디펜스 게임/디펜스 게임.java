import java.util.*;
class Solution {
    public int solution(int n, int k, int[] enemy) {
        int answer = enemy.length;
        PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int i=0; i<enemy.length; i++){
            n -= enemy[i];
            q.add(enemy[i]);
            
            if(n < 0){
                if(k > 0 && !q.isEmpty()){
                    n += q.poll();
                    k--;
                }
                else {
                    answer = i;
                    break;
                }
            }
        }
        return answer;
    }
}