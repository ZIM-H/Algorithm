import java.util.*;
class Solution {
    static int answer, alpha;
    public class Pos{
        int r, c;
        public Pos(int r, int c){
            this.r = r;
            this.c = c;
        }
    }
    public int solution(int m, int n, String[] board) {
        answer = 0;
        alpha = m*n;
        char[][] map = new char[m][n];
        for(int i=0; i<m; i++){
            for(int j =0; j<n; j++){
                map[i][j] = board[i].charAt(j);
            }
        }
        
        List<Pos> list;
        while(true){
            list = new ArrayList<>();
            for(int i=0; i<m-1; i++){
                for(int j=0; j<n-1; j++){
                    if(map[i][j] != '0' && map[i][j] == map[i+1][j] && map[i+1][j] == map[i][j+1] && map[i][j+1] == map[i+1][j+1]) {
                        list.add(new Pos(i, j));
                        list.add(new Pos(i+1, j));
                        list.add(new Pos(i, j+1));
                        list.add(new Pos(i+1, j+1));
                    }
                }
            }
            if(list.size() == 0) break;
            removeBlock(map, list);
            answerCnt(map, m, n);
            move(map, m, n);
        }
        return answer;
    }
    public void removeBlock(char[][] map, List<Pos> list){
        for(Pos p : list){
            if(map[p.r][p.c] != '0') map[p.r][p.c] = '0';
        }
    }
    
    public void answerCnt(char[][] map, int m, int n){
        int cnt = 0;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(map[i][j] != '0') {
                    cnt++;
                }
            }
        }
        
        answer += alpha - cnt;
        alpha = cnt;
    }
    
    public void move(char[][] map, int m, int n){
        for(int i=m-2; i>=0; i--){
            for(int j=0; j<n; j++){
                if(map[i][j] == '0') continue;
                int cnt = 0, idx = 1;
                while((i+idx) <= m-1 && map[i+idx][j] == '0'){
                    cnt++;
                    idx++;
                }
                
                if(cnt > 0){
                    map[i+cnt][j] = map[i][j];
                    map[i][j] = '0';
                }
            }
        }
    }
}