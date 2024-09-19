import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static class CCTV {
        int r, c, type;
        public CCTV(int r, int c, int type){
            this.r = r;
            this.c = c;
            this.type = type;
        }
    }
    static int[][] office;
    static int n, m, answer, zero;
    static List<CCTV> list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        answer = Integer.MAX_VALUE;
        office = new int[n][m];
        list = new ArrayList<>();
        List<CCTV> list5 = new ArrayList<>();
        zero = 0;

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++){
                office[i][j] = Integer.parseInt(st.nextToken());

                if(office[i][j] != 0 && office[i][j] != 6) {
                    if(office[i][j] == 5) {
                        list5.add(new CCTV(i, j,5));
                        continue;
                    }
                    list.add(new CCTV(i,j, office[i][j]));
                }

                if(office[i][j] == 0) zero++;
            }
        }

        for(int i=0; i<list5.size(); i++){
            zero -= dir1(i, office, list5) + dir2(i, office, list5) + dir3(i, office, list5)+ dir4(i, office, list5);
        }

        int[][] info = new int[list.size()][2];
        for(int i=0; i<list.size(); i++){
            info[i][0] = list.get(i).type;
        }

        dfs(0, info);

        System.out.println(answer);
    }

    public static void dfs(int dep, int[][] info){
        if(dep == info.length){
            answer = Math.min(answer, cntArea(info));
            return;
        }

        if(info[dep][0] == 2){
            for(int i=1; i<=2; i++){
                info[dep][1] = i;
                dfs(dep+1, info);
            }
        }
        else {
            for(int i=1; i<=4; i++){
                info[dep][1] = i;
                dfs(dep+1, info);
            }
        }
    }

    private static int cntArea(int[][] info) {
        int[][] tmp = new int[n][m];
        tmp = copyOffice(tmp);
        int result = zero;
        int dir = 0;

        for(int i=0; i<info.length; i++){
            switch (info[i][0]){
                case 1:
                    dir = info[i][1];
                    if(dir == 1) {
                        result -= dir1(i, tmp, list);
                    }
                    else if(dir == 2){
                        result -= dir2(i, tmp, list);
                    }
                    else if (dir == 3) {
                        result -= dir3(i, tmp, list);
                    }
                    else{
                        result -= dir4(i, tmp, list);
                    }
                    break;

                case 2:
                    dir = info[i][1];
                    if(dir == 1){
                        result -= dir2(i, tmp, list) + dir4(i, tmp, list);
                    }
                    else {
                        result -= dir1(i, tmp, list) + dir3(i, tmp, list);
                    }
                    break;

                case 3:
                    dir = info[i][1];
                    if(dir == 1) {
                        result -= dir1(i, tmp, list) + dir2(i, tmp, list);
                    }
                    else if(dir == 2){
                        result -= dir2(i, tmp, list) + dir3(i, tmp, list);
                    }
                    else if (dir == 3) {
                        result -= dir3(i, tmp, list) + dir4(i, tmp, list);
                    }
                    else{
                        result -= dir4(i, tmp, list) + dir1(i, tmp, list);
                    }
                    break;

                case 4:
                    dir = info[i][1];
                    if(dir == 1) {
                        result -= dir4(i, tmp, list) + dir1(i, tmp, list) + + dir2(i, tmp, list);
                    }
                    else if(dir == 2){
                        result -= dir1(i, tmp, list) + dir2(i, tmp, list) + + dir3(i, tmp, list);
                    }
                    else if (dir == 3) {
                        result -= dir2(i, tmp, list) + dir3(i, tmp, list) + dir4(i, tmp, list);
                    }
                    else{
                        result -= dir3(i, tmp, list) + dir4(i, tmp, list) + dir1(i, tmp, list);
                    }
                    break;

            }
        }

        return result;
    }



    private static int dir1(int i, int[][] tmp, List<CCTV> list) {
        int c = list.get(i).c;
        int cnt = 0;
        for(int p=list.get(i).r; p>=0; p--){
            if(tmp[p][c] == 6) return cnt;
            if(tmp[p][c] == 0){
                cnt++;
                tmp[p][c] = 7;
            }
        }

        return cnt;
    }
    private static int dir2(int i, int[][] tmp, List<CCTV> list) {
        int r = list.get(i).r;
        int cnt = 0;
        for(int p=list.get(i).c; p<m; p++){
            if(tmp[r][p] == 6) return cnt;
            if(tmp[r][p] == 0){
                cnt++;
                tmp[r][p] = 7;
            }
        }

        return cnt;
    }
    private static int dir3(int i, int[][] tmp, List<CCTV> list) {
        int c = list.get(i).c;
        int cnt = 0;
        for(int p=list.get(i).r; p<n; p++){
            if(tmp[p][c] == 6) return cnt;
            if(tmp[p][c] == 0){
                cnt++;
                tmp[p][c] = 7;
            }
        }

        return cnt;
    }
    private static int dir4(int i, int[][] tmp, List<CCTV> list) {
        int r = list.get(i).r;
        int cnt = 0;
        for(int p=list.get(i).c; p>=0; p--){
            if(tmp[r][p] == 6) return cnt;
            if(tmp[r][p] == 0){
                cnt++;
                tmp[r][p] = 7;
            }
        }

        return cnt;
    }

    private static int[][] copyOffice(int[][] tmp) {
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                tmp[i][j] = office[i][j];
            }
        }

        return tmp;
    }
}