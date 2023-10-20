package bj;

import java.io.*;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ2606 {

    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[][] adjArr;
    static int V, E;
    static int startNode = 1;
    static boolean[] visited;
    static ArrayList<Integer> track = new ArrayList<>(); //이동 궤적 기록용

    public static void main(String[] args) throws IOException{

        V = Integer.parseInt(br.readLine());
        E = Integer.parseInt(br.readLine());

        adjArr = new int[V+1][V+1];
        visited = new boolean[V+1];

        for(int i=0; i<E; i++) {

            StringTokenizer st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            adjArr[start][end] = 1;
            adjArr[end][start] = 1;
        }

        ArrayDeque<Integer> stack = new ArrayDeque<>(Arrays.asList(startNode));

        while(!stack.isEmpty()) {

            int current = stack.removeLast();

            //현재 위치에 방문한 기록이 없다면
            if(!visited[current]) {
                //방문 처리하고, 여기 들어갔었다고 track에 저장
                visited[current] = true;
                track.add(current);
            }

            //현재 노드(행) 에서, 연결된 것들을 전부 탐색
            for(int destination = 1; destination < V+1; destination++) {

                //혹시 연결된 것 중에 방문하지 않은 노드를 찾았다면 스택에 추가
                if(!visited[destination] && adjArr[current][destination] == 1) {
                    stack.addLast(destination);
                }
            }
        }

        //바이러스 문제의 포인트
        // 1. DFS를 통해 1번 노드에서 출발했을 때, 어디까지 갈 수 있는지를 확인하는 문제이다.
        // 2. 1번 컴퓨터를 통해 걸린 컴퓨터의 수 이므로 1번은 제외 (-1) 이 된다.
        System.out.println(track.size() - 1);

    }

}
