package bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ11659 {

    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static final StringBuilder sb = new StringBuilder();
    static int N;       //수의 개수
    static int M;       //합을 구해야 하는 횟수
    static int[] sumArr;   //누적 합 배열

    public static void main(String[] args) throws IOException {

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        sumArr = new int[N];

        st = new StringTokenizer(br.readLine());

        sumArr[0] = Integer.parseInt(st.nextToken());

        for(int i=1; i<N; i++) {
            sumArr[i] = sumArr[i-1] + Integer.parseInt(st.nextToken());
        }

        for(int i=0; i<M; i++) {

            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken()) - 1;
            int end = Integer.parseInt(st.nextToken()) - 1;

            sb.append(start == 0 ? sumArr[end] : sumArr[end] - sumArr[start-1]);
            sb.append("\n");
        }

        System.out.println(sb.toString());
    }
}
