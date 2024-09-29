package bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BJ2798 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static ArrayList<Integer> numList = new ArrayList<>();
    static StringTokenizer st;
    static int N, M;
    static int num;
    static int maxValue = 0;

    public static void main(String[] args) throws IOException {

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            num = Integer.parseInt(st.nextToken());
            numList.add(num);
        }

        numList.sort(Comparator.naturalOrder());

        for(int i=0; i<N-2; i++) {
            for(int j=i+1; j<N-1; j++) {
                for(int k=j+1; k<N; k++) {

                    int sum = numList.get(i) + numList.get(j) + numList.get(k);

                    if(sum <= M) {
                        maxValue = Math.max(maxValue, sum);
                    }

                    if(sum == M) {
                        System.out.println(M);
                        return;
                    }
                }
            }
        }

        System.out.println(maxValue);
    }
}