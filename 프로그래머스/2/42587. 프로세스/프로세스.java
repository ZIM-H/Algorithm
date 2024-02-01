import java.util.*;
class Solution {
    static class Word{
        int idx;
        int value;
        public Word(int idx, int value){
            this.idx = idx;
            this.value = value;
        }
    }
    public int solution(int[] priorities, int location) {
        int answer = 0;
        
        PriorityQueue<Integer> num = new PriorityQueue<>(Collections.reverseOrder());
        Queue<Word> q = new ArrayDeque<>();
        
        for(int i=0; i<priorities.length; i++){
            num.add(priorities[i]);
            q.add(new Word(i, priorities[i]));
        }
        
        while(true){
            Word now = q.poll();
            
            if(num.peek() == now.value){
                if(now.idx == location) {
                    answer++;
                    break;
                }
                answer++;
                num.poll();
                continue;
            }
            q.add(now);
        }
        
        return answer;
    }
}