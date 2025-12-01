package imp.heap;

import java.util.Arrays;
import java.util.PriorityQueue;

public class KClosestPointsToOrigin {

    public static void main(String[] args) {
        int [][] arr = {{0,2},{2,0},{2,2}};
        int k =2;
       int [] [] result =  (kClosest(arr, k));

        System.out.println(Arrays.deepToString(result));
    }

    private static int distance(int [] p) {
        return p[0]*p[0] + p[1]*p[1];
    }


    //distance = x² + y²   (no need to take sqrt)
    public static int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(
                (a, b) -> distance(b) - distance(a)
        );

        for(int[] point: points) {
            maxHeap.add(point);
            if(maxHeap.size()>k) {
                maxHeap.poll(); //remove farthest
            }
        }

        int [][] result = new int[k][2];

        int i=0;

        while(!maxHeap.isEmpty()) {
            result[i] = maxHeap.poll();
            i++;
        }

        return result;
    }
}
