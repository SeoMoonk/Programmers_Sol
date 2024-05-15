package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class 마을_최대_크기 {

    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[][] arr;
    static int N;
    static int[] dr = {1, 0, -1, 0};
    static int[] dc = {0, 1, 0, -1};
    static int answer = 0;

    public static void main(String[] args) throws IOException {

        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];

        for (int i = 0; i < N; i++) {

            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0; i< N; i++) {
            for(int j=0; j< N; j++) {
                //집이 있는 곳들마다 dfs를 돌리고, 최대값을 answer에 갱신
                if(arr[i][j] == 1) {
                    answer = Math.max(answer, dfs(i, j));
                }
            }
        }

        System.out.println(answer);
    }

    static int dfs(int r, int c) {

        int cnt = 1;
        arr[r][c] = 0;

        // { row, column } 쌍을 배열로 해서 스택에 집어넣기!

        ArrayDeque<int[]> stack = new ArrayDeque<>();
        stack.addLast(new int[] {r, c});

        while(!stack.isEmpty()) {

            int[] current = stack.removeLast();
            int curR = current[0];
            int curC = current[1];

            //현재 위치에서, 4 방향을 전부 돌면서
            for(int i=0; i<4; i++) {
                int nr = curR + dr[i];
                int nc = curC + dc[i];

                //마을을 벗어났거나, 그 곳에는 집이 없다면 continue
                if(nr < 0 || nr == N || nc < 0 || nc == N || arr[nr][nc] == 0) {
                    continue;
                }

                // 1. continue가 되지 않은(집이 있는) 집을 스택에 집어넣고
                // 2. 마을에 없는 셈 친다(이미 센 집 이라는 뜻).
                // 3. count를 1 증가 시킨다. ( == 첫 위치 기준 dfs로 측정한 최대 마을 크기 )
                stack.addLast(new int[] {nr, nc});
                arr[nr][nc] = 0;
                cnt++;
            }
        }
        return cnt;
    }

}
