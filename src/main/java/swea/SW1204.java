package swea;

import java.util.*;
import java.io.*;

public class SW1204 {

    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static final StringBuilder sb = new StringBuilder();
    static int T;
    static Map<Integer, Integer> map = new HashMap<>();

    public static void main(String[] args) throws IOException {

        T = Integer.parseInt(br.readLine());

        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < T; i++) {

            int testNum = Integer.parseInt(br.readLine());

            String[] scores = sc.nextLine().split(" ");

            st = new StringTokenizer(br.readLine());

            for (String score : scores) {
                int num = Integer.parseInt(score);
                map.put(num, map.getOrDefault(num, 0) + 1);
            }

            Stack<Integer> stack = new Stack<>();

            Integer maxValue = Collections.max(map.values());

            for (int key : map.keySet()) {

                if (map.get(key) == maxValue) {
                    stack.add(key);
                }
            }

            System.out.printf("#%d %d", testNum, stack.pop());
        }
    }
}
