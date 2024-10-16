import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int zeroCnt = 0, oneCnt = 0;
        char[] c = s.toCharArray();

        for(int i=0; i<c.length; i++){
            if(c[i] == '0') zeroCnt++;
            else oneCnt++;
        }

        // 0 지우기
        zeroCnt /= 2;
        oneCnt /= 2;
        for(int i=c.length-1; i>=0; i--){
            if(c[i] == '0') {
                c[i] = '.';
                zeroCnt--;
                if(zeroCnt == 0) break;
            }
        }
        for(int i=0; i<c.length; i++){
            if(c[i] == '1') {
                c[i] = '.';
                oneCnt--;
                if(oneCnt == 0) break;
            }
        }

        StringBuilder sb = new StringBuilder();
        for(char ch : c){
            if(ch == '.') continue;
            sb.append(ch);
        }

        System.out.println(sb.toString());
    }
}