package swea;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class SW_1954 {

    static int printCnt = 1;
    static final int[] dr = { 0, 1, 0, -1 };
    static final int[] dc = { 1, 0, -1, 0 };

    public static void main(String args[]) throws Exception
    {
        //System.setIn(new FileInputStream("src/main/res/input.txt"));

        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++)
        {
            int size = sc.nextInt();

            int[][] snail = new int[size][size];

            int r = 0, c = 0, d = 0;

            for(int i=1; i<=size*size; i++) {

                snail[r][c] = i;

                int cr = r + dr[d];
                int cc = c + dc[d];

                if(cc <0 || cc>=size || cr < 0 || cr >= size || snail[cr][cc] != 0) {
                    d = (d+1) % 4;
                    cr = r + dr[d];
                    cc = c + dc[d];
                }

                r = cr;
                c = cc;
            }

            print(snail);
        }
    }

    static void print(int[][] graph) {

        StringBuilder sb = new StringBuilder();

        sb.append("#" + printCnt + "\n");
        for(int i=0; i< graph.length; i++) {
            for(int j=0; j< graph.length; j++) {

                sb.append(graph[i][j] + " ");
            }
            sb.append("\n");
        }

        System.out.print(sb.toString());

        printCnt++;
    }
}
