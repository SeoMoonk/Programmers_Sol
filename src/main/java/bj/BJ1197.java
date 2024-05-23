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
    static List<Edge> edges = new ArrayList<>();
    static int[] p;
    static int[] r;
    static int totalWeight = 0, count = 0;

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

    public static void main(String[] args) throws IOException {

        st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        p = new int[V+1];
        r = new int[V+1];

        for(int i=0; i<V+1; i++) {
            p[i] = i;
        }

        for(int i=0; i<E; i++) {

            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            edges.add(new Edge(start, end, weight));
        }

        edges.sort(Edge::compareTo);

        for(Edge edge : edges) {

            int startRoot = find(edge.start);
            int endRoot = find(edge.end);

            if (startRoot != endRoot) {  // 최종 부모가 다르면?
                union(startRoot, endRoot);  // Union 가능!

                totalWeight += edge.weight;  // mst에 현재 가중치를 추가하고
                count += 1;  // 간선을 하나 소진했음을 나타냄
            }

            if (count == V - 1) {  // 트리의 갯수만큼 뽑았다?
                break; // 알고리즘 종료!
            }
        }

        System.out.println(totalWeight);
    }

    static int find(int x) {

        if(p[x] != x) {
            p[x] = find(p[x]);
        }

        return p[x];
    }

    static void union(int x, int y) {

        if(r[x] > r[y]) {
            p[y] = p [x];
        } else {
            p[x] = p[y];

            if(r[x] == r[y]) {
                r[y]++;
            }
        }

    }

}
