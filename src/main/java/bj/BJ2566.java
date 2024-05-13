package bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ2566 {

    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int MAX_VALUE = -1;
    static int row;
    static int column;

    public static void main(String[] args) throws IOException {

        StringTokenizer st;

        for(int i=0; i<9; i++) {

            st = new StringTokenizer(br.readLine());

            for(int j=0; j<9; j++) {
                int num = Integer.parseInt(st.nextToken());

                if(MAX_VALUE < num) {
                    MAX_VALUE = num;
                    row = i+1;
                    column = j+1;
                }
            }
        }

        System.out.println(MAX_VALUE);
        System.out.printf("%d %d", row, column);
    }
}
