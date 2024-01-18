import java.util.*;

class Solution {
    static int answer;
    static boolean[] check;
    
    public int solution(int k, int[][] dungeons) {
        answer = -1;
        check = new boolean[dungeons.length];
        
        dfs(k, 0, dungeons);
        
        return answer;
    }
    
    public static void dfs(int k , int result, int[][] dungeons){
        for(int i=0; i<dungeons.length; i++){
            if(!check[i] && k >= dungeons[i][0]){
                check[i] = true;
                dfs(k - dungeons[i][1], result + 1, dungeons);
                check[i] = false;
            }
        }
        answer = Math.max(answer, result);
    }
}