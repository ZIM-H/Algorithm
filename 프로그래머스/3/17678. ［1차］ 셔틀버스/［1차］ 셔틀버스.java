import java.util.*;
class Solution {
    public String solution(int n, int t, int m, String[] timetable) {
        String answer = "";
        String[] busTime = new String[n];
        
        Arrays.sort(timetable);
        
        StringBuilder sb;
        String hour = "", min = "";
        for(int i=0; i<n; i++){
            sb = new StringBuilder();
            hour = Integer.toString((540 + t * i)/60);
            min = Integer.toString((540 + t * i)%60);
            
            if(hour.length() == 1) sb.append("0");
            sb.append(hour).append(":");
            if(min.length() == 1) sb.append("0");
            sb.append(min);
            
            busTime[i] = sb.toString();
        }
        
        // System.out.println(Arrays.toString(busTime));
        
        List<List<Integer>> member = new ArrayList<>();
        for(int i=0; i<busTime.length; i++){
            member.add(new ArrayList<>());
        }
        
        int idx = 0, cnt = 0;
        for(int i=0; i<timetable.length; i++){
            if(timetable[i].equals("23:59")) continue;
            if(check(busTime[idx], timetable[i])){
                if(member.get(idx).size() < m){
                    member.get(idx).add(i);
                }
                else {
                    if(idx + 1 < busTime.length) {
                        idx++;
                        member.get(idx).add(i);
                    }
                }
            }
            else {
                if(idx + 1 < busTime.length) {
                    idx++;
                    i -= 1;
                }
            }
        }
        
        for(List l : member){
            System.out.println(l);
        }
        
        if(member.get(n-1).size() == 0 || member.get(n-1).size() < m) answer = busTime[n-1];
        else{
            sb = new StringBuilder();
            Collections.sort(member.get(n-1), Collections.reverseOrder());
            
            String[] ans = timetable[member.get(n-1).get(0)].split(":");
            int time = Integer.parseInt(ans[0]) * 60 + Integer.parseInt(ans[1]) - 1;
            
            hour = Integer.toString(time/60);
            min = Integer.toString(time%60);
            
            if(hour.length() == 1) sb.append("0");
            sb.append(hour).append(":");
            if(min.length() == 1) sb.append("0");
            sb.append(min);
            
            answer = sb.toString();
        }
        
        return answer;
    }
    static boolean check(String s1, String s2){
        int val = s1.compareTo(s2);
        if(val >= 0) return true;
        
        return false;
    }
}