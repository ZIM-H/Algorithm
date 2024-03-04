import java.util.*;
class Solution {
    public int[] solution(int n, long k) {
        int[] answer = new int[n];
        List<Integer> nums = new ArrayList<>();
        long total = 1l;
        for(int i=1; i<=n; i++){
            nums.add(i);
            total *= i;
        }
        
        k--;
        int idx = 0;
        for(int i=0; i<n; i++){
            total /= n - i;
            answer[idx++] = nums.remove((int) (k / total));
            k %= total;
        }
        return answer;
    }
}