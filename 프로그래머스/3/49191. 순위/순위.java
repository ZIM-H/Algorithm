import java.util.*;
class Solution {
    public int solution(int n, int[][] results) {
        int answer = 0;
        List<List<Integer>> win = new ArrayList<>();
        List<List<Integer>> lose = new ArrayList<>();
        
        for(int i=0; i<=n; i++){
            win.add(new ArrayList<>());
            lose.add(new ArrayList<>());
        }
        
        for(int[] r : results){
            win.get(r[0]).add(r[1]);
            lose.get(r[1]).add(r[0]);
        }
        
        for(int i=1; i<=n; i++){
            if(bfs(win, i, n) + bfs(lose, i, n) == n-1) answer++;
        }
        
        return answer;
    }
    
    public int bfs(List<List<Integer>> arr, int num, int total){
        int cnt = 0;
        boolean[] checked = new boolean[total+1];
        Queue<Integer> q = new ArrayDeque<>();
        q.add(num);
        checked[num] = true;
        
        while(!q.isEmpty()){
            for(int n : arr.get(q.poll())){
                if(checked[n]) continue;
                checked[n] = true;
                cnt++;
                q.add(n);
            }
            
        }
        
        return cnt;
    }
}