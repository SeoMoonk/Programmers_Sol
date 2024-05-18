package bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ1717_TODO {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[] p; // parent 배열
    static int[] r; // 트리의 랭크 기록용
    static int V, E; // 그래프의 노드, 간선의 갯수

    // find-set 연산
    static int findParent(int x) {
        if (x != p[x]) {
            p[x] =  findParent(p[x]);
        }
        return p[x];
    }

    // union 연산
    static void union(int x, int y) {
        if (r[x] > r[y]) {
            p[y] = x;

        } else {
            p[x] = y;
            if (r[x] == r[y]) {
                r[y] += 1;
            }
        }
    }


    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        p = new int[V+1];
        r = new int[V+1];

        for (int i = 0; i < V + 1; i++) {
            p[i] = i;  // make set 연산
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int command = Integer.parseInt(st.nextToken());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            if (command == 0) {
                union(findParent(start), findParent(end));
            } else {
                System.out.println(findParent(start) == findParent(end) ? "YES" : "NO");
            }
        }
    }
}
