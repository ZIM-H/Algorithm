import java.util.*;
class Solution {
    static int[] answer;
    public int[] solution(int[][] arr) {
        answer = new int[2];
        int max = arr.length;
        
        compress(arr, max, 0, 0);
        
        
        return answer;
    }
    
    public void compress(int[][] map, int max, int start, int end){
        if(max == 1){
            
            for(int i=start; i<start+max; i++){
                for(int j=end; j<end+max; j++){
                    answer[map[i][j]]++;
                }
            }
            return;
        }
        
        int value = map[start][end];
        int flag = 0;
        for(int i=start; i<start + max; i++){
            for(int j=end; j<end + max; j++){
                if(map[i][j] != value){
                    compress(map, max/2, start, end);
                    compress(map, max/2, start + max/2, end);
                    compress(map, max/2, start, end  + max/2);
                    compress(map, max/2, start + max/2, end  + max/2);
                    flag = 1;
                    break;
                }
            }
            if(flag == 1) break;
        }
        
        if(flag == 0) answer[value]+=1;
    }
}