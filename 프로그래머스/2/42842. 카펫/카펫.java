class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int total=brown+yellow;
        for(int i=3; i<=total; i++){
            int s=i;
            int g=total/s;
            
            if(s>g)
                continue;
            if((s-2)*(g-2)==yellow){
                answer[0]=g;
                answer[1]=s;
                return answer;
            } 
        }
        
        return answer;
    }
}