class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        String[] accent = {"aya", "ye", "woo", "ma"};
        String[] diff = {"ayaaya", "yeye", "woowoo", "mama"};
        
        for(String b : babbling){
            for(int i=0; i<4; i++){
                b = b.replace(diff[i], "1").replace(accent[i], " ");
                if(b.replace(" ", "").length() == 0) {
                    answer++;
                    break;
                }
            }
        }
        return answer;
    }
}