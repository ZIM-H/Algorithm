class Solution {
    public int solution(String[] board) {
        int ocnt = 0, xcnt = 0;
        boolean oflag = false, xflag = false;
        char[][] map = new char[3][3];
        
        for(int i=0; i<3; i++){
            map[i] = board[i].toCharArray();
            for(int j=0; j<3; j++){
                if(map[i][j] == 'O') ocnt++;
                else if(map[i][j] == 'X') xcnt++;
            }
        }
        if(xcnt > ocnt || ocnt - xcnt > 1) return 0; 
        
        for(int i=0; i<3; i++){
            if(map[i][0] == map[i][1] && map[i][1] == map[i][2]) {
                if(map[i][0] == 'O') oflag = true;
                else if(map[i][0] == 'X') xflag = true;
            }
            
            if(map[0][i] == map[1][i] && map[1][i] == map[2][i]) {
                if(map[0][i] == 'O') oflag = true;
                else if(map[0][i] == 'X') xflag = true;
            }
        }
        
        if(map[0][0] == map[1][1] && map[1][1] == map[2][2]) {
                if(map[0][0] == 'O') oflag = true;
                else if(map[0][0] == 'X') xflag = true;
        }
        
        if (map[0][2] == map[1][1] && map[1][1] == map[2][0]){
            if(map[0][2] == 'O') oflag = true;
            else if(map[0][2] == 'X') xflag = true;
        }
        
        if(xcnt == ocnt) {
            if((!oflag && !xflag) || (!oflag && xflag)) return 1;
        }
        if(ocnt == xcnt + 1) {
            if((!oflag && !xflag) || (oflag && !xflag)) return 1;
        }
        
        return 0;
    }
}