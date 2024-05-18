package bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ1931 {

    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static int[][] times;
    static int lastEnd = 0;
    static int cnt = 0;

    public static void main(String[] args) throws IOException {

        N = Integer.parseInt(br.readLine());
        times = new int[N][N];

        for(int i=0; i<N; i++) {

            StringTokenizer st = new StringTokenizer(br.readLine());

            int startTime = Integer.parseInt(st.nextToken());
            int endTime = Integer.parseInt(st.nextToken());

            times[i][0] = startTime;
            times[i][1] = endTime;
        }

        //회의 종료 시간순으로 정렬하고, 종료 시간이 같다면 시작 시간 오름차순으로 정렬
        Arrays.sort(times, (o1, o2) -> o1[1] != o2[1] ? o1[1] - o2[1] : o1[0] - o2[0]);

        for(int[] time : times) {
            if(lastEnd <= time[0]) {
                cnt++;
                lastEnd = time[1];
            }
        }

        System.out.println(cnt);
    }
}
