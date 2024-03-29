class Solution {
    static int[] dvr1 = {-1,1,0,0};
    static int[] dvc1 = {0,0,-1,1};
    static int[] dvr2 = {-2,2,0,0};
    static int[] dvc2 = {0,0,-2,2};
    static int[] dhr = {-1,-1,1,1};
    static int[] dhc = {-1,1,1,-1};
    public int[] solution(String[][] places) {
        int[] answer = new int[places.length];
        
        for(int i=0; i<places.length; i++){
            if(check(places[i])) answer[i] = 1;
        }
        return answer;
    }
    
    public boolean check(String[] places){
        
        for(int i=0; i<5; i++){
            for(int j=0; j<5; j++){
                if(places[i].charAt(j) == 'P'){
                    if(!checkDis(i, j, places)) return false;
                }
            }
        }
        
        return true;
    }
    
    public boolean checkDis(int i, int j, String[] places){
        // 상하좌우 +1
        for(int d=0; d<4; d++){
            int nr = i + dvr1[d];
            int nc = j + dvc1[d];
            if(range(nr, nc)){
                if(places[nr].charAt(nc) == 'P') return false;
            }
        }
        
        // 상하좌우 +2
        for(int d=0; d<4; d++){
            int nr = i + dvr2[d];
            int nc = j + dvc2[d];
            if(range(nr, nc) && places[nr].charAt(nc) == 'P'){
                nr = i + dvr2[d]/2;
                nc = j + dvc2[d]/2;
                if(places[nr].charAt(nc) != 'X') return false;
            }
        }
        
        // 대각선
        for(int d=0; d<4; d++){
            int nr = i + dhr[d];
            int nc = j + dhc[d];
            if(range(nr, nc) && places[nr].charAt(nc) == 'P'){
                if(places[i].charAt(nc) != 'X' || places[nr].charAt(j) != 'X') return false;
            }
        }
        
        return true;
    }
    
    public boolean range(int a, int b){
        if(a >= 0 && b >=0 && a < 5 && b < 5) return true;
        return false;
    }
}