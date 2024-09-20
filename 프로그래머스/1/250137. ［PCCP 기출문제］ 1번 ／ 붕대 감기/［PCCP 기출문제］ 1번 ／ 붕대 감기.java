class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int time = 0;
        int ph = health;
        
        for(int i=0; i<attacks.length; i++){
            int total_time = attacks[i][0] - time - 1;
            
            ph += total_time * bandage[1];
            ph += total_time / bandage[0] * bandage[2];
            
            ph = Math.min(health, ph);
            
            time = attacks[i][0];
            ph -= attacks[i][1];
            
            if(ph <= 0) return -1;
        }
        
        return ph;
    }
}