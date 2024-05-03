import java.util.*;
class Solution {
    static boolean[][] checked;
    static int[] dr = {0,0,1,-1};
    static int[] dc = {1,-1,0,0};
    public class Pos{
        int r, c;
        public Pos(int r, int c){
            this.r = r;
            this.c = c;
        }
    }
    public int solution(int[][] land) {
        
        checked = new boolean[land.length][land[0].length];
        Map<Integer, Integer> value = new HashMap<>();
        int oilNum = 2501;
        for(int i=0; i<land.length; i++){
            for(int j=0; j<land[0].length; j++){
                if(land[i][j] == 1 && !checked[i][j]){
                    value.put(oilNum, bfs(land,i, j, oilNum++));
                }
            }
        }
        
        Set<Integer> set;
        int answer = 0, oilCnt = 0;
        for(int i=0; i<land[0].length; i++){
            set = new HashSet<>();
            oilCnt = 0;
            for(int j=0; j<land.length; j++){
                if(land[j][i] != 0) {
                    set.add(land[j][i]);
                }
            }
            
            for(int s : set){
                oilCnt += value.get(s);
            }
            answer = Math.max(answer, oilCnt);
        }
        return answer;
    }
    
    public int bfs(int[][] land, int i, int j, int oilNum){
        int cnt = 0;
        Queue<Pos> q = new ArrayDeque<>();
        q.add(new Pos(i, j));
        checked[i][j] = true;
        
        while(!q.isEmpty()){
            Pos now = q.poll();
            land[now.r][now.c] = oilNum;
            cnt++;
            for(int d = 0; d<4; d++){
                int nr = now.r + dr[d];
                int nc = now.c + dc[d];
                if(nr < land.length && nc < land[0].length && nr >= 0 && nc >= 0 && !checked[nr][nc] && land[nr][nc] == 1){
                    q.add(new Pos(nr, nc));
                    checked[nr][nc] = true;
                }
            }
        }
        
        return cnt;
    }
}