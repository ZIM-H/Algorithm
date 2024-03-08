import java.util.*;
class Solution {
    static int find(int[] parent, int x){
        if(parent[x] == x) return x;
        
        return find(parent, parent[x]);
    }
    
    static void union(int[] parent, int x, int y){
        int a = find(parent, x);
        int b = find(parent, y);
        
        if(a > b) parent[a] = b;
        else parent[b] = a;
    }
    public int solution(int n, int[][] costs) {
        int answer = 0;
        int[] parent = new int[n];
        for(int i=0; i<n; i++){
            parent[i] = i;
        }
        
        Arrays.sort(costs, (o1, o2) -> o1[2] - o2[2]);
        
        for(int i=0; i<costs.length; i++){
            if(find(parent, costs[i][0]) != find(parent, costs[i][1])){
                answer += costs[i][2];
                union(parent, costs[i][0], costs[i][1]);
            }
        }
        return answer;
    }
}