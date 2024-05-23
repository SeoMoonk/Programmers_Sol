package bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BJ1197 {

    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int V, E;
    static int[] p;
    static int[] r;
    static List<Edge> edges = new ArrayList<>();
    static int sum = 0;
    static int count = 0;

    public static void main(String[] args) throws IOException {

        st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        p = new int[V + 1];
        r = new int[V + 1];

        for (int i = 0; i < V + 1; i++) {
            p[i] = i;
        }

        for (int i = 0; i < E; i++) {

            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            edges.add(new Edge(start, end, weight));
        }

        edges.sort(Edge::compareTo);

        for (Edge edge : edges) {

            int start = findParent(edge.start);
            int end = findParent(edge.end);
            int weight = edge.weight;

            if (start != end) {
                union(start, end);
                sum += weight;
                count++;
            }

            if (count == V - 1) {
                break;
            }
        }

        System.out.println(sum);

    }

    static int findParent(int x) {

        if (p[x] != x) {
            p[x] = findParent(p[x]);
        }

        return p[x];
    }

    static void union(int x, int y) {

        if (r[x] > r[y]) {
            p[y] = x;
        } else {
            p[x] = y;
            if (r[x] == r[y]) {
                r[y]++;
            }
        }

    }

    static class Edge implements Comparable<Edge> {

        int start;
        int end;
        int weight;

        public Edge(int start, int end, int weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return this.weight - o.weight;
        }
    }
}
