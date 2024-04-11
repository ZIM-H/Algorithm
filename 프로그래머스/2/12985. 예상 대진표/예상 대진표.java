class Solution
{
    public int solution(int n, int a, int b)
    {
        int answer = 0;

        int seqA = a;
        int seqB = b;
        
        while(true){
            seqA = calSeq(seqA);
            seqB = calSeq(seqB);
            if(seqA == seqB) {
                answer++;
                break;
            }
            answer++;
        }

        return answer;
    }
    
    public int calSeq(int x){
        if(x % 2 == 0) return x/2;
        else return x/2 + 1;
    }
}