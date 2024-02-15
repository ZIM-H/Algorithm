class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        
        answer[numbers.length-1] = -1;
        int max = numbers[numbers.length-1];
        for(int i=numbers.length-2; i>=0; i--){
            if(numbers[i] < numbers[i+1]) answer[i] = numbers[i+1];
            else if(numbers[i] == numbers[i+1]) answer[i] = answer[i+1];
            else {
                if(numbers[i] >= max){
                    answer[i] = -1;
                    max = numbers[i];
                }
                else answer[i] = max;
            }
        }
        return answer;
    }
}