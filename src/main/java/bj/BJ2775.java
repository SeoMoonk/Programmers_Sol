package bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ2775 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static int[][] apt = new int[16][16];
    static int T;

    public static void main(String[] args) throws IOException {

        T = Integer.parseInt(br.readLine());

        for(int i=0; i<15; i++) {
            apt[i][1] = 1;
            apt[0][i] = i;
        }

        for(int i=1; i<15; i++) {
            for(int j=2; j<15; j++) {
                apt[i][j] = apt[i][j - 1] + apt[i - 1][j];
            }
        }

        for(int i=0; i<T; i++) {

            int k = Integer.parseInt(br.readLine());        //층수
            int n = Integer.parseInt(br.readLine());        //호수

            sb.append(apt[k][n] + "\n");
        }

        System.out.print(sb.toString());
    }
}