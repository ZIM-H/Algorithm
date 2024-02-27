import java.util.*;
class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int[][] value = new int[n][m];
        value[0][0] = 1;
        
        for(int i=0; i<puddles.length; i++){
            value[puddles[i][1]-1][puddles[i][0]-1] = -1;
        }
        
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(value[i][j] != -1){
                    if(i != 0 && value[i-1][j] > 0) value[i][j] += value[i-1][j];
                    if(j != 0 && value[i][j-1] > 0) value[i][j] += value[i][j-1];
                    
                    if(value[i][j] > 1000000007) value[i][j] %= 1000000007;
                }
            }
        }
        return value[n-1][m-1];
    }
}