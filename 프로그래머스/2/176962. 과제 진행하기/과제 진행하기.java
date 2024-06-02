import java.util.*;
class Solution {
    class Plan implements Comparable<Plan>{
        String name;
        int time;
        int last;
        public Plan(String name, int time, int last){
            this.name = name;
            this.time = time;
            this.last = last;
        }
        public int getEndTime(){
            return this.time + this.last;
        }
        
        @Override
        public int compareTo(Plan o){
            return this.time - o.time;
        }
    }
    public String[] solution(String[][] plans) {
        int ansidx = 0;
        String[] answer = new String[plans.length];
        
        PriorityQueue<Plan> q = new PriorityQueue<>();
        Stack<Plan> stack = new Stack<>();
        
        for(String[] s : plans){
            String[] str = s[1].split(":");
            int time = Integer.parseInt(str[0])*60 + Integer.parseInt(str[1]);
            
            q.add(new Plan(s[0], time, Integer.parseInt(s[2])));
        }
        
        while(!q.isEmpty()){
            Plan now = q.poll();
            int nowtime = now.time;
            
            // 마지막 과제인지 확인
            if(q.size() != 0){
                Plan next = q.peek();
                // System.out.println("다음 과제 "+next.name+" 현재 과제 "+now.name);
                // 다음 과제와의 비교
                if(next.time >= now.getEndTime()){
                    answer[ansidx++] = now.name;
                    nowtime = now.getEndTime();
                    // 진행중이던 과제가 있을 경우
                    while(nowtime < next.time && !stack.isEmpty()){
                        Plan stop = stack.pop();
                        if(stop.last + nowtime <= next.time){
                            answer[ansidx++] = stop.name;
                            nowtime = stop.last + nowtime;
                        }
                        else{
                            int tmp = next.time - nowtime;
                            stack.push(new Plan(stop.name, stop.time, stop.last - tmp));
                            nowtime += tmp;
                        }
                    }
                }
                else{
                    int tmp = next.time - now.time;
                    stack.push(new Plan(now.name, now.time + tmp, now.last - tmp));
                    nowtime = now.time + tmp;
                }
            }
            else {
                // System.out.println("마지막 과제"+now.name);
                answer[ansidx++] = now.name;
            }
        }
        
        while(!stack.isEmpty()){
            answer[ansidx++] = stack.pop().name;
        }
        return answer;
    }
}