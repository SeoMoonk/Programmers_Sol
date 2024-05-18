package programmers;

import java.util.PriorityQueue;

public class PG255905 {

    public static int solution(int[] ability, int number) {

        int answer = 0;

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for(int stat : ability) {
            minHeap.add(stat);
        }

        for(int i=0; i<number; i++) {

            int first = minHeap.poll();
            int second = minHeap.poll();

            minHeap.offer(first + second);
            minHeap.offer(first + second);
        }

        while(!minHeap.isEmpty()) {
            int num = minHeap.poll();
            answer += num;
        }

        return answer;
    }

    public static void main(String[] args) {

        int[] ability = {10, 3, 7, 2};
        int number = 2;

        int solution = solution(ability, number);
        System.out.println(solution);
    }

}
