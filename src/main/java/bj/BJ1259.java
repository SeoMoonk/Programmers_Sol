package bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ1259 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static String str;
    static StringBuilder printSb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        while(!(str = br.readLine()).equals("0")) {

            StringBuilder sb = new StringBuilder();
            int num = Integer.parseInt(str);
            int reverseNum;

            for(int i=str.length()-1; i>=0; i--) {
                sb.append(str.charAt(i));
            }

            reverseNum = Integer.parseInt(sb.toString());

            if(reverseNum == num) {
                printSb.append("yes\n");
            } else {
                printSb.append("no\n");
            }
        }

        System.out.print(printSb);
    }
}