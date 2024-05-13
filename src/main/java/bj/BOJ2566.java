package bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2566 {

    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int MAX_VALUE = -1;
    static int I;
    static int J;

    public static void main(String[] args) throws IOException {

        StringTokenizer st;

        for(int i=0; i<9; i++) {

            st = new StringTokenizer(br.readLine());

            for(int j=0; j<9; j++) {
                int num = Integer.parseInt(st.nextToken());

                if(MAX_VALUE < num) {
                    MAX_VALUE = num;
                    I = i+1;
                    J = j+1;
                }
            }
        }

        System.out.println(MAX_VALUE);
        System.out.printf("%d %d", I, J);
    }
}
