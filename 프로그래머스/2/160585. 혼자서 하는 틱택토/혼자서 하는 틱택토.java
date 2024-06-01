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
        
        oflag = checkWin(map, 'O');
        xflag = checkWin(map, 'X');

        if (xcnt == ocnt) {
            if ((!oflag && !xflag) || (!oflag && xflag)) return 1;
        }
        if (ocnt == xcnt + 1) {
            if ((!oflag && !xflag) || (oflag && !xflag)) return 1;
        }

        return 0;
    }

    public boolean checkWin(char[][] map, char player) {
        for (int i = 0; i < 3; i++) {
            if (map[i][0] == player && map[i][1] == player && map[i][2] == player) return true;
            if (map[0][i] == player && map[1][i] == player && map[2][i] == player) return true;
        }
        if (map[0][0] == player && map[1][1] == player && map[2][2] == player) return true;
        if (map[0][2] == player && map[1][1] == player && map[2][0] == player) return true;

        return false;
    }
}