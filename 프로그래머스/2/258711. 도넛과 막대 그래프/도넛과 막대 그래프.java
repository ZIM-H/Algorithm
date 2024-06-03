import java.util.*;
class Solution {
    public int[] solution(int[][] edges) {
        int[] answer = new int[4];
        Map<Integer, int[]> count = new HashMap<>();
        
        int[] tmp;
        for(int i=0; i<edges.length; i++){
            if(!count.containsKey(edges[i][0])) count.put(edges[i][0], new int[2]);
            tmp = count.get(edges[i][0]);
            tmp[1]++;
            count.put(edges[i][0],tmp);
            
            if(!count.containsKey(edges[i][1])) count.put(edges[i][1], new int[2]);
            tmp = count.get(edges[i][1]);
            tmp[0]++;
            count.put(edges[i][1], tmp);
        }
        
        for(int key : count.keySet()){
            int[] value = count.get(key);
            // System.out.println(Arrays.toString(value));
            if(value[0] == 0 && value[1] >= 2) answer[0] = key;
            else if(value[0] >= 1 && value[1] == 0) answer[2]++;
            else if(value[0] >= 2 && value[1] >= 2) answer[3]++;
        }
        
        answer[1] = count.get(answer[0])[1] - (answer[2] + answer[3]);
            
        return answer;
    }
}