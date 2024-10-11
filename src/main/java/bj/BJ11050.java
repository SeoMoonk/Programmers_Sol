package bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ11050 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N, K;
    static int answer;

    public static void main(String[] args) throws IOException {

        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        //이항계수 = n! / ((n-k)! * k!)

        answer = factorial(N) / (factorial(N-K) * factorial(K));

        System.out.println(answer);
    }

    static int factorial(int num) {

        int result = 1;

        for(int i=2; i<=num; i++) {
            result = result * i;
        }

        return result;
    }
}