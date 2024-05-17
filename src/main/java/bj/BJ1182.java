package bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ1182 {

    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, S;
    static int[] arr;
    static int count = 0;

    public static void main(String[] args) throws IOException {

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        arr = new int[N];

        st = new StringTokenizer(br.readLine());

        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=0; i<1<<N; i++) {

            int temp = 0;

            for(int j=0; j<N; j++) {
                if ((i&(1<<j)) != 0) {
                    temp += arr[j];
                }
            }

            if(temp == S) {
                count++;
            }
        }

        if(S == 0) {
            count--;
        }

        System.out.println(count);
    }
}
