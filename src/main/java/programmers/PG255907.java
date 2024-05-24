package programmers;

import java.util.*;

public class PG255907 {

    static int[] dr = {1, 0, -1, 0};
    static int[] dc = {0, 1, 0, -1};
    static int answer = -1;
    static int[][] adj;
    static ArrayDeque<int[]> queue = new ArrayDeque<>();
    static Set<String> visited = new HashSet<>();
    static int N, M;

    public static int solution(int n, int m, int[][] hole) {

        N = n;
        M = m;

        adj = new int[M][N];

        for(int i=0; i<M; i++) {
            Arrays.fill(adj[i], 1);
        }

        for(int[] trap : hole) {
            int r = trap[1] -1;
            int c = trap[0] -1;

            adj[r][c] = 0;
        }

        queue.add(new int[] {0, 0, 0, 0});
        visited.add("0,0,0");

        while(!queue.isEmpty()) {

            int[] current = queue.poll();
            int r = current[0];
            int c = current[1];
            int shoes = current[2];
            int tries = current[3];

            if(r == M-1 && c == N-1) {
                answer = tries;
                break;
            }

            if(shoes == 1) {
                delta_search(r, c, 1, 1, tries);
            } else {
                delta_search(r, c, 1, 0, tries);
                delta_search(r, c, 2, 1, tries);
            }
        }

        return answer;
    }

    static void delta_search(int r, int c, int times, int flag, int tries) {

        for(int i=0; i<4; i++) {

            int nr = r + dr[i] * times;
            int nc = c + dc[i] * times;

            if(nr < 0 || nr >= M || nc < 0 || nc >= N) {
                continue;
            }

            if(adj[nr][nc] == 0 || visited.contains(nr+","+nc+","+flag)) {
                continue;
            }

            queue.add(new int[] {nr, nc, flag, tries+1});
            visited.add(nr+","+nc+","+flag);
        }
    }

    public static void main(String[] args) {

        int n = 5;
        int m = 4;
        int[][] hole = {{1,4}, {2,1}, {2,2}, {2,3}, {2,3}, {3,3}, {4,1}, {4,3}, {5,3}};

        int result = solution(n, m, hole);
        System.out.println(result);
    }

}
