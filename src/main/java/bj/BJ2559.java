package bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ2559 {

    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;       //온도를 측정한 전체 날짜의 수
    static int K;       //합을 구하기 위한 연속적인 날짜의 수
    static int[] arr;   //매일 측정한 온도
    static int MAX_TEMP = -10000001;

    public static void main(String[] args) throws IOException {

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new int[N];

        st = new StringTokenizer(br.readLine());

        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int temp = 0;

        for(int i=0; i<K; i++) {
            temp += arr[i];
        }

        MAX_TEMP = Math.max(MAX_TEMP, temp);

        for(int i=K; i<N; i++) {
            temp = temp - arr[i-K] + arr[i];
            MAX_TEMP = Math.max(MAX_TEMP, temp);
        }

        System.out.println(MAX_TEMP);
    }
}
