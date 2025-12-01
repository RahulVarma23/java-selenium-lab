package imp.heap;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class KthLargestAndSmallestElementInArray {
    public static void main(String[] args) {
        int [] arr = {3,2,1,5,6,4};
        System.out.println(findKthLargestElementBySorting(arr, 2));
        System.out.println(findKthLargestElementByMinHeap(arr, 2));
        System.out.println(findKthSmallestElementByMaxHeap(arr, 3));
    }

    //sorting . overall TC : O(nlogn) for sorting
    private static int findKthLargestElementBySorting(int [] arr, int k) {
        Arrays.sort(arr);

        return arr[arr.length-k];
    }

    //TC: 0(nlog(k)) better than sorting, SC: O(k)
    //Heap insertion = O(log k), since heap size ≤ k, removal -> O(log k), loop -> runs n times
    private static int findKthLargestElementByMinHeap(int [] arr, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for(int num : arr) {
            minHeap.add(num);
            if(minHeap.size()>k) {
                minHeap.poll(); // remove the smallest
            }
        }
        return !minHeap.isEmpty() ? minHeap.peek(): -1;
    }

    //TC: 0(nlog(k)) better than sorting, SC: O(k)
    //Heap insertion = O(log k), since heap size ≤ k, removal -> O(log k), loop -> runs n times
    private static int findKthSmallestElementByMaxHeap(int [] arr, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for(int num : arr) {
            maxHeap.add(num);
            if(maxHeap.size()>k) {
                maxHeap.poll(); // remove the largest
            }
        }
        return !maxHeap.isEmpty() ? maxHeap.peek(): -1;
    }
}
