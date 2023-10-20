package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//인접 행렬 만들어보기
public class adjArray {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[][] adj;
    static int V;
    static int E;

    public static void main(String[] args) throws IOException {

        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        //행렬을 만들때는 한 칸 더 넉넉히 만들자. (0번은 비어있음.)
        //행렬은 아래 코드를 통해 아래가 0으로 자동으로 채워짐.
        adj = new int[V+1][V+1];

        for(int i=0; i<E; i++) {

            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            //데칼코마니처럼 양방향으로 연결된것을 표현
            adj[start][end] = 1;
            adj[end][start] = 1;
        }

    }
}
