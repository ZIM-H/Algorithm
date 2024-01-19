import java.util.*;
class Solution {
    int solution(int[][] land) {
        int answer = -1;
        int[][] value = new int[land.length][4];
        
        value[0][0] = land[0][0];
        value[0][1] = land[0][1];
        value[0][2] = land[0][2];
        value[0][3] = land[0][3];
        
        if(land.length >= 2){
            for(int i=1; i<land.length; i++){
                for(int p=0; p<4; p++){
                    int maxValue = -1;
                    for(int q=0; q<4; q++){
                        if(p != q) {
                            maxValue = Math.max(maxValue, value[i-1][q]);
                        }
                    }
                    value[i][p] += land[i][p] + maxValue;
                }
            }
        }

        for(int i=0; i<4; i++){
            answer = Math.max(answer, value[land.length-1][i]);
        }
        return answer;
    }
}