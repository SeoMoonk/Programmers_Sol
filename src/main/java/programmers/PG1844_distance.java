package programmers;

import java.io.IOException;
import java.util.ArrayDeque;

public class PG1844_distance {
    static int n;
    static int m;
    static int[] dr = {1, 0, -1, 0};
    static int[] dc = {0, 1, 0, -1};
    static int[][] dist;
    static boolean flag;

    public static int solution(int[][] maps) {

        int answer = -1;

        n = maps.length;
        m = maps[0].length;

        bfs(maps);

        return flag ? dist[n-1][m-1] : answer;
    }

    public static void bfs(int[][] maps) {

        ArrayDeque<int[]> queue = new ArrayDeque<>();
        queue.addLast(new int[]{0, 0});
        dist = new int[n][m];
        dist[0][0] = 1;
        flag = false;

        while (!queue.isEmpty()) {

            int size = queue.size();

            for (int i = 0; i < size; i++) {

                //갈 수 있는 곳을 모두 탐색
                int[] current = queue.removeFirst();
                int curR = current[0];
                int curC = current[1];

                //visited를 여기서 true로 변경하면 시간 초과가 발생

                //목적지에 도달하면 바로 나가기 (queue clear + break)
                if (curR == n - 1 && curC == m - 1) {
                    flag = true;
                    queue.clear();
                    break;
                }

                //4방향을 탐색하면서, 갈 수 있는 곳들을 모두 스택에 집어넣음 (+ 방문처리)
                for (int j = 0; j < 4; j++) {

                    int nr = curR + dr[j];
                    int nc = curC + dc[j];

                    if (nr < 0 || nr >= n || nc < 0 || nc >= m) {
                        continue;
                    }

                    if (maps[nr][nc] == 0 || dist[nr][nc] != 0) {
                        continue;
                    }

                    //여기에서 확실히 갈 수 있을 때 visited를 바꿔야 시간 초과가 안 남.
                    dist[nr][nc] = dist[curR][curC] + 1;
                    queue.addLast(new int[]{nr, nc});
                }
            }
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