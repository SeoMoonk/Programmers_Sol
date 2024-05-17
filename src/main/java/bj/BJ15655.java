package bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ15655 {

    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, M;
    static int[] arr;
    static int[] sel;
    static boolean[] check;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        sel = new int[M];
        check = new boolean[N];

        st = new StringTokenizer(br.readLine());

        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

//        perm(0);
        repCombi(0, 0);
        System.out.println(sb.toString());

    }

    static void perm(int depth) {

        if(depth == M) {
            for(int i=0; i<M; i++) {
                sb.append("%d ".formatted(sel[i]));
            }
            sb.append("\n");
            return;
        }

        for(int i=0; i<N; i++) {

            if(depth >= 1 && sel[depth-1] <= arr[i] && !check[i]) {
                check[i] = true;
                sel[depth] = arr[i];
                perm(depth+1);
                check[i] = false;
            } else if(depth == 0) {
                check[i] = true;
                sel[depth] = arr[i];
                perm(depth+1);
                check[i] = false;
            }
        }
    }

    static void repCombi(int idx, int sidx) {

        if (sidx == M) {
            for (int i = 0; i < M; i++) {
                sb.append(sel[i] + " ");
            }
            sb.append("\n");
            return;
        }

        if (idx == N) {
            return;
        }

        sel[sidx] = arr[idx];
        repCombi(idx+1, sidx+1);
        repCombi(idx+1, sidx);
    }
}
