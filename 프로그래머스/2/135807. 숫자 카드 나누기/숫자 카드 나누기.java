import java.util.*;
class Solution {
    static List<Integer> factorA, factorB;
    public int solution(int[] arrayA, int[] arrayB) {
        int answer = 0;
        factorA = new ArrayList<>();
        Arrays.sort(arrayA);
        divisor(factorA, arrayA[0]);
        for(int i : factorA){
            if(div(i, arrayA, arrayB)) answer = Math.max(answer, i);
        }
        
        factorB = new ArrayList<>();
        Arrays.sort(arrayB);
        divisor(factorB, arrayB[0]);
        for(int i : factorB){
            if(div(i, arrayB, arrayA)) answer = Math.max(answer, i);
        }
        
        return answer;
    }
    public boolean div(int num, int[] a, int[] b){
        for(int n : a){
            if(n % num != 0) return false;
        }
        
        for(int n : b){
            if(n % num == 0) return false;
        }
        
        return true;
    }
    
    public void divisor(List<Integer> f, int num){
        for(int i=1; i*i <= num; i++){
            if(num % i == 0){
                f.add(i);
                if(i != num / i) f.add(num / i);
            }
        }
    }
}