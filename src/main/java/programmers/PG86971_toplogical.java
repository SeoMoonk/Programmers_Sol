package programmers;

import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class PG86971_toplogical {

    public static int solution(int n, int[][] wires) {

        int answer = 101;
        List<List<Integer>> adjList = new ArrayList<>();
        int[] inDegree = new int[n+1];      //진입차수 기록
        int[] rank = new int[n+1];          //각자 합산 공 무게 기록

        for(int i=0; i<=n; i++) {
            adjList.add(new ArrayList<>());
            rank[i] = 1;
        }

        for(int[] wire : wires) {

            int start = wire[0];
            int end = wire[1];

            adjList.get(start).add(end);
            adjList.get(end).add(start);

            inDegree[start]++;
            inDegree[end]++;
        }

        ArrayDeque<Integer> queue = new ArrayDeque<>();
        for(int i=1; i<=n; i++) {
            if(inDegree[i] == 1) {
                queue.addLast(i);
            }
        }

        while(!queue.isEmpty()) {

            int current = queue.removeFirst();
            answer = Math.min(answer, Math.abs(rank[current] * 2 - n));

            for(int dest : adjList.get(current)) {
                rank[dest] += rank[current];
                inDegree[dest]--;

                if(inDegree[dest] == 1) {
                    queue.addLast(dest);
                }
            }

        }

        return answer;
    }

    public static void main(String[] args) throws IOException {

        int n = 9;
        int[][] wires = {{1,3},{2,3},{3,4},{4,5},{4,6},{4,7},{7,8},{7,9}};

        int solution = solution(n, wires);

        System.out.println(solution);
    }
}
