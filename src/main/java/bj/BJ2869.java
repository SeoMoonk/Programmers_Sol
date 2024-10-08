package bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ2869 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int A, B, V;
    static int count = 0;

    public static void main(String[] args) throws IOException {

        st = new StringTokenizer(br.readLine());

        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        //마지막 날에 내려오는 것을 고려하여 1차 계산
        count = (V-B) / (A-B);

        //위에서 내려오는 상황을 고려했으므로, 반대로 남아서 한번 더 올라가야 되는 상황을 고려
        if((V-B) % (A-B) != 0) {
            count++;
        }

        System.out.println(count);
    }
}