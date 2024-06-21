import java.util.*;
class Solution {
    static List<Integer> value;
    static boolean[] opened;
    public int solution(int[] cards) {
        
        value = new ArrayList<>();
        opened = new boolean[cards.length+1];
        for(int i=1; i<opened.length; i++){
            if(!opened[i]){
                opened[i] = true;
                open(cards[i-1], 1, cards);
            }
        }
        
        if(value.size() == 1) return 0;
        Collections.sort(value, Collections.reverseOrder());
        
        return value.get(0) * value.get(1);
    }
    
    static void open(int boxnum, int boxcount, int[] cards){
        if(opened[boxnum]){
            value.add(boxcount);
            return;
        }
        
        opened[boxnum] = true;
        open(cards[boxnum-1], boxcount+1, cards);
    }
}