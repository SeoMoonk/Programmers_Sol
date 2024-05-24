package bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ1916 {

    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N, M;
    static ArrayList<Node>[] adj;
    static PriorityQueue<Node> pq = new PriorityQueue<>();
    static long inf = Long.MAX_VALUE;
    static long[] dist;
    static int startNode, endNode;

    public static void main(String[] args) throws IOException {

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        adj = new ArrayList[N+1];
        dist = new long[N+1];

        for(int i=0; i<N+1; i++) {
            adj[i] = new ArrayList<>();
            dist[i] = inf;
        }

        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            long distance = Long.parseLong(st.nextToken());

            adj[start].add(new Node(distance, end));
        }

        st = new StringTokenizer(br.readLine());
        startNode = Integer.parseInt(st.nextToken());
        endNode = Integer.parseInt(st.nextToken());

        dijkstra();

        System.out.println(dist[endNode]);
    }

    static void dijkstra() {

        pq.offer(new Node(0, startNode));
        dist[startNode] = 0;

        while(!pq.isEmpty()) {

            Node current = pq.poll();
            int nodeNum = current.nodeNum;
            long distance = current.distance;

            if(dist[nodeNum] < distance) {
                continue;
            }

            for(Node node : adj[nodeNum]) {

                int nextNode = node.nodeNum;
                long nextDist = node.distance;

                if(dist[nextNode] > nextDist + distance) {
                    dist[nextNode] = nextDist + distance;
                    pq.offer(new Node(nextDist + distance, nextNode));
                }
            }
        }
    }

    static class Node implements Comparable<Node> {

        long distance;
        int nodeNum;

        public Node(long distance, int nodeNum) {
            this.distance = distance;
            this.nodeNum = nodeNum;
        }

        @Override
        public int compareTo(Node o) {
            return Long.compare(this.distance, o.distance);
        }
    }
}
