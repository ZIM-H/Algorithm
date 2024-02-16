import java.util.*;
class Solution {
    public int[] solution(String s) {
        String[] num = s.split(",|\\{|\\}");
        int[][] cnt = new int[100009][2];
        
        int idx = 0;
        for(int i=0; i<num.length; i++){
            if(num[i].equals("")) continue;
            int n = Integer.parseInt(num[i]);
            if(cnt[n][1] == 0) {
                idx++;
                cnt[n][0] = n;
            }
            cnt[n][1]++;
        }
        
        Arrays.sort(cnt, new Comparator<int[]>(){
            public int compare(int[] s1, int[] s2){
                return s2[1]-s1[1];
            }
        });
        
        int[] answer = new int[idx];
        for(int i=0; i<idx; i++){
            answer[i] = cnt[i][0];
        }
        
        return answer;
    }
}