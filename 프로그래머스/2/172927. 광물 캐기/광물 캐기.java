import java.util.*;
class Solution {
    public int solution(int[] picks, String[] minerals) {
        int answer = 0;
        int pickLen = Math.min(picks[0]+picks[1]+picks[2], minerals.length/5+1);
        int[][] value = new int[pickLen][3];
        
        
        for(int i=0; i<minerals.length; i+=5){
            int di = 0, ir = 0, st = 0;
            
            if(i/5 == pickLen) break;
            for(int j=i; j<i+5; j++){
                if(minerals[j].charAt(0) == 'd'){
                    di += 1;
                    ir += 5;
                    st += 25;
                }
                else if(minerals[j].charAt(0) == 'i'){
                    di += 1;
                    ir += 1;
                    st += 5;
                }
                else{
                    di += 1;
                    ir += 1;
                    st += 1;
                }
                
                if(j == minerals.length-1) break;
            }
            
            value[i/5][0] = di;
            value[i/5][1] = ir;
            value[i/5][2] = st;
        }
        
        Arrays.sort(value, (o1,o2) -> (o2[2] - o1[2]));
        
        for(int i=0; i<pickLen; i++){
            if(picks[0] != 0){
                answer += value[i][0];
                picks[0] -= 1;
            }
            else if(picks[1] != 0){
                answer += value[i][1];
                picks[1] -= 1;
            }
            else if(picks[2] != 0){
                answer += value[i][2];
                picks[2] -= 1;
            }
        }
        
        return answer;
    }
}