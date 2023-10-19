package bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ10988 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {

        String input = br.readLine();

        int mid = input.length() / 2;
        int answer = 1;

        for(int i=0; i<mid; i++){

            char left = input.charAt(i);
            char right = input.charAt(input.length() - i - 1);

            if(left != right){
                answer = 0;
                break;
            }
        }

        System.out.print(answer);
    }
}
