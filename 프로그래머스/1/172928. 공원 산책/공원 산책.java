import java.util.*;
class Solution {
    static class Pos{
        int r;
        int c;
        public Pos(int r, int c){
            this.r = r;
            this.c = c;
        }
    }
    static int[] dr = {0,0,1,-1};
    static int[] dc = {-1,1,0,0};
    public int[] solution(String[] park, String[] routes) {
        int[] answer = new int[2];
        
        int h = park.length;
        int w = park[0].length();
        
        char[][] map = new char[h][w];
        Pos now = new Pos(0,0);
        for(int i=0; i<h; i++){
            for(int j=0; j<w; j++){
                map[i][j] = park[i].charAt(j);
                if(map[i][j] == 'S') now = new Pos(i, j);
            }
        }
        
        int d = 0, cnt = 0;
        for(int i=0; i<routes.length; i++){
            switch (routes[i].charAt(0)) {
                case 'W':
                    d = 0;
                    break;
                case 'E':
                    d = 1;
                    break;
                case 'S':
                    d = 2;
                    break;
                case 'N':
                    d = 3;
                    break;
            }
            cnt = routes[i].charAt(2) - '0';
            
            int nr = now.r + dr[d] * cnt;
            int nc = now.c + dc[d] * cnt;
            
            if(nr >= 0 && nc >= 0 && nr < h && nc < w ){
                int y = now.r;
                int x = now.c;
                int flag = 0;
                for(int k=0; k<cnt; k++){
                    y += dr[d];
                    x += dc[d];
                    if(map[y][x] == 'X') {
                        flag  = 1;
                        break;
                    }
                }
                if(flag == 0) now = new Pos(nr, nc);
            }
        }
        
        answer[0] = now.r;
        answer[1] = now.c;
        return answer;
    }
}