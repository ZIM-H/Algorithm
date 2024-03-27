import java.util.*;
class Solution {
    public String solution(String[] survey, int[] choices) {
        int[] point = {3,2,1,0,1,2,3};
        char[][] type = {{'R','T'},{'C','F'},{'J','M'},{'A', 'N'}};
        Map<Character,Integer> cnt = new HashMap<>();
        
        for(char[] c : type){
            cnt.put(c[0], 0);
            cnt.put(c[1], 0);
        }
        
        for(int i=0; i<survey.length; i++){
            if(choices[i] > 4) cnt.put(survey[i].charAt(1), cnt.get(survey[i].charAt(1)) + point[choices[i]-1]);
            else if(choices[i] == 4) continue;
            else cnt.put(survey[i].charAt(0),  cnt.get(survey[i].charAt(0)) + point[choices[i]-1]);
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<4; i++){
            int idx = cnt.get(type[i][0]) >= cnt.get(type[i][1]) ? 0 : 1;
            sb.append(type[i][idx]);
        }
        return sb.toString();
    }
}