import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int[] house = new int[n];
        for(int i=0; i<n; i++){
            house[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(house);

        int start = 1, end = house[n-1]-house[0], result = 0;
        while(start <= end){
            int mid = (start + end) / 2;

            int installed = house[0];
            int cnt = 1;

            for(int i=1; i<n; i++){
                if(house[i] - installed >= mid){
                    cnt++;
                    installed = house[i];
                }
            }

            // cnt가 c보다 많거나 같게 나오면 더 큰 경우가 있을수도 있으니 mid 값 키워서 탐색 계속 진행
            // 탐색을 지속하다가 정답이 나오지 않을 수도 있으니 값 저장해두기
            if(cnt >= c) {
                result = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        System.out.println(result);
    }
}