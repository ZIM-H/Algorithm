import java.util.*;

class Solution {
    static List<int[]> ans;
    static int[] maxboard;
    static int max;
    
    public int[] solution(int n, int[] info) {
        ans = new ArrayList<>();
        maxboard = new int[11];
        max = 0;
        
        dfs(0, n, new int[11], info);
        
        if(max == 0) return new int[] {-1};
        else return maxboard;
    }
    
    public static int cal(int[] lion, int[] apeach) {
        int L = 0, A = 0;
        
        for(int i = 0; i < 10; i++) {
            int point = 10 - i;
            if(lion[i] == apeach[i] && lion[i] == 0) continue; 
            if(lion[i] > apeach[i]) L += point;
            else A += point;
        }
        
        return L - A;
    }
    
    public static boolean compare(int[] scoreboard) {
        for(int i = 10; i >= 0; i--) {
            if(scoreboard[i] > maxboard[i]) return true;
            else if(scoreboard[i] < maxboard[i]) return false;
        }
        return true;
    }
    
    public static void dfs(int dep, int arrow, int[] scoreboard, int[] info) {
        if(dep == 10 || arrow == 0) {
            scoreboard[10] += arrow;
            int score = cal(scoreboard, info);
            if(score > 0) {
                if(max < score) {
                    max = score;
                    maxboard = scoreboard.clone();
                } else if(max == score) {
                    if(compare(scoreboard)) {
                        maxboard = scoreboard.clone(); 
                    }
                }
            }
            scoreboard[10] -= arrow; 
            return;
        }
        
        // 안맞추는 경우
        dfs(dep + 1, arrow, scoreboard, info);
        
        // 맞추는 경우
        if(arrow - (info[dep] + 1) >= 0) {
            scoreboard[dep] = info[dep] + 1;
            dfs(dep + 1, arrow - (info[dep] + 1), scoreboard, info);
            scoreboard[dep] = 0;
        }
    }
}
