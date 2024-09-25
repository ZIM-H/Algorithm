import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n  = Integer.parseInt(br.readLine());
        Stack<Integer> s;

        for(int i=0; i<n; i++) {
            String ps = br.readLine();
            s = new Stack<>();
            int flag = 0;
            for (char c : ps.toCharArray()) {
                if (c == ')') {
                    if (!s.isEmpty()) s.pop();
                    else {
                        flag = 1;
                        System.out.println("NO");
                        break;
                    }
                } else s.push(0);
            }
            if(flag == 1) continue;

            String answer = s.size() == 0 ? "YES" : "NO";
            System.out.println(answer);
        }
    }
}