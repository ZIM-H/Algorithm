import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int zeroCnt = 0, oneCnt = 0;
        for(char c : s.toCharArray()){
            if(c == '0') zeroCnt++;
            else oneCnt++;
        }

        StringBuilder sb = new StringBuilder();
        if(zeroCnt != 0){
            for(int i=0; i<zeroCnt/2; i++){
                sb.append(0);
            }
        }

        if(oneCnt != 0){
            for(int i=0; i<oneCnt/2; i++){
                sb.append(1);
            }
        }

        System.out.println(sb.toString());
    }
}