import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String notation = br.readLine();

        StringBuilder answer = new StringBuilder();
        Stack<Character> oper = new Stack<>();

        for(char c : notation.toCharArray()){
            if(c >= 'A' && c <= 'Z') answer.append(c);
            else if(c == '(') oper.add(c);
            else if(c == ')'){
                while(!oper.isEmpty()){
                    if(oper.peek() == '('){
                        oper.pop();
                        break;
                    }
                    else answer.append(oper.pop());
                }
            }
            else{
                while(!oper.isEmpty() && cal(oper.peek()) >= cal(c)){
                    answer.append(oper.pop());
                }
                oper.add(c);
            }
        }

        while (!oper.isEmpty()){
            answer.append(oper.pop());
        }

        System.out.println(answer.toString());
    }

    private static int cal(char operator) {
        if(operator == '(') return 0;
        else if(operator == '*' || operator == '/') return 2;
        else return 1;
    }
}