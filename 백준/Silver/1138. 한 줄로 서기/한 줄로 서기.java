import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine()); 
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] tallerCnt = new int[n]; 
        for (int i = 0; i < n; i++) {
            tallerCnt[i] = Integer.parseInt(st.nextToken()); 
        }

        List<Integer> line = new ArrayList<>(); 

        for (int i = n; i >= 1; i--) {
            line.add(tallerCnt[i - 1], i);
        }

        for (int person : line) {
            System.out.print(person + " ");
        }
    }
}