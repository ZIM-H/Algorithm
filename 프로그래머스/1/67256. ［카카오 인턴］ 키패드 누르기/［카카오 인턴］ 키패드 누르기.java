class Solution {
    public String solution(int[] numbers, String hand) {
        String answer = new String();
        int left=10,right=12;
        for(int number: numbers){
            if(number==0) number=11;
            if(number%3 ==1){
                answer += "L";
                left = number;
            }
            else if(number%3==0){
                answer += "R";
                right = number;
            }
            else {
                int leftLength = getLength(left, number);
                int rightLength = getLength(right, number);
                if(leftLength>rightLength){
                    answer += "R";
                    right = number;
                } 
                else if(leftLength<rightLength){
                    answer += "L";
                    left = number;
                }
                else {
                    if(hand.equals("left")){
                        answer += "L";
                        left = number;
                    }
                    else {
                        answer += "R";
                        right = number;
                    }
                }
            }
        }
        return answer;
    }
    
    public int getLength(int start, int end){ 
        int x = (start-1)/3;
        int y = (start-1)%3;
        int endX = end/3;
        int endY = 1;
        return Math.abs(x-endX) + Math.abs(y-endY);
    }
}