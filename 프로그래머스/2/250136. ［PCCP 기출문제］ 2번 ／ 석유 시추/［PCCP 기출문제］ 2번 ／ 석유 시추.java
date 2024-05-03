import java.util.*;

class Solution {
    static boolean[][] checked;
    static int[] dr = {0,0,1,-1};
    static int[] dc = {1,-1,0,0};
    static int[] val;
    public class Pos{
        int r, c;
        public Pos(int r, int c){
            this.r = r;
            this.c = c;
        }
    }
    public int solution(int[][] land) {
        
        checked = new boolean[land.length][land[0].length];
        val = new int[land[0].length];
        
        for(int i=0; i<land.length; i++){
            for(int j=0; j<land[0].length; j++){
                if(land[i][j] == 1 && !checked[i][j]){
                    bfs(land,i, j);
                }
            }
        }
        
        int answer = 0;
        for(int a : val){
            answer = Math.max(answer, a);
        }
        return answer;
    }
    
    public void bfs(int[][] land, int i, int j){
        boolean[] input = new boolean[land[0].length];
        int cnt = 0;
        Queue<Pos> q = new ArrayDeque<>();
        Queue<Pos> oilList = new ArrayDeque<>();
        q.add(new Pos(i, j));
        checked[i][j] = true;
        
        while(!q.isEmpty()){
            Pos now = q.poll();
            oilList.add(now);
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
        
        while(!oilList.isEmpty()){
            Pos now = oilList.poll();
            if(!input[now.c]){
                input[now.c] = true;
                val[now.c] += cnt;
            }
        }
    }
}