import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        Stack<Character> left = new Stack<>();
        Stack<Character> right = new Stack<>();

        for(char c : str.toCharArray()){
            left.push(c);
        }

        int len = Integer.parseInt(br.readLine());

        for(int i=0; i<len; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            char command = st.nextToken().charAt(0);

            if(command == 'L'){
                if(!left.isEmpty()) right.push(left.pop());
            }
            else if(command == 'D'){
                if(!right.isEmpty()) left.push(right.pop());
            }
            else if(command == 'B'){
                if(!left.isEmpty()) left.pop();
            }
            else {
                left.push(st.nextToken().charAt(0));
            }
        }
        StringBuilder sb = new StringBuilder();
        for (char c : left) {
            sb.append(c);
        }
        while (!right.isEmpty()) {
            sb.append(right.pop());
        }

        System.out.println(sb.toString());

    }
}