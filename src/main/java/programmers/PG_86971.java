package programmers;

import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;

public class PG_86971 {

    static int[][] arr;
    static boolean[] visited;

    public static int solution(int n, int[][] wires) {

        int answer = 101;

        arr = new int[n+1][n+1];

        for(int[] wire : wires) {

            int start = wire[0];
            int end = wire[1];

            arr[start][end] = 1;
            arr[end][start] = 1;
        }

        for(int[] wire : wires) {

            int start = wire[0];
            int end = wire[1];

            arr[start][end] = 0;
            arr[end][start] = 0;

            //n이 9개일 때, 두 개로 나눴을 때의 차이가 가장 작은 경우

            int a = n - dfs(n,arr);
            int b = n - a;

            int result = Math.abs(a-b);

            if(result == 1 || result == 0) {
                return result;
            }

            arr[start][end] = 1;
            arr[end][start] = 1;
            answer = Math.min(answer, result);
        }

        return answer;
    }

    static int dfs(int n, int[][] arr) {

        ArrayDeque<Integer> stack = new ArrayDeque<>();
        ArrayList<Integer> track = new ArrayList<>();
        visited = new boolean[n+1];

        stack.addLast(1);

        while(!stack.isEmpty()) {

            Integer current = stack.removeLast();

            if(!visited[current]) {
                visited[current] = true;
                track.add(current);
            }

            for(int i=1; i<n+1; i++) {
                if(arr[current][i] == 1 && !visited[i]) {
                    stack.addLast(i);
                }
            }
        }

        return track.size();
    }

    public static void main(String[] args) throws IOException {

        int n = 9;
        int[][] wires = {{1,3},{2,3},{3,4},{4,5},{4,6},{4,7},{7,8},{7,9}};

        int solution = solution(n, wires);

        System.out.println(solution);
    }
}
