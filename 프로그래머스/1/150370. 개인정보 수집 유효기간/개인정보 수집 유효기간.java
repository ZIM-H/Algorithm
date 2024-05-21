import java.util.*;
class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        List<Integer> answer = new ArrayList<>();
        Map<String, Integer> term = new HashMap<>();
        for(String t : terms){
            term.put(t.substring(0,1), Integer.parseInt(t.substring(2)));
        }
        int now = calDate(today);
        for(int i=0; i<privacies.length; i++){
            String[] tmp = privacies[i].split(" ");
            if(calDate(tmp[0]) + (term.get(tmp[1]) * 28) <= now) answer.add(i+1);
        }
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
    
    public int calDate(String date){
        String[] tmp = date.split("\\.");
        int y = Integer.parseInt(tmp[0]);
        int m = Integer.parseInt(tmp[1]);
        int d = Integer.parseInt(tmp[2]);
        return (y * 12 * 28) + (m * 28) + d;
    }
}