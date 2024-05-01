class Solution {
    int MOD = 20170805;
    public int solution(int m, int n, int[][] cityMap) {
        int answer = 0;
        int[][][] value = new int[m+1][n+1][2];
        
        value[1][1][0] = 1;
        value[1][1][1] = 1;
        for(int i=1; i<=m; i++){
            for(int j=1; j<=n; j++){
                if(cityMap[i-1][j-1] == 1) continue;
                else if(cityMap[i-1][j-1] == 0){
                    value[i][j][0] += (value[i-1][j][0] + value[i][j-1][1]) % MOD;
                    value[i][j][1] += (value[i-1][j][0] + value[i][j-1][1]) % MOD;
                }
                else{
                    value[i][j][0] = value[i-1][j][0];
                    value[i][j][1] = value[i][j-1][1];
                }
            }
        }
        
        return value[m][n][0];
    }
}