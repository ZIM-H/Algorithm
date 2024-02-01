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
        
        Queue<Word> q = new ArrayDeque<>();
        for(int i=0; i<priorities.length; i++){
            q.add(new Word(i, priorities[i]));
        }
        
        Arrays.sort(priorities);
        int index = priorities.length-1;
        while(true){
            Word now = q.poll();
            
            if(priorities[index] == now.value){
                if(now.idx == location) {
                    answer++;
                    break;
                }
                answer++;
                index--;
                
                continue;
            }
            q.add(now);
        }
        
        return answer;
    }
}