import java.util.*;
class Solution {
    public String solution(String X, String Y) {
        int[][] num = new int[2][10];
        
        for(int i=0; i<X.length(); i++){
            num[0][X.charAt(i)-'0']++;
        }
        
        for(int i=0; i<Y.length(); i++){
            num[1][Y.charAt(i)-'0']++;
        }
        
        StringBuilder ans = new StringBuilder();
        for(int i=0; i<10; i++){
            for (int j = 0; j < Math.min(num[1][i], num[0][i]); j++) {
                ans.append(i);
            }
        }
        
        ans.reverse();
        String answer = ans.toString();
        
        if(answer.equals("")) return "-1";
        else if(answer.charAt(0) == '0') return "0";
        else return answer;
    }
}