import java.util.*;
class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] visited = new boolean[n];
        
        for(int i=0; i<n; i++){
            if(!visited[i]){
                bfs(i, computers, visited);
                answer++;
            }
        }
        
        return answer;
    }
    
    public void bfs(int num, int[][] computers, boolean[] visited){
        Queue<Integer> q = new ArrayDeque<>();
        q.add(num);
        
        while(!q.isEmpty()){
            int now = q.poll();
            visited[now] = true;
            
            for(int i=0; i<computers[now].length; i++){
                if(computers[now][i] == 1 && !visited[i]){
                    q.add(i);
                }
            }
        }
    }
}