import java.util.*;
class Solution {
    static class Num implements Comparable<Num>{
        int n;
        int cnt;
        public Num(int n, int cnt){
            this.n = n;
            this.cnt = cnt;
        }
        @Override
        public int compareTo(Num o){
            return this.cnt - o.cnt;
        }
    }
    public int solution(int x, int y, int n) {
        int answer = -1;
        
        PriorityQueue<Num> q = new PriorityQueue<>();
        q.add(new Num(x, 0));
        boolean[] check = new boolean[1000009];
        
        while(!q.isEmpty()){
            Num now = q.poll();
            if(now.n > y || check[now.n]) continue;
            check[now.n] = true;
            
            if(now.n == y) {
                answer = now.cnt;    
                break;
            }
            
            q.add(new Num(now.n + n, now.cnt+1));
            q.add(new Num(now.n * 2, now.cnt+1));
            q.add(new Num(now.n * 3, now.cnt+1));
        
        }
        
        return answer;
    }
}