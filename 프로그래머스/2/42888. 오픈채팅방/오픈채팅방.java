import java.util.*;
class Solution {
    public String[] solution(String[] record) {
        
        int idx = 0;
        
        HashMap<String, String> hm = new HashMap<>();
        for(String r : record){
            String[] msg = r.split(" ");
            if(!msg[0].equals("Leave")){
                hm.put(msg[1], msg[2]);
            }
            
            if(msg[0].equals("Leave") || msg[0].equals("Enter")) idx++;
        }
        
        String[] answer = new String[idx];
        idx = 0;
        
        for(String r : record){
            String[] msg = r.split(" ");
            String s = hm.get(msg[1]) + "님이 ";
            
            if(msg[0].equals("Enter")) s += "들어왔습니다.";
            else if(msg[0].equals("Leave")) s += "나갔습니다.";
            else continue;
            
            answer[idx] = s;
            idx++;
        }
        return answer;
    }
}