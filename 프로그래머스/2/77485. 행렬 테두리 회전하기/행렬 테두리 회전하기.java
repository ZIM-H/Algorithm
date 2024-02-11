class Solution {
    static int[][] map;
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        map = new int[rows][columns];
        
        int idx = 1;
        for(int i=0; i<rows; i++){
            for(int j=0; j<columns; j++){
                map[i][j] = idx;
                idx++;
            }
        }
        
        for(int i=0; i<queries.length; i++){
            answer[i] = change(queries[i]);
        }
        
        return answer;
    }
    
    static int change(int[] pos){
        int min = Integer.MAX_VALUE;
        int x1 = pos[0]-1, y1 = pos[1]-1, x2 = pos[2]-1, y2 = pos[3]-1;
        
        int tmp = map[x1][y2];
        min = Math.min(min, tmp);
        
        for(int i=y2; i>y1; i--){
            map[x1][i] = map[x1][i-1];
            min = Math.min(min, map[x1][i]);
        }
        for(int i=x1; i<x2; i++){
            map[i][y1] = map[i+1][y1];
            min = Math.min(min, map[i][y1]);
        }
        for(int i=y1; i<y2; i++){
            map[x2][i] = map[x2][i+1];
            min = Math.min(min, map[x2][i]);
        }
        for(int i=x2; i>x1; i--){
            map[i][y2] = map[i-1][y2];
            min = Math.min(min, map[i][y2]);
        }
        
        map[x1+1][y2] = tmp;
        return min;
    }
}