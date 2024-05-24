package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Dijkstra_vs_Prim {

    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N, M;
    static PriorityQueue<Node> pq = new PriorityQueue<>();
    static ArrayList<Node>[] adj;
    static boolean[] visited;           //다익스트라는 visited 사용하지 않음.
    static long[] dist;
    static final long INF = Long.MAX_VALUE;
    static int startTarget, endTarget;

    public static void main(String[] args) throws IOException {

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        adj = new ArrayList[N+1];
        dist = new long[N+1];
        visited = new boolean[N+1];

        for(int i=0; i<N+1; i++) {
            adj[i] = new ArrayList<>();
            dist[i] = INF;
        }

        for(int i=0; i<M; i++) {

            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            adj[start].add(new Node(weight, end));
        }

        st = new StringTokenizer(br.readLine());
        startTarget = Integer.parseInt(st.nextToken());
        endTarget = Integer.parseInt(st.nextToken());

        dijkstra();
        System.out.println(dist[endTarget]);

//        prim();
//
//        long sum = 0L;
//        for(long cost : dist) {
//            sum+=cost;
//        }
//        sum-=INF;
//        System.out.println(sum);

    }

//    static void prim() {
//
//        pq.offer(new Node(0, 1));
//        dist[1] = 0;
//
//        while(!pq.isEmpty()) {
//
//            Node current = pq.poll();
//            int nodeNum = current.nodeNum;
//
//            //방문 검사
//            if(!visited[nodeNum]) {
//                visited[nodeNum] = true;
//            } else {
//                continue;
//            }
//
//            for(Node nextNode : adj[nodeNum]) {
//
//                long nextDist = nextNode.distance;
//                int nextNum = nextNode.nodeNum;
//
//                if(!visited[nextNum] && dist[nextNum] > nextDist) {
//                    dist[nextNum] = nextDist;
//                    pq.offer(new Node(nextDist, nextNum));
//                }
//            }
//        }
//    }

    static void dijkstra() {

        pq.offer(new Node(0, startTarget));
        dist[startTarget] = 0;

        while(!pq.isEmpty()) {

            Node current = pq.poll();
            int nodeNum = current.nodeNum;
            long distance = current.distance;

            if(dist[nodeNum] < distance) {
                continue;
            }

            for(Node nextNode : adj[nodeNum]) {

                long nextDist = nextNode.distance;
                int nextNum = nextNode.nodeNum;

                if(dist[nextNum] > distance + nextDist) {
                    dist[nextNum] = distance + nextDist;
                    pq.offer(new Node(dist[nextNum], nextNum));
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

