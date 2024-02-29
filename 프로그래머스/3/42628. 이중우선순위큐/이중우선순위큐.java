import java.util.*;
class Solution {
    public int[] solution(String[] operations) {
        int[] answer = new int[2];
        PriorityQueue<Integer> min = new PriorityQueue<>();
        PriorityQueue<Integer> max = new PriorityQueue<>(Collections.reverseOrder());
        
        for(String s : operations){
            String[] oper = s.split(" ");
            if(oper[0].equals("I")){
                min.add(Integer.parseInt(oper[1]));
                max.add(Integer.parseInt(oper[1]));
            }
            else{
                if(!min.isEmpty()){
                    if(oper[1].equals("-1")) max.remove(min.poll());
                    else min.remove(max.poll());
                }
            }
        }
        
        if(min.isEmpty()){
            answer[0] = 0;
            answer[1] = 0;
        }
        else {
            answer[0] = max.poll();
            answer[1] = min.poll();
        }
        
        return answer;
    }
}