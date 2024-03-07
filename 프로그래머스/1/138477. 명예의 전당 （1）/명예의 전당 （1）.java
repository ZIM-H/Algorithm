import java.util.*;
class Solution {
    public int[] solution(int k, int[] score) {
        int[] answer = new int[score.length];
        PriorityQueue<Integer> q = new PriorityQueue<>();
        
        int min = 2001;
        for(int i=0; i<score.length; i++){
            if(q.size() < k){
                q.add(score[i]);
                min = Math.min(min, score[i]);
                answer[i] = min;
            }
            
            else{
                if(score[i] > q.peek()){
                    q.poll();
                    q.add(score[i]);
                    min = q.peek();
                    answer[i] = min;
                }
                else answer[i] = min;
            }
        }
        return answer;
    }
}