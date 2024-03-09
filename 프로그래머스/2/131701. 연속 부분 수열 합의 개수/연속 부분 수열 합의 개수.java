import java.util.*;
class Solution {
    public int solution(int[] elements) {
        HashSet<Integer> s = new HashSet<>();
        for(int i=0; i<elements.length; i++){
            int num = 0;
            for(int j=0; j<elements.length; j++){
                num += elements[(i + j)%elements.length];
                s.add(num);
            }
        }
        return s.size();
    }
}