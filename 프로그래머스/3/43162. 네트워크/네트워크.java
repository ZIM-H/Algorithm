import java.util.*;
class Solution {
    static int[] parent;
    public int find(int x){
        if(parent[x] == x) return x;
        
        return find(parent[x]);
    }
    
    public void union(int a, int b){
        a = find(a);
        b = find(b);
        
        if(a < b) parent[b] = a;
        else parent[a] = b;
    }
    public int solution(int n, int[][] computers) {
        int answer = 0;
        
        parent = new int[n];
        for(int i=1; i<n; i++){
            parent[i] = i;
        }
        
        for(int i=0; i<computers.length; i++){
            for(int j=0; j<computers[0].length; j++){
                if(i != j && computers[i][j] == 1){
                    if(find(i) != find(j)){
                        union(i,j);
                    }
                }
            }
        }
        for(int i=0; i<n; i++){
            parent[i] = find(i);
        }
        
        Set<Integer> set = new HashSet<>();
        for(int i : parent){
            set.add(i);
        }
        
        return set.size();
    }
}