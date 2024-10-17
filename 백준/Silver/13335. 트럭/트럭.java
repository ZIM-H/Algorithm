import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());

        Queue<Integer> truck = new ArrayDeque<>();
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            truck.add(Integer.parseInt(st.nextToken()));
        }

        int time = 0, weight = 0;
        Queue<Integer> bridge = new ArrayDeque<>();
        for(int i=0; i<w; i++){
            bridge.add(0);
        }

        while (!bridge.isEmpty()){
            time++;
            weight -= bridge.poll();

            if(!truck.isEmpty()){
                if(truck.peek() + weight <= l){
                    int t = truck.poll();
                    bridge.add(t);
                    weight += t;
                }
                else bridge.add(0);
            }
        }
        System.out.println(time);
    }
}