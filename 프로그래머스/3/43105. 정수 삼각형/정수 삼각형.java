import java.util.*;
class Solution {
    public int solution(int[][] triangle) {
        int answer = triangle[0][0];
        int len = triangle.length;
        
        if(len > 1){
            int[][] value = new int[triangle.length][triangle[len-1].length];
            value[0][0] = triangle[0][0];
            
            for(int i=1; i<len; i++){
                value[i][0] = value[i-1][0] + triangle[i][0];
                for(int j=1; j<=i; j++){
                    value[i][j] = Math.max(value[i-1][j-1], value[i-1][j]) + triangle[i][j];
                }
            }
            
            for(int i=0; i<triangle[len-1].length; i++){
                answer = Math.max(answer, value[len-1][i]);
            }
        }
        
        return answer;
    }
}