class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        int now = 1, idx = 0;
        
        while(now <= n){
            if(idx < stations.length && now >= stations[idx] - w){
                now = stations[idx] + w + 1;
                idx++;
            }
            else{
                answer++;
                now += w * 2 + 1;
            }
        }
        

        return answer;
    }
}