package programmers;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class PG86971_TODO {

    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[][] adj;
    static int V, E;
    static ArrayList<Integer> track;

    public static void main(String[] args) {

        int n1 = 9;
        int[][] wires1 = {{1, 3}, {2, 3}, {3, 4}, {4, 5}, {4, 6}, {4, 7}, {7, 8}, {7, 9}};

        Solution sol = new Solution();

        int result = sol.solution(n1, wires1);

        System.out.println("result = " + result);

    }

    public static class Solution {
        public int solution(int n, int[][] wires) {
            int answer = -1;

            adj = new int[n + 1][n + 1];

            String str = Arrays.deepToString(wires);

            str = str.replace("[", "");
            str = str.replace("]", "");
            str = str.replace(" ", "");
            str = str.trim();
            String[] split = str.split(",");

            System.out.println("split = " + Arrays.toString(split));

            for(int i=0; i<split.length; i=i+2) {

                int di = Integer.parseInt(split[i]);
                int dj = Integer.parseInt(split[i + 1]);

                adj[di][dj] = 1;
                adj[dj][di] = 1;
            }

            for (int i = 0; i < adj.length; i++) {
                for (int j = 0; j < adj.length; j++) {
                    System.out.print(adj[i][j] + " ");
                }
                System.out.println();
            }

            return answer;
        }
    }
}
