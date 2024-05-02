import java.util.*;
class Solution {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        Map<String, Integer> map = new HashMap<>();
        map.put("code", 0);
        map.put("date", 1);
        map.put("maximum", 2);
        map.put("remain", 3);
        
        int idx = map.get(ext);
        List<int[]> list = new ArrayList<>();
        
        for(int[] i : data){
            if(i[idx] < val_ext) list.add(i);
        }
        
        int[][] answer = new int[list.size()][4];
        idx = 0;
        for(int[] i : list){
            answer[idx++] = i;
        }
        
        int sortIdx = map.get(sort_by);
        Arrays.sort(answer, (o1, o2) -> o1[sortIdx] - o2[sortIdx]);
        
        return answer;
    }
}