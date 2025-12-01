package imp.heap;

import java.util.Collections;
import java.util.PriorityQueue;

public class HeapDemo {

    public static void main(String[] args) {

        //creating minHeap and maxHeap
        PriorityQueue<Integer> minHeap  = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap  = new PriorityQueue<>(Collections.reverseOrder());

        //add elements to minHeap
        minHeap.add(20);
        minHeap.add(10);
        minHeap.add(30);
        minHeap.add(17);
        minHeap.add(40);

        //add elements to maxHeap
        maxHeap.add(20);
        maxHeap.add(10);
        maxHeap.add(30);
        maxHeap.add(17);
        maxHeap.add(40);

        //peek elements
        System.out.println("Min: "+minHeap.peek());
        System.out.println("Max: "+maxHeap.peek());

        minHeap.poll();
        maxHeap.poll();

        System.out.println("After polling: Min: "+minHeap.peek());
        System.out.println("After pooling: Max: "+maxHeap.peek());

    }
}
