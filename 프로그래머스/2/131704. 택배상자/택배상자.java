import java.util.*;
class Solution {
    public int solution(int[] order) {
        int answer = 0;
        Queue<Integer> q = new ArrayDeque<>();
        Stack<Integer> s = new Stack<>();
        
        for(int i=1; i<=order.length; i++){
            q.add(i);
        }
        
        int idx = 0;
        while(true){
            if(q.isEmpty() && s.isEmpty()) break;
            if(!q.isEmpty() && order[idx] >= q.peek()){
                int num = q.peek();
                for(int i=num; i<order[idx]; i++){
                    s.push(q.poll());    
                }
                q.poll();
                answer++;
                idx++;
                continue;
            }
            
            if(!s.isEmpty() && s.peek() == order[idx]){
                s.pop();
                answer++;
                idx++;
                continue;
            }
            else break;
        
        }
        return answer;
    }
}