import java.util.*;

class Solution {
    public int[] solution(String[] gems) {
        int[] answer = new int[2];
        
        Set<String> gemTypes = new HashSet<>(Arrays.asList(gems));
        Map<String, Integer> gemCount = new HashMap<>();
        int start = 0, end = 0, minLength = Integer.MAX_VALUE;
        
        for (int i = 0; i < gems.length; i++) {
            gemCount.put(gems[i], gemCount.getOrDefault(gems[i], 0) + 1);
            end = i;

            if (gemCount.size() == gemTypes.size()) {
                while (gemCount.get(gems[start]) > 1) {
                    gemCount.put(gems[start], gemCount.get(gems[start]) - 1);
                    start++;
                }

                int length = end - start;
                if (length < minLength) {
                    minLength = length;
                    answer[0] = start + 1;
                    answer[1] = end + 1;
                }
            }
        }

        return answer;
    }
}