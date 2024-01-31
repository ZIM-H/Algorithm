class Solution {
    public int solution(int n) {
        int answer = 0;
        int[] value = new int[n+1];
        value[1] = 1;
        value[2] = 2;
        
        if(n > 2) {
            for(int i=3; i<=n; i++){
                value[i] = value[i-1] + value[i-2];
                value[i] %= 1000000007;
            }
        }
        
        return value[n];
    }
}