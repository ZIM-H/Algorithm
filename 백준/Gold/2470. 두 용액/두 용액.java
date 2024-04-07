import java.util.*;
import java.io.*;
public class Main {

  public static void main(String[] args) throws NumberFormatException, IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int N = Integer.valueOf(br.readLine());
    int[] list = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

    Arrays.sort(list);
    int[] result = calculateArr(list, N);

    bw.write(result[0] + " " + result[1] + "\n");
    bw.flush();
    bw.close();
  }

  static int[] calculateArr(int[] list, int N) {
    int start = 0;
    int end = N - 1;
    int maxDiff = 2000000000;
    int[] result = new int[2];

    while (start < end) {
      int sum = list[start] + list[end];
      if (Math.abs(sum) < maxDiff) {
        result[0] = list[start];
        result[1] = list[end];
        maxDiff = Math.abs(sum);
      }
        
      if (sum > 0)

        end--;
      else
        start++;

    }

    return result;
  }

}