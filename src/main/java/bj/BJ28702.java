package bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ28702 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int maxNum = -1;
    static int maxNumIdx = -1;


    public static void main(String[] args) throws IOException {

        for(int i=1; i<=3; i++) {
            String input = br.readLine();

            if(!input.startsWith("F") && !input.startsWith("B")) {
                maxNum = Integer.parseInt(input);
                maxNumIdx = i;
            }
        }

        int nextNum = maxNum + (4-maxNumIdx);
        boolean isFizz = nextNum%3==0;
        boolean isBuzz = nextNum%5==0;

        if(isFizz && isBuzz) {
            System.out.println("FizzBuzz");
        } else if(isFizz){
            System.out.println("Fizz");
        } else if(isBuzz) {
            System.out.println("Buzz");
        } else {
            System.out.println(nextNum);
        }
    }
}