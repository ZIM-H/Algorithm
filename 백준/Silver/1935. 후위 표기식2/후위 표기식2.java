import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String notation = br.readLine();
        Stack<Double> answer = new Stack<>();
        double[] value = new double[n];

        for(int i=0; i<n; i++){
            value[i] = Double.parseDouble(br.readLine());
        }

        for(char c : notation.toCharArray()){
            if(c >= 'A' && c <= 'Z') answer.add((Double) value[c-'A']);
            else answer.push(cal(answer.pop(), c, answer.pop()));
        }

        System.out.printf("%.2f", answer.pop());
    }

    public static double cal(double a, char oper, double b){
        if(oper == '*') return b * a;
        else if (oper == '/') return b / a;
        else if (oper == '-') return b - a;
        else return b + a;
    }
}