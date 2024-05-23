package bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ1717 {

    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int N, M;
    static int[] p;     //parents
    static int[] r;  //rank

    public static void main(String[] args) throws IOException {

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        p = new int[N + 1];
        r = new int[N + 1];

        //make-set
        for (int i = 0; i < N + 1; i++) {
            p[i] = i;
        }

        for (int i = 0; i < M; i++) {

            st = new StringTokenizer(br.readLine());

            int operation = Integer.parseInt(st.nextToken());
            int left = Integer.parseInt(st.nextToken());
            int right = Integer.parseInt(st.nextToken());

            if (operation == 0) {
                union(find(left), find(right));
            } else {
                System.out.println(find(left) == find(right) ? "YES" : "NO");
            }

        }

    }

    static int find(int x) {

        if(x != p[x]) {
            p[x] = find(p[x]);
        }

        return p[x];
    }

    static void union(int x, int y) {

        if(r[x] > r[y]) {
            p[y] = x;
        } else {
            p[x] = y;

            if(r[x] == r[y]) {
                r[y]++;
            }
        }

    }

}
