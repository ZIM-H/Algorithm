class Solution
{
    public int solution(String s)
    {
        int answer = 0;
        char[] str = s.toCharArray();
        
        for(int i=0; i<s.length(); i++){
            answer = Math.max(answer, calPel(str, i, i+1));
            answer = Math.max(answer, calPel(str, i, i));
        }

        return answer;
    }
    
    public int calPel(char[] str, int s, int e){
        while(s >= 0 && e < str.length && str[s] == str[e]){
            s--;
            e++;
        }
        return e - s - 1;
    }
}