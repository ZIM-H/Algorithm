import java.util.*;
class Solution {
    public int solution(int[][] jobs) {
        int answer = 0;
        PriorityQueue<int[]> req = new PriorityQueue<>((o1, o2) -> o1[0] == o2[0]? o1[1] - o2[1] : o1[0] - o2[0]);
        PriorityQueue<int[]> res = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        
        for(int[] j : jobs){
            req.add(j);
        }
        
        int now = 0;
        int[] ele;
        while(!req.isEmpty() || !res.isEmpty()){
            while(!req.isEmpty()){
                ele = req.peek();
                if(ele[0] > now) break;
                
                res.add(req.poll());
            }
            
            if(res.isEmpty()){
                ele = req.poll();
                now = ele[0] + ele[1];
                answer += ele[1];
            }
            else{
                ele = res.poll();
                answer += now - ele[0] + ele[1];
                now += ele[1];
            }
        }
        return answer/jobs.length;
    }
}