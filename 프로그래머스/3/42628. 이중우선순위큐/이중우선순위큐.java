import java.util.*;
class Solution {
    public int[] solution(String[] operations) {
        int[] answer = new int[2];
        PriorityQueue<Integer> min = new PriorityQueue<>();
        PriorityQueue<Integer> max = new PriorityQueue<>(Collections.reverseOrder());
        
        for(String s : operations){
            String[] oper = s.split(" ");
            
            int num = Integer.parseInt(oper[1]);
            if(oper[0].equals("I")){
                max.add(num);
            }
            else{
                if(num == -1){
                    while(!max.isEmpty()){
                        min.add(max.poll());
                    }
                    min.poll();
                }
                else{
                    while(!min.isEmpty()){
                        max.add(min.poll());
                    }
                    max.poll();
                }
            }
        }
        
        if(min.size() == 0 && max.size() == 0) {
            answer[0] = 0;
            answer[1] = 0;
        }
        else{
            while(!min.isEmpty()){
                max.add(min.poll());
            }
            answer[0] = max.poll();
            while(!max.isEmpty()){
                    min.add(max.poll());
            }
            answer[1] = min.poll();
        }
        return answer;
    }
}