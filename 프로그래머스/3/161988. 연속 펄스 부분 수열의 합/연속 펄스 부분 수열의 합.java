class Solution {
    public long solution(int[] sequence) {
        long[] seqA = new long[sequence.length];
        long[] seqB = new long[sequence.length];
        
        seqA[0] = sequence[0];
        seqB[0] = sequence[0]*-1;
        
        long ansA = seqA[0], ansB = seqB[0];
    
        for(int i=1; i<sequence.length; i++){
            int now = sequence[i];
            if(i%2==0){
                seqA[i] = Math.max(seqA[i-1] + now, now);
                seqB[i] = Math.max(seqB[i-1] + now*-1, now*-1);
            }
            else{
                seqA[i] = Math.max(seqA[i-1] + now*-1, now*-1);
                seqB[i] = Math.max(seqB[i-1] + now, now);
            }
            
            ansA = Math.max(ansA, seqA[i]);
            ansB = Math.max(ansB, seqB[i]);
        }
        return Math.max(ansA, ansB);
    }
}