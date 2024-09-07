import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String name = br.readLine();

        Map<Character, Integer> map = new TreeMap<>();
        for(char c : name.toCharArray()){
            map.put(c, map.getOrDefault(c, 0)+1);
        }

        StringBuilder left = new StringBuilder();
        StringBuilder middle = new StringBuilder();
        
        for (Map.Entry<Character, Integer> e : map.entrySet()) {
            char c = e.getKey();
            int count = e.getValue();

            if (count % 2 == 1) {
                middle.append(c);
            }
            for (int i = 0; i < count / 2; i++) {
                left.append(c);
            }
        }

        if (middle.length() > 1) {
            System.out.println("I'm Sorry Hansoo");
        } else {
            String right = left.reverse().toString(); 
            System.out.println(left.reverse().toString() + middle.toString() + right);
        }
        
    }
}