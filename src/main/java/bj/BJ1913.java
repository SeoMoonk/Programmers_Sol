package bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ1913 {

    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;       //표의 크기
    static int K;       //찾으려는 숫자
    static int[][] snail;
    static int[] directionR = {1, 0, -1, 0};
    static int[] directionC = {0, 1, 0, -1};
    static int r = 0, c = 0, direction = 0;
    static int targetR = 0, targetC = 0;
    static boolean hasFound = false;

    public static void main(String[] args) throws IOException {

        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());

        snail = new int[N][N];

        for (int i = N * N; i > 0; i--) {

            snail[r][c] = i;

            if (!hasFound && i == K) {
                targetR = r + 1;
                targetC = c + 1;
            }

            //다음 경로에 대해 생각해 봄.
            int nextRow = r + directionR[direction];
            int nextCol = c + directionC[direction];

            //밖으로 나가거나, 이미 숫자가 있는 경우 방향 변경
            if (nextRow == N || nextCol == N || nextRow == -1 || nextCol == -1 || snail[nextRow][nextCol] != 0) {
                direction = direction == 3 ? 0 : direction + 1;
                nextRow = r + directionR[direction];
                nextCol = c + directionC[direction];
            }

            r = nextRow;
            c = nextCol;
        }

        print(snail);
    }

    static void print(int[][] snail) {

        StringBuilder sb = new StringBuilder();

        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                sb.append(snail[i][j] + " ");
            }
            sb.append("\n");
        }

        sb.append("%d %d".formatted(targetR, targetC));

        System.out.println(sb.toString());
    }
}
