package swea;

import java.util.*;
import java.io.*;

public class SW1859 {

    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static final StringBuilder sb = new StringBuilder();
    static int T, N;
    static int[] arr;

    public static void main(String[] args) throws IOException {

        T = Integer.parseInt(br.readLine());

        for(int i=0; i<T; i++) {

            N = Integer.parseInt(br.readLine());
            arr = new int[N];
            st = new StringTokenizer(br.readLine());

            for(int j=0; j<N; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }

            solution(i+1);
        }

        System.out.println(sb.toString());
    }

    static void solution(int testIdx) {

        int max = 0;
        long result = 0;

        //거꾸로 돌면서, 큰 값이 나올때 마다 갱신,
        //작은 값이 나온다면, 최대 값에서 현재 값을 빼서 이득으로 추가.

        for(int i=arr.length-1; i>=0; i--) {
            if(arr[i] > max) {
                max = arr[i];
            }
            else {
                result += max - arr[i];
            }
        }
        sb.append("#%d %d\n".formatted(testIdx, result));
    }

}
