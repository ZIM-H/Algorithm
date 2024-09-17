import java.util.*;

class Solution {
    static class Pos implements Comparable<Pos> {
        int r, c, cost, corners, dir;

        public Pos(int r, int c, int cost, int corners, int dir) {
            this.r = r;
            this.c = c;
            this.cost = cost;
            this.corners = corners;
            this.dir = dir;
        }

        @Override
        public int compareTo(Pos o) {
            return Integer.compare(this.cost, o.cost);
        }
    }

    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public int solution(int[][] board) {
        int len = board.length;
        int[][][] costs = new int[len][len][4];
        for (int[][] arr : costs) {
            for (int[] inner : arr) {
                Arrays.fill(inner, Integer.MAX_VALUE);
            }
        }

        PriorityQueue<Pos> pq = new PriorityQueue<>();
        pq.add(new Pos(0, 0, 0, 0, -1));
        
        for (int d = 0; d < 4; d++) {
            costs[0][0][d] = 0; 
        }

        while (!pq.isEmpty()) {
            Pos now = pq.poll();

            if (now.r == len - 1 && now.c == len - 1) {
                return now.cost;
            }

            
            for (int d = 0; d < 4; d++) {
                int nr = now.r + dr[d];
                int nc = now.c + dc[d];

                
                if (nr >= 0 && nr < len && nc >= 0 && nc < len && board[nr][nc] == 0) {
                    int newCost = now.cost + 100; 
                    int newCorners = now.corners;

                   
                    if (now.dir != -1 && now.dir != d) {
                        newCorners++;
                        newCost += 500;
                    }

                    
                    if (costs[nr][nc][d] > newCost) {
                        costs[nr][nc][d] = newCost;
                        pq.add(new Pos(nr, nc, newCost, newCorners, d));
                    }
                }
            }
        }
        return -1; 
    }
}