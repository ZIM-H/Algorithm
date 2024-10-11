import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st;
        List<Integer> list = new LinkedList<>();
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++){
                 list.add(Integer.parseInt(st.nextToken()));   
            }
        }

        Collections.sort(list, Collections.reverseOrder());

        System.out.println(list.get(n-1));
    }
}