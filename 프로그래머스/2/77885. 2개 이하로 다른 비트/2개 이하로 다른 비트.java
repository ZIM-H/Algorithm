class Solution {
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];
        int idx = 0;
        for(long num : numbers){
            answer[idx++] = find(num);
        }
        return answer;
    }
    
    public long find(long num){
        if((num & 1) == 0) return num+1;
        
        long bit = 1;
        while((num & bit) != 0) bit <<= 1;
        
        return num + (bit >> 1);
    }
}