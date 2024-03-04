import java.util.*;
class Solution {
    public int solution(int[][] jobs) {
        int answer = 0;
        Arrays.sort(jobs, (o1, o2) -> o1[0] == o2[0]? o1[1] - o2[1] : o1[0] - o2[0]);
        // PriorityQueue<int[]> req = new PriorityQueue<>((o1, o2) -> o1[0] == o2[0]? o1[1] - o2[1] : o1[0] - o2[0]);
        PriorityQueue<int[]> res = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        
        // for(int[] j : jobs){
        //     req.add(j);
        // }
        
        int now = 0;
        int idx = 0;
        int[] ele;
        while(idx < jobs.length || !res.isEmpty()){
            while(idx < jobs.length){
                ele = jobs[idx];
                if(ele[0] > now) break;
                
                res.add(ele);
                idx++;
            }
            
            if(res.isEmpty()){
                ele = jobs[idx];
                now = ele[0] + ele[1];
                answer += ele[1];
                idx++;
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