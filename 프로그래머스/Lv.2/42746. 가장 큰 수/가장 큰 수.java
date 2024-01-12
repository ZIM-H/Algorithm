import java.util.*;
class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        String[] nums = new String[numbers.length];
        for(int i=0; i<numbers.length; i++){
            nums[i] = Integer.toString(numbers[i]);
        }
        
        Arrays.sort(nums, new Comparator<String>(){
            public int compare(String o1, String o2){
                return (o1+o2).compareTo(o2+o1);
            }
        });
        
        if(nums[nums.length-1].equals("0")) return "0";
        
        for(int i=nums.length-1; i>=0; i--){
            answer += nums[i];
        }
        
        return answer;
    }
}