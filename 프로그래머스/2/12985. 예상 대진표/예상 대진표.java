class Solution
{
    public int solution(int n, int a, int b)
    {
        int answer = 0;
        
        while(a != b){
            a = calSeq(a);
            b = calSeq(b);
            
            answer++;
        }

        return answer;
    }
    
    public int calSeq(int x){
        if(x % 2 == 0) return x/2;
        else return x/2 + 1;
    }
}
