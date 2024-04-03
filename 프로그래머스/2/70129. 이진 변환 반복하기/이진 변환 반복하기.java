class Solution {
    public int[] solution(String s) {
        int zero = 0, cnt = 0, len = s.length();
        String num = "";
        
        while(!s.equals("1")){
            num = s.replace("0", "");
            zero += len - num.length();
            s = Integer.toBinaryString(num.length());
            len = s.length();
            cnt++;
        }
        
        int[] answer = {cnt, zero};
        return answer;
    }
}