package bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ15649 {

    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, M;
    static String[] sel;
    static int[] check;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        //1부터 N까지 중복 없이 M개를 고른 "수열"
        sel = new String[M];
        check = new int[N];

        perm(0);
        System.out.println(sb.toString());
    }

    static void perm(int depth) {

        if(depth == M) {
            for(int i=0; i<M; i++) {
                sb.append(sel[i] + " ");
            }
            sb.append("\n");
            return;
        }

        for(int i=0; i<N; i++) {

            if(check[i] == 0) {
                check[i] = 1;
                sel[depth] = Integer.toString(i+1);
                perm(depth+1);
                check[i] = 0;
            }
        }
    }
}
