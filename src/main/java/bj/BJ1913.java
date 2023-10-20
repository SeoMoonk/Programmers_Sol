package bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ1913 {

    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static int target;
    static int[][] snail;
    static int r = 0, c = 0, d = 0;
    static final int[] dr = {1, 0, -1, 0};
    static final int[] dc = {0, 1, 0, -1};
    static int targetR = -1;
    static int targetC = -1;

    public static void main(String[] args) throws IOException {

        N = Integer.parseInt(br.readLine());
        target = Integer.parseInt(br.readLine());
        snail = new int[N][N];  //배열을 그리고, 내부를 0으로 모두 초기화

        for(int i = N*N; i > 0; i--) {
            //달팽이가 있는 곳에 기록
            snail[r][c] = i;

            //다음 진행 좌표가 어디인지 계산
            int nr = r + dr[d];
            int nc = c + dc[d];

            //달팽이의 다음 좌표가 맵 밖으로 나가려고 하는가? + 단축연산
            if(nc < 0 || nc >= N || nr < 0 || nr >= N || snail[nr][nc] != 0) {
                //나가려 하거나 이미 값이 있는 곳으로 가려고 한다면 좌표를 다시 계산.
                d = (d+1) % 4;
                nr = r + dr[d];
                nc = c + dc[d];
            }
            //위에서 조절한 좌표를 확정 지음.
            r = nr;
            c = nc;
        }

        print(snail);
    }

    static void print(int[][] snail) {

        for(int i=0; i<snail.length; i++) {
            for(int j=0; j<snail.length; j++) {

                if(snail[i][j] == target) {
                    targetR = i + 1;
                    targetC = j + 1;
                }
                sb.append(snail[i][j] + " ");
            }
            sb.append("\n");
        }
        sb.append(targetR + " " + targetC);

        System.out.println(sb.toString());
    }

}
