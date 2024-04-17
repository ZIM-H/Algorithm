import java.util.*;
class Solution {
    static int[] dr = {1,0,0,-1}, dc = {0,-1,1,0};
    static String[] dir = {"d", "l", "r", "u"};
    static int mapR, mapC, endR, endC;
    static String answer;
    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        mapR = n;
        mapC = m;
        endR = r-1;
        endC = c-1;
        answer = "";
        dfs(x-1,y-1,k,calDis(x-1,y-1), "");
        if(answer.equals("")) return "impossible";
        else return answer;
    }
    
    public boolean dfs(int a, int b, int k, int dis, String route){
        if(k == 0 && dis== 0) {
            answer = route;
            return true;
        }
        for(int d = 0; d<4; d++){
            int nr = a + dr[d];
            int nc = b + dc[d];
            if(nr >= 0 && nc >=0 && nr < mapR && nc < mapC && dis <= k){
                if(((dis%2==0 && k%2==0)) || (dis%2==1 && k%2==1)){
                    if(dfs(nr, nc, k-1, calDis(nr, nc), route+dir[d])) return true;
                }
            }
        }
        return false;
    }
    
    public int calDis(int a1, int b1){
        return Math.abs(a1-endR) + Math.abs(b1-endC);
    }
}