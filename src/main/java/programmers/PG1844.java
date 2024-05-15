package programmers;

import java.io.IOException;
import java.util.ArrayDeque;

public class PG1844 {

    static int n;
    static int m;
    static int[] dr = {1, 0, -1, 0};
    static int[] dc = {0, 1, 0, -1};
    static boolean[][] visited;
    static boolean flag;
    static int dist = 0;

    public static int solution(int[][] maps) {

        int answer = -1;

        n = maps.length;
        m = maps[0].length;

        bfs(maps);

        if(flag) {
            return dist;
        }

        return answer;
    }

    public static void bfs(int[][] maps) {

        ArrayDeque<int[]> queue = new ArrayDeque<>();
        queue.addLast(new int[]{0, 0});
        visited = new boolean[n][m];
        visited[0][0] = true;
        flag = false;

        while (!queue.isEmpty()) {

            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int[] current = queue.removeFirst();
                int curR = current[0];
                int curC = current[1];

                if (curR == n - 1 && curC == m - 1) {
                    flag = true;
                    queue.clear();
                    break;
                }

                for (int j = 0; j < 4; j++) {

                    int nr = curR + dr[j];
                    int nc = curC + dc[j];

                    if (nr < 0 || nr >= n || nc < 0 || nc >= m) {
                        continue;
                    }

                    if (maps[nr][nc] == 0 || visited[nr][nc]) {
                        continue;
                    }

                    visited[nr][nc] = true;
                    queue.addLast(new int[]{nr, nc});
                }
            }
            dist++;
        }
    }

    public static void main(String[] args) throws IOException {

        int[][] maps = {{1, 0, 1, 1, 1},
            {1, 0, 1, 0, 1},
            {1, 0, 1, 1, 1},
            {1, 1, 1, 0, 1},
            {0, 0, 0, 0, 1}};

        int solution = solution(maps);

        System.out.println(solution);

    }

}
