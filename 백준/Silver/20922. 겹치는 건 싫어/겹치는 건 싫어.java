import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] num = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            num[i] = Integer.parseInt(st.nextToken());
        }


        Map<Integer, Integer> map = new HashMap<>();
        int left = 0, len = 0, max = -1;
        for(int i=0; i<n; i++){
            map.put(num[i], map.getOrDefault(num[i], 0)+1);
            len++;
            int value = map.get(num[i]);
            if(value <= k){
                max = Math.max(max, len);
            }
            else{
                while(true){
                    int out = map.get(num[left]);
                    if(out - 1 == 0) map.remove(num[left]);
                    else map.put(num[left], out-1);

                    left++;
                    len--;

                    if(map.get(num[i]) <= k) break;
                }
            }
        }
        System.out.println(max);

    }
}