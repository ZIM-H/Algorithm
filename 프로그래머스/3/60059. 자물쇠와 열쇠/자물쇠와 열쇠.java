class Solution {
    static int N, M;
    public boolean solution(int[][] key, int[][] lock) {
        M = key.length;
        N = lock.length;
        for(int i=0; i<4; i++){
            if(check(key, lock)) return true;
            key = rotate(key);
        }
        return false;
    }
    
    public int[][] rotate(int[][] key){
        int[][] tmp = new int[M][M];    
        for(int i=0; i<M; i++){
            for(int j=0; j<M; j++){
                tmp[j][i] = key[M-1-i][j];
            }
        }
        
        return tmp;
    }
    
    public boolean check(int[][] tmp, int[][] lock){
        int expand = N + 2 * (M - 1);
        
        for(int i=0; i<=expand - M; i++){
            for(int j=0; j<=expand - M; j++){
                if(canLock(copy(lock, expand), tmp, i, j)) return true;
            }
        }
        
        return false;
    }

    public int[][] copy(int[][] lock, int expand){
        
        int[][] expLock = new int[expand][expand];
        
        // 정가운데 lock 채우기
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                expLock[M-1+i][M-1+j] = lock[i][j];
            }
        }
        
        return expLock;
    }

    public boolean canLock(int[][] expLock, int[][] key, int x, int y){
        for(int i=0; i<M; i++){
            for(int j=0; j<M; j++){
                expLock[x+i][y+j] += key[i][j];
            }
        }
        
        
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if (expLock[M - 1 + i][M - 1 + j] != 1) return false;
            }
        }
        
        return true;
    }
}