import java.util.*;
class Solution {
    static int answer;
    public int solution(int[] arrayA, int[] arrayB) {
        
        check(arrayA, arrayB);
        check(arrayB, arrayA);
        
        return answer;
    }
    
    public void check(int[] a, int[] b){
        List<Integer> factor = new ArrayList<>();
        Arrays.sort(a);
        divisor(factor, a[0]);
        for(int i : factor){
            if(div(i, a, b)) answer = Math.max(answer, i);
        }
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