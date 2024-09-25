import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n  = Integer.parseInt(br.readLine());

        for(int i=0; i<n; i++) {
            String ps = br.readLine();
            int num = 0;
            for(char c : ps.toCharArray()){
                if(c == '(') num++;
                else {
                    if(num == 0) {
                        num++;
                        break;
                    }
                    else num--;
                }
            }

            String answer = num == 0 ? "YES" : "NO";
            System.out.println(answer);

        }
    }
}