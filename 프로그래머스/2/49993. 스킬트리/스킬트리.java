import java.util.*;
class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        for(int i=0; i<skill_trees.length; i++){
            StringBuilder sb = new StringBuilder();
            for(char c : skill_trees[i].toCharArray()){
                if(skill.contains(String.valueOf(c))) sb.append(c);
            }
            
            for(int t=skill.length(); t>=0; t--){
                String temp = skill.substring(0,t);
                if(temp.equals(sb.toString())){
                    answer++;
                    break;
                }
            }
        }
        return answer;
    }
}