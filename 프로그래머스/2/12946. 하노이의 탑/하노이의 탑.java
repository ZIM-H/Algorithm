import java.util.*;
class Solution {
    static List<int[]> list;
    public int[][] solution(int n) {
        list = new ArrayList<>();
        hanoi(n, 1, 2, 3);
        int[][] answer = new int[list.size()][2];
        
        int idx = 0;
        for(int[] i : list){
            answer[idx][0] = i[0];
            answer[idx++][1] = i[1];
        }
        
        return answer;
    }
    
    public void hanoi(int cnt, int start, int mid, int end){
        if(cnt == 0) return;
        
        hanoi(cnt-1, start, end, mid);
        list.add(new int[]{start, end});
        hanoi(cnt-1, mid, start, end);
    }
}