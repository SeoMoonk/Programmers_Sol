package bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ2606 {

    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int V;
    static int E;
    static int[][] arr;
    static final int START_COMPUTER = 1;
    static ArrayList<Integer> track = new ArrayList<>();
    static boolean[] visited;

    public static void main(String[] args) throws IOException {

        V = Integer.parseInt(br.readLine());
        E = Integer.parseInt(br.readLine());

        arr = new int[V+1][V+1];
        visited = new boolean[V+1];

        for(int i=0; i<E; i++) {

            StringTokenizer st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            arr[start][end] = 1;
            arr[end][start] = 1;
        }

        ArrayDeque<Integer> stack = new ArrayDeque<>(Arrays.asList(START_COMPUTER));
        visited[START_COMPUTER] = true;

        while(!stack.isEmpty()) {

            int current = stack.removeLast();

            if(!visited[current]) {
                visited[current] = true;
                track.add(current);
            }

            for(int i=1; i<V+1; i++) {
                if(arr[current][i] != 0 && !visited[i]) {
                    stack.addLast(i);
                }
            }
        }

        System.out.println(track.size());
    }
}
