package bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BJ2609 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, M;
    static ArrayList<Integer> numsOfN = new ArrayList<>();
    static ArrayList<Integer> numsOfM = new ArrayList<>();
    static int maxNum = 0;

    public static void main(String[] args) throws IOException {

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for(int i=1; i<=N; i++) {

            if(N % i == 0) {
                numsOfN.add(i);
            }
        }

        for(int i=1; i<=M; i++) {
            if(M % i == 0) {
                numsOfM.add(i);
            }
        }

        for(int num : numsOfN) {
            if(numsOfM.contains(num)) {
                maxNum = Math.max(maxNum, num);
            }
        }

        System.out.println(maxNum);
        System.out.println(maxNum * (N/maxNum) * (M/maxNum));
    }
}