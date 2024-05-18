package bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class BJ1927 {

    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    static int N;
    static final StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        N = Integer.parseInt(br.readLine());

        for(int i=0; i<N; i++) {
            int input = Integer.parseInt(br.readLine());
            solution(input);
        }

        System.out.println(sb.toString());
    }

    static void solution(int input) {

        if(input == 0 && minHeap.size() == 0) {
            sb.append("0" + "\n");
        } else if(input == 0) {
            sb.append(minHeap.poll() + "\n");
        } else {
            minHeap.offer(input);
        }
    }
}
