import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int t=Integer.parseInt(br.readLine()); t>0; t--){
            int fuse = Integer.parseInt(br.readLine());

            long[] mindp=new long[101];

            Arrays.fill(mindp,Long.MAX_VALUE);

            mindp[2]=1;
            mindp[3]=7;
            mindp[4]=4;
            mindp[5]=2;
            mindp[6]=6;
            mindp[7]=8;
            mindp[8]=10;
            String[] addmin= {"1","7","4","2","0","8"};

            // 작은수
            for(int i=9;i<=100;i++) {
                for(int j=2;j<=7;j++) {
                    String str=mindp[i-j]+addmin[j-2];
                    mindp[i] = Math.min(mindp[i],Long.parseLong(str));
                }
            }

            // 큰수
            StringBuilder max=new StringBuilder();
            for(int i=0;i<fuse/2-1;i++){
                max.append("1");
            }

            if(fuse % 2 == 1) max.insert(0, "7");
            else max.insert(0, "1");

            System.out.println(mindp[fuse]+" "+max);
        }
    }
}