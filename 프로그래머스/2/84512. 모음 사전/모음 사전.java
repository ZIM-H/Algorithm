class Solution {
    static char[] words = {'A', 'E', 'I', 'O', 'U'};
    static int answer;
    public int solution(String word) {
        answer = 0;
        dfs("", 0, word);
        
        return answer;
    }
    
    public boolean dfs(String current, int depth, String target) {
        if (current.equals(target)) {
            return true;
        }

        if (depth >= 5) {
            return false;
        }

        for (char w : words) {
            answer++;  
            if(dfs(current + w, depth + 1, target)) {
                return true;
            }
        }

        return false;
    }
}
