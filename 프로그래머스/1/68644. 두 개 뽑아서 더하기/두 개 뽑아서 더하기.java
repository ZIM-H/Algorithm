import java.util.*;
class Solution {
    public int[] solution(int[] numbers) {
        HashSet<Integer> hs = new HashSet<>();
        
        boolean[] check = new boolean[200];
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0; i<numbers.length; i++){
            for(int j=i+1; j<numbers.length; j++){
                int num = numbers[i] + numbers[j];
                if(!check[num]) {
                    list.add(num);
                    check[num] = true;
                }
            }
        }
        
        int[] answer = new int[list.size()];
        int idx = 0;
        for(int i : list){
            answer[idx] = i;
            idx++;
        }
        
        Arrays.sort(answer);
        return answer;
    }
}