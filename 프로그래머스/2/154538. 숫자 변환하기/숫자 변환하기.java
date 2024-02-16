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
        int idx = 0;
        boolean[] check = new boolean[1000009];
        check[x] = true;
        
        while(!q.isEmpty()){
            Num now = q.poll();
            
            if(now.n == y) {
                answer = now.cnt;    
                break;
            }
            
            if(now.n + n <= y && !check[now.n+n]) {
                q.add(new Num(now.n + n, now.cnt+1));
                check[now.n+n] = true;
            }
            if(now.n * 2 <= y && !check[now.n * 2]) {
                q.add(new Num(now.n * 2, now.cnt+1));
                check[now.n * 2] = true;
            }
            if(now.n * 3 <= y && !check[now.n * 3]) {
                q.add(new Num(now.n * 3, now.cnt+1));
                check[now.n * 3] = true;
            }
        
        }
        
        return answer;
    }
}