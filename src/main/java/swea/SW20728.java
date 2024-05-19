package swea;

import java.util.*;
import java.io.*;

public class SW20728 {

    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static final StringBuilder sb = new StringBuilder();
    static int T;
    static int N;		//총 주머니의 갯수
    static int K;		//나눠줄 주머니의 갯수
    static ArrayList<Integer> arr;	//주머니 별 사탕의 갯수
    static int result;

    public static void main(String[] args) throws IOException {

        T = Integer.parseInt(br.readLine());

        for(int i=0; i<T; i++) {

            st = new StringTokenizer(br.readLine());

            result = 0;
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            arr = new ArrayList<>();

            st = new StringTokenizer(br.readLine());

            for(int j=0; j<N; j++) {
                arr.add(Integer.parseInt(st.nextToken()));
            }

            arr.sort(Collections.reverseOrder());

            solution(arr, i+1);
        }
    }

    static void solution(ArrayList<Integer> arr, int testIdx) {

        //나눠 준 주머니 가운데 사탕의 개수가 가장 많은 것과 가장 적은 것의 사탕 개수 차이를 최소화

        int size = arr.size();
        int result = Integer.MAX_VALUE;

        for(int i=0; i<N-K+1; i++) {
            int diff = arr.get(i) - arr.get(i+K-1);
            result = Math.min(result, diff);
        }

        System.out.printf("#%d %d\n", testIdx, result);
    }
}
