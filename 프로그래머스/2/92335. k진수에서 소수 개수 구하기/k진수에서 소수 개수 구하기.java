class Solution {
    public int solution(int n, int k) {
        int answer = 0; 
        for(String s : Integer.toString(n, k).split("0")){
            if(s.equals("")) continue;
            if(isPrime(Long.parseLong(s))) answer++;
        }
        return answer;
        
    }
    
    public boolean isPrime(Long n){
        if(n <= 1) return false;
        for(int i=2; i<=Math.sqrt(n); i++){
            if(n%i==0) return false;
        }
        return true;
    }
}