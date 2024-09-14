class Solution {
    public int solution(int[] stones, int k) {
        int answer = 0;
        int right = 200000000, left = 0;
        
        while(left < right){
            int mid = (left+right)/2;
            
            if(cross(mid, stones, k)){
                left = mid + 1;
                answer = mid;
            }
            else{
                right = mid;
            }
        }
        
        return answer;
    }
    
    public boolean cross(int people, int[] stones, int k){
        int zerocnt = 0;
        for(int s : stones){
            if(s - people < 0) {
                zerocnt++;
                if(zerocnt == k) return false;
            }
            else zerocnt = 0;
        }
        
        return true;
    }
}