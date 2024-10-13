package bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class BJ1676 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static int count = 0;

    public static void main(String[] args) throws IOException {

        N = Integer.parseInt(br.readLine());

        BigInteger factorial = BigInteger.ONE;

        for(int i=2; i<=N; i++) {
            factorial = factorial.multiply(BigInteger.valueOf(i));
        }

        String numStr = factorial.toString();

        for(int i=numStr.length() -1; i>=0; i--) {
            if(numStr.charAt(i) == '0') {
                count++;
            } else {
                break;
            }
        }
        System.out.println(count);
    }
}