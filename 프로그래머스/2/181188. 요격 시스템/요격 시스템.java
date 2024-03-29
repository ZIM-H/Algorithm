import java.util.*;
class Solution {
    public int solution(int[][] targets) {
        int answer = 0;
        Arrays.sort(targets, (o1, o2) -> {
           return o1[1] == o2[1] ? o1[0] - o2[0] : o1[1] - o2[1];
        });
        
        int max = targets[0][1];
        answer++;
        
        for(int[] t : targets){
            if(t[0] >= max){
                answer++;
                max = t[1];
            }
        }
        return answer;
    }
}