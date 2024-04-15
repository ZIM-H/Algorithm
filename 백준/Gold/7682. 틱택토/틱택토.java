import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true){
            String state = br.readLine();
            if(state.equals("end")) break;

            int xCnt = state.length() - state.replace("X", "").length();
            int oCnt = state.length() - state.replace("O", "").length();

            if (oCnt > xCnt || xCnt - oCnt > 1) {
                System.out.println("invalid");
                continue;
            }

            char[] board = state.toCharArray();
            int[][] rule = {{0,1,2}, {3,4,5}, {6,7,8}, {0,3,6}, {1,4,7}, {2,5,8}, {0,4,8}, {2,4,6}};

            boolean xWin = false, oWin = false;
            for(int i=0; i<8; i++){
                if(board[rule[i][0]] == board[rule[i][1]] && board[rule[i][1]] == board[rule[i][2]]){
                    if(board[rule[i][0]] == 'X') xWin = true;
                    else if(board[rule[i][0]] == 'O') oWin = true;
                }
            }

            if(xWin && oWin) {
                System.out.println("invalid");
                continue;
            }

            if(oWin && xCnt > oCnt) {
                System.out.println("invalid");
                continue;
            }

            if(xWin && xCnt <= oCnt) {
                System.out.println("invalid");
                continue;
            }

            if(!xWin && !oWin && (xCnt + oCnt) == 9) {
                System.out.println("valid");
                continue;
            }

            if(!xWin && !oWin) {
                System.out.println("invalid");
                continue;
            }

            System.out.println("valid");
        }
    }
}