package programmers;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class PG86971_TODO {

    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[][] adjArr;
    static int V, E;
    static boolean[] visited;
    static int result;

    public static void main(String[] args) {

        int n1 = 9;
        int[][] wires1 = {{1, 3}, {2, 3}, {3, 4}, {4, 5}, {4, 6}, {4, 7}, {7, 8}, {7, 9}};

        Solution sol = new Solution();

        int solResult = sol.solution(n1, wires1);

        System.out.println("result = " + solResult);

    }

    public static class Solution {
        public int solution(int n, int[][] wires) {
            int answer = -1;

            V = n;
            E = wires.length;

            adjArr = new int[n+1][n+1];
            visited = new boolean[n+1];

            //인접행렬 만들기
            for(int i=0; i<E; i++) {
                int front = wires[i][0];
                int end = wires[i][1];

                adjArr[front][end] = 1;
                adjArr[end][front] = 1;
            }

            for(int i=0; i< E; i++) {

                //주어진 트리 정보에서 간선을 하나씩 끊어보기
                int target1 = wires[i][0];
                int target2 = wires[i][1];

                adjArr[target1][target2] = 0;
                adjArr[target2][target1] = 0;

                //dfs 순회하여 이번에 얻은 값 갱신 (최솟값으로)
                answer = Math.min(answer, dfs(1));

                //다시 되돌려 놓기
                adjArr[target1][target2] = 1;
                adjArr[target2][target1] = 1;
                result = 0;

            }

            return answer;
        }

        public int dfs(int start) {

            //V(노드의 갯수) = n (9개)
            //E(간선의 갯수) = wires.length(8개)

            if(!visited[start]) {
                visited[start] = true;
            }

            for(int destination = 1; destination < V+1; destination++) {

                if (!visited[destination] && adjArr[start][destination] == 1) {
                    dfs(destination);
                    result++;
                }
            }

            return result;
        }
    }
}
