class Solution {
    public int[] solution(long begin, long end) {
        int[] answer = new int[(int) (end - begin) + 1];
        for(int i=0; i<answer.length; i++){
            long num = begin + i;
            for (long div = 2; div <= Math.sqrt(num); div++) {
                if (num % div == 0) {
                    if (num / div > 10000000){
                        answer[i] = (int) div;
                        continue;
                    } else{
                        answer[i] = (int) (num / div);
                    }
                    break;
                }
            }
            if(answer[i] == 0) answer[i] = 1;
        }
        if(begin == 1) answer[0] = 0;
        
        return answer;
    }
}