class Solution {
    public int solution(int n) {
        return Integer.parseInt(String.valueOf(new StringBuilder(Integer.toString(n, 3)).reverse()), 3);
    }
}