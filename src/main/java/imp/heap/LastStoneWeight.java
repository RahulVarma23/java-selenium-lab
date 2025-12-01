package imp.heap;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class LastStoneWeight {

    /*
    You are given an array of integers stones where stones[i] represents the weight of the ith stone.
We want to run a simulation on the stones as follows:
At each step we choose the two heaviest stones, with weight x and y and smash them togethers
If x == y, both stones are destroyed
If x < y, the stone of weight x is destroyed, and the stone of weight y has new weight y - x.
Continue the simulation until there is no more than one stone remaining.
     */

    public static void main(String[] args) {
        int[] stones = {2,7,4,1,8,1};
        System.out.println(lastStoneWeight(stones)); // Output: 1
    }

    private static int lastStoneWeight(int[] stones) {
        if(stones.length ==1 ) return stones[0];

        if(stones.length==0) return 0;

        if(stones.length==2) return Math.abs(stones[0]-stones[1]);

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for(int stone : stones) {
            maxHeap.add(stone);
        }

        while(maxHeap.size()>1) {
            int a = maxHeap.poll(); //pick largest
            int b = maxHeap.poll(); //pick 2nd largest

            maxHeap.add(Math.abs(a-b)); //add diff
        }
        return maxHeap.peek();
    }
}
