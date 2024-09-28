import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        boolean[] check = new boolean[n];
        for(int i=0; i<n; i++){
            String alp = br.readLine();
            if(isPalindrome(alp)) check[i] = true;
        }

        int answer = 0;
        for(int i=0; i<n-1; i++){
            for(int j=i+1; j<n; j++){
                if(check[i] && check[j]) answer+=2;
            }
        }
        System.out.println(answer);
    }

    public static boolean isPalindrome(String alp){
        int len = alp.length();
        for(int i=0; i<len/2; i++){
            if(alp.charAt(i) != alp.charAt(len-i-1)) return false;
        }

        return true;
    }
}