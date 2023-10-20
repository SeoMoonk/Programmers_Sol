package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class adjList {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int V;
    static int E;
    static ArrayList[] adj;

    public static void main(String[] args) throws IOException {

        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        adj = new ArrayList[V + 1];

        //ArrayList는 자동으로 0을 채워주지 않아서, 아래의 과정이 필요
        for(int i=0; i<V+1; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i=0; i<E; i++) {
            st = new StringTokenizer(br.readLine());
            int start =Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            adj[start].add(end);
            adj[end].add(start);
        }

        System.out.println(Arrays.toString(adj));
    }
}
