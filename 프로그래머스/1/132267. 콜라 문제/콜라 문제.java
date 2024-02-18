class Solution {
    static int answer;
    public int solution(int a, int b, int n) {
        answer = 0;
        
        change(n, a, b);
        
        return answer;
    }
    
    static void change(int coke, int bottle, int cnt){
        if(coke / bottle < 1) return;
        
        answer += (coke / bottle)*cnt;
        
        change(((coke / bottle)*cnt) + (coke%bottle), bottle, cnt);
    }
}