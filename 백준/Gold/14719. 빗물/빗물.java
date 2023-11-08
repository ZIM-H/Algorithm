import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] map;
    static int cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int h = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());

        map = new int[h][w];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < w; i++) {
            int num = Integer.parseInt(st.nextToken());
            for (int j = h - 1; j >= h - num; j--) {
                map[j][i] = 1;
            }
        }

//        for(int i=0; i<h; i++){
//            for(int j=0; j<w; j++){
//                System.out.print(map[i][j] + " ");
//            }
//            System.out.println();
//        }
        cnt = 0;
        for (int i = 0; i < h; i++) {
            int oneCnt = 0;
            int c1 = -1;
            for (int j = 0; j < w; j++) {
                if (map[i][j] == 1) {
                    oneCnt += 1;
                    if (c1 == -1) {
                        c1 = j;
                    }
                    if (oneCnt == 2) {
                        rainCount(i, c1, j);
                        oneCnt = 1;
                        c1 = j;
                    }
                }
            }
        }

        System.out.println(cnt);
    }

    private static void rainCount(int r, int c1, int c2) {
//        System.out.println("현재 열 "+r);
//        System.out.println("현재 행 "+c1 +" 부터 "+c2);
        for (int i = c1; i < c2; i++) {
            if (map[r][i] == 0) cnt++;
        }

    }
}