import java.util.*;
class Solution {
    public int solution(int[][] routes) {
        Arrays.sort(routes, (o1, o2) -> o1[1] == o2[1] ? o1[0] - o2[0] : o1[1] - o2[1]);
        
        int max = routes[0][1];
        int answer = 1;
        
        for(int[] route : routes){
            if(route[0] > max){
                max = route[1];
                answer++;
            }
        }
        return answer;
    }
}