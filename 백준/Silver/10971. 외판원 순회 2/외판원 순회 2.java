import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static boolean[] visited;
	static int n, min;
	static int[][] way;
	static int[] city;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		n = Integer.parseInt(br.readLine());
		way = new int[n][n];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				way[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		min = Integer.MAX_VALUE;
		city = new int[n];
		visited = new boolean[n];
		perm(0);

		System.out.println(min);

	}

	private static void perm(int cnt) {
		if (cnt == n) {
			int cost = 0;
			for (int i = 0; i < n - 1; i++) {
				if (way[city[i]][city[i + 1]] == 0) {
					return;
				}
				cost += way[city[i]][city[i + 1]];
			}
			if(way[city[n - 1]][city[0]] == 0) {
				return;
			}
			cost += way[city[n - 1]][city[0]];
			min = Math.min(min, cost);
			return;
		}

		for (int i = 0; i < n; i++) {
			if (visited[i])
				continue;
			city[cnt] = i;
			visited[i] = true;
			perm(cnt + 1);
			visited[i] = false;
		}

	}
}