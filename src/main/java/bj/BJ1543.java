package bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ1543 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {

        String text = br.readLine();
        String target = br.readLine();

        int n = text.length();
        int m = target.length();

        int totalCount = 0;

        for(int i=0; i<n-m+1; i++) {

            int cnt = 0;

            for(int j=0; j<m; j++) {

                if(text.charAt(i + j) == target.charAt(j)){
                    cnt++;
                } else {
                    break;
                }

                if(cnt == m){
                    totalCount++;
                    i = i + m - 1;
                    break;
                }
            }
        }

        System.out.println(totalCount);
    }
}
