import java.util.*;
class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        Deque<Integer> d = new ArrayDeque<>();
        
        for(int i=numbers.length-1; i>=0; i--){
            while(!d.isEmpty() && numbers[i] >= d.peekLast()) d.pollLast();
            
            if(d.isEmpty()) answer[i] = -1;
            else answer[i] = d.peekLast();
            
            d.add(numbers[i]);
        }
        
        return answer;
    }
}