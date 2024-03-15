import java.util.*;
class Solution {
    static boolean[] visited;
    public int solution(int n, int[][] computers) {
        int answer = 0;
        visited = new boolean[n];
        
        for(int i=0; i<n; i++){
            if(!visited[i]){
                visited[i] = true;
                bfs(i, computers);
                answer++;
            }
        }
        
        return answer;
    }
    
    public void bfs(int num, int[][] computers){
        Queue<Integer> q = new ArrayDeque<>();
        q.add(num);
        int idx;
        
        while(!q.isEmpty()){
            idx = 0;
            for(int n : computers[q.poll()]){
                if(n == 1 && !visited[idx]){
                    q.add(idx);
                    visited[idx] = true;
                }
                idx++;
            }
        }
    }
}