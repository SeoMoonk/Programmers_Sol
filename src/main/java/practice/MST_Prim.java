package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class MST_Prim {

    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int V, E;
    static ArrayList<Node>[] adj;
    static boolean[] visited;
    static long[] dist;
    static long inf = Long.MAX_VALUE;
    static PriorityQueue<Node> pq = new PriorityQueue<>();
    static long sum = 0;

    public static void main(String[] args) throws IOException {

        st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        adj = new ArrayList[V+1];
        visited = new boolean[V+1];
        dist = new long[V+1];

        for(int i=0; i<V+1; i++) {
            adj[i] = new ArrayList<>();
            dist[i] = inf;
        }

        for(int i=0; i<E; i++) {
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int distance = Integer.parseInt(st.nextToken());

            adj[start].add(new Node(distance, end));
            adj[end].add(new Node(distance, start));
        }

        prim();

        for(long length : dist) {
            sum += length;
        }

        sum -= inf;

        System.out.println(sum);
    }

    static void prim() {

        pq.offer(new Node(0, 1));
        dist[1] = 0;

        while(!pq.isEmpty()) {

            Node current = pq.poll();
            int nodeNum = current.nodeNum;

            if(!visited[nodeNum]) {
                visited[nodeNum] = true;
            } else {
                continue;
            }

            //다음으로 갈 수 있는 곳들을 탐색
            for(Node node : adj[nodeNum]) {

                long distance = node.distance;
                int nextNode = node.nodeNum;

                if(!visited[nextNode] && dist[nextNode] > distance) {
                    dist[nextNode] = distance;
                    pq.offer(new Node(distance, nextNode));
                }
            }
        }

    }

    static class Node implements Comparable<Node> {

        long distance;
        int nodeNum;

        public Node(long distance, int nextNode) {
            this.distance = distance;
            this.nodeNum = nextNode;
        }

        @Override
        public int compareTo(Node o) {
            return Long.compare(this.distance, o.distance);
        }
    }

}
