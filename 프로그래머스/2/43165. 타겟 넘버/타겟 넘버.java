import java.util.*;
class Solution {
    public static class Num{
        int val;
        int dep;
        public Num(int val, int dep){
            this.val = val;
            this.dep = dep;
        }
    }
    public int solution(int[] numbers, int target) {
        int answer = 0;
        
        Queue<Num> ad = new ArrayDeque<>();
        ad.add(new Num(0,0));
        
        while(!ad.isEmpty()){
            Num now = ad.poll();
            
            if(now.dep == numbers.length){
                if(now.val == target) answer += 1;
                continue;
            }
            
            ad.add(new Num(now.val+numbers[now.dep], now.dep+1));
            ad.add(new Num(now.val-numbers[now.dep], now.dep+1));
        }
        return answer;
    }
}