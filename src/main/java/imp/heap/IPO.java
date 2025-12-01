package imp.heap;

import java.util.Collections;
import java.util.PriorityQueue;

public class IPO {
    public static void main(String[] args) {
       int k = 3,  w = 0; int [] profits = {1,4,2,3}; int [] capital = {0,3,1,1};
        System.out.println(findMaximizedCapital(k, w, profits, capital));
    }

    private static int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int n = profits.length;

        // Min-heap based on required capital
        PriorityQueue<int[]> minCapHeap = new PriorityQueue<>(
                (a,b)-> a[0]-b[0]      //capital asc
        );

        PriorityQueue<Integer> maxProfitHeap= new PriorityQueue<>(Collections.reverseOrder());

        // Fill min-heap with all projects: [capital, profit]
        for(int i=0;i<n;i++) {
            minCapHeap.add(new int[]{capital[i], profits[i]});
        }

        // Choose up to k projects
        for(int i=0;i<k;i++) {
            // Add all projects we can afford to the maxHeap
            while(!minCapHeap.isEmpty() && minCapHeap.peek()[0]<=w) {
                int profilt = minCapHeap.poll()[1]; //get profit
                maxProfitHeap.add(profilt);
            }

            // If nothing is affordable, return current capital
            if(maxProfitHeap.isEmpty()) {
                return w;
            }

            // Do the most profitable affordable project
            w+=maxProfitHeap.poll();
        }



        return w;
    }
}
