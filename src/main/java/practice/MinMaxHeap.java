package practice;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MinMaxHeap {

    static PriorityQueue<Integer> minHeap = new PriorityQueue<>();  //최소힙

    public static void main(String[] args) {

        minHeap.offer(1);
        minHeap.offer(7);
        minHeap.offer(5);
        minHeap.offer(4);

        System.out.println(minHeap);

        int num = minHeap.poll();
        System.out.println(num);
        System.out.println(minHeap);

        System.out.println(minHeap.peek());
        System.out.println(minHeap);

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());

        int size = minHeap.size();

        for(int i=0; i<size; i++) {
            maxHeap.offer(minHeap.poll());
        }

        System.out.println(maxHeap);

    }

}
