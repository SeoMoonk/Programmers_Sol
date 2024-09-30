package bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BJ1546 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N;
    static ArrayList<Double> scoreList = new ArrayList<>();
    static double sum = 0;

    public static void main(String[] args) throws IOException {

        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        for(int i=0; i<N; i++) {
            double score = Double.parseDouble(st.nextToken());
            scoreList.add(score);
        }

        scoreList.sort(Comparator.naturalOrder());

        for(int i=0; i<N; i++) {
            double fixedScore = (scoreList.get(i) / scoreList.get(N-1)) * 100;
            sum += fixedScore;
        }

        System.out.println(sum / N);
    }
}