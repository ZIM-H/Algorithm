import java.util.*;
class Solution {
    static String[][] oper = {{"*","+","-"},{"*","-","+"},{"+","*","-"},{"+","-","*"},{"-","*","+"},{"-","+","*"}};
    public long solution(String expression) {
        Deque<String> q = new ArrayDeque<>();
        int start = 0;
        for(int i=0; i<expression.length(); i++){
            char c = expression.charAt(i);
            if(c == '*' || c == '+' || c == '-') {
                q.add(expression.substring(start, i));
                q.add(String.valueOf(c));
                start = i+1;
            }
        }
        q.add(String.valueOf(expression.substring(start, expression.length())));
        
        long answer = 0;
        for(int i=0; i<6; i++){
            answer = Math.max(answer, Math.abs(reward(new ArrayDeque(q), i)));
        }
        
        return answer;
    }
    
    public long reward(Deque<String> copyQ, int idx){
        
        for(int i=0; i<3; i++){
            Deque<String> tmpQ = new ArrayDeque<>();
            while(!copyQ.isEmpty()){
                String now = copyQ.poll();
                if(now.equals(oper[idx][i])){
                    tmpQ.add(cal(tmpQ.pollLast(), now, copyQ.poll()));
                }
                else tmpQ.add(now);
            }
            
            copyQ = tmpQ;
        }
        
        return Long.parseLong(copyQ.poll());
    }
    
    public String cal(String prev, String oper, String next){
        long num1 = Long.parseLong(prev);
        long num2 = Long.parseLong(next);
        
        if(oper.equals("*")) return String.valueOf(num1*num2);
        else if (oper.equals("+")) return String.valueOf(num1+num2);
        else return String.valueOf(num1-num2);
    }
}