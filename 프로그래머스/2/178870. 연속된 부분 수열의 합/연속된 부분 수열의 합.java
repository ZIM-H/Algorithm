class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = new int[2];
        
        int start = 0, end = 0, length = 0, sum = sequence[0], min = 1000003;
        
        while(start <= end){
            if(sum > k){
                sum -= sequence[start++];
            }
            else{
                length = end - start + 1;
                if(sum == k && length < min){
                    min = length;
                    answer[0] = start;
                    answer[1] = end;
                }
                if(end > sequence.length-2) break;
                sum += sequence[++end];
            }
        }
        return answer;
    }
}