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
    static int dist;

    public static int solution(int[][] maps) {

        int answer = -1;

        n = maps.length;
        m = maps[0].length;

//        dfs(maps);
        bfs(maps);

        return flag ? dist : answer;
    }

    public static int dfs(int[][] maps) {

        ArrayDeque<int[]> stack = new ArrayDeque<>();
        stack.addLast(new int[]{0,0});
        visited = new boolean[n][m];
        visited[0][0] = true;
        flag = false;
        dist = 0;

        while(!stack.isEmpty()) {

            int size = stack.size();

            for(int i=0; i<size; i++) {

                int[] current = stack.removeLast();
                int curR = current[0];
                int curC = current[1];

                if(curR == n-1 && curC == m-1) {
                    flag=true;
                    stack.clear();
                    break;
                }

                for(int j=0; j<4; j++) {

                    int nr = curR + dr[j];
                    int nc = curC + dc[j];

                    if(nr<0 || nr == n || nc < 0 || nc == m) {
                        continue;
                    }

                    if(maps[nr][nc] == 0 || visited[nr][nc]) {
                        continue;
                    }

                    visited[nr][nc] = true;
                    stack.addLast(new int[]{nr,nc});
                }
            }

            dist++;
        }

        return dist;
    }

    public static int bfs(int[][] maps) {

        ArrayDeque<int[]> queue = new ArrayDeque<>();
        queue.addLast(new int[]{0, 0});
        visited = new boolean[n][m];
        visited[0][0] = true;
        flag = false;
        dist = 0;

        while (!queue.isEmpty()) {

            int size = queue.size();

            for (int i = 0; i < size; i++) {
                
                //갈 수 있는 곳을 모두 탐색
                int[] current = queue.removeFirst();
                int curR = current[0];
                int curC = current[1];

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

                    if (maps[nr][nc] == 0 || visited[nr][nc]) {
                        continue;
                    }

                    visited[nr][nc] = true;
                    queue.addLast(new int[]{nr, nc});
                }
            }
            dist++;
        }

        return dist;
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
