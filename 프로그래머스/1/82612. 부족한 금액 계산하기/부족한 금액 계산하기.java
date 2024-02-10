class Solution {
    public long solution(int price, int money, int count) {
        long answer = 0;
        long m=0;
        
        for(int i=1; i<=count; i++){
            m += price*i;
        }
        
        answer = m-money;
        
        if(m<=money) return 0;
        return answer;
    }
}