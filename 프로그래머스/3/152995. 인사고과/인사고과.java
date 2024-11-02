import java.util.*;
class Solution {
    public int solution(int[][] scores) {
        int answer = 1;
        int WH1 = scores[0][0] , WH2 = scores[0][1];
        Arrays.sort(scores, (o1, o2) -> o1[0] == o2[0] ? o1[1] - o2[1] : o2[0] - o1[0]);
        
        int max = 0;
        
        for(int i=0; i<scores.length; i++){
            if(scores[i][1] < max){
                if(scores[i][0] == WH1 && scores[i][1] == WH2) return -1;
            }
            
            else {
                max = scores[i][1];
                if(scores[i][0] + scores[i][1] > WH1 + WH2) answer++;
            }
        }
        return answer;
    }
}