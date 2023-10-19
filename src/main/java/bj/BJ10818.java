package bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ10818 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int n;

    public static void main(String[] args) throws IOException {

        n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int maxtmp = -1000001;
        int mintmp = 1000001;

        for(int i=0; i<n; i++) {

            //토큰을 배열에 저장하지 말고, 바로바로 대소 비교를 하자!!
            int num = Integer.parseInt(st.nextToken());
            //if 문으로 <, > 비교할 필요가 없다
            maxtmp = Math.max(num, maxtmp);
            mintmp = Math.min(num, mintmp);
        }

        System.out.printf("%d %d", mintmp, maxtmp);
    }
}
