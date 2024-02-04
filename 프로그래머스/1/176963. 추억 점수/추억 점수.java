class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        int[] answer = new int[photo.length];
        
        for(int i=0; i<photo.length; i++){
            int value = 0;
            for(int j=0; j<photo[i].length; j++){
                for(int q=0; q<name.length; q++){
                    if(photo[i][j].equals(name[q])){
                        value += yearning[q];
                        break;
                    }
                }
            }
            answer[i] = value;
        }
        
        return answer;
    }
}