package imp.heap;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKSortedLists {

     class ListNode {
      int val;
      ListNode next;
      ListNode(int val) {
          this.val = val;
      }
  }

   public ListNode mergeKLists(ListNode[] lists) {
       if(lists == null || lists.length == 0) return null;

       if(lists.length==1) return lists[0];

       int start =0;
       int end = lists.length -1;

       return devideAndConquer(lists, start, end);
   }

   //TC: O(N log k) , SC: O(1) ignoring recursion stack
    //N = total number of nodes, k = number of lists
    //how TC is derived?
    //At each level of recursion, we are merging all nodes once, which takes O(N) time.
    //The number of levels in the recursion tree is log k, because we are dividing the k lists in half at each level.
    //Therefore, the total time complexity is O(N log k).
    private ListNode devideAndConquer(ListNode[] lists, int start, int end) {
         if(start==end) return lists[start];

         int mid = start + (end - start)/2;

         ListNode left = devideAndConquer(lists, start, mid);
         ListNode right = devideAndConquer(lists, mid+1, end);
         return mergeTwoLists(left, right);
    }

    //tc: O(n+m), sc: O(1)
    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0); //dummy node
        ListNode current = dummy; //pointer to build the merged list

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                current.next = l1;
                l1 = l1.next;
            } else {
                current.next = l2;
                l2 = l2.next;
            }
            current = current.next;
        }
        if (l1 != null) {
            current.next = l1;
        }
        if (l2 != null) {
            current.next = l2;
        }
        return dummy.next; //return merged list, skipping dummy node
    }

    public ListNode mergeKListsUsingMinHeap(ListNode[] lists) {
         if(lists.length==0 || lists==null) return null;
         if(lists.length==1) return lists[0];

         //minHeap based on value of nodes
        PriorityQueue <ListNode> minHeap = new PriorityQueue<>(
                Comparator.comparingInt(a -> a.val)
        );

        // Add all first nodes of each list into the heap
        for (ListNode node : lists) {
            if (node != null) {
                minHeap.offer(node);
            }
        }

        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        while(!minHeap.isEmpty()) {
            ListNode smallest = minHeap.poll();        //poll smallest head from all nodes
            current.next = smallest;                  //attach to current
            current = current.next;                   //move current

            if(smallest.next!=null) {                //add smallest next to minHeap again and continue
                minHeap.add(smallest.next);
            }
        }
         return dummy.next;
    }

    public static void main(String[] args) {

        MergeKSortedLists solver = new MergeKSortedLists();

        // Create list 1: 1 -> 4 -> 5
        MergeKSortedLists.ListNode l1 = solver.new ListNode(1);
        l1.next = solver.new ListNode(4);
        l1.next.next = solver.new ListNode(5);

        // Create list 2: 1 -> 3 -> 4
        MergeKSortedLists.ListNode l2 = solver.new ListNode(1);
        l2.next = solver.new ListNode(3);
        l2.next.next = solver.new ListNode(4);

        // Create list 3: 2 -> 6
        MergeKSortedLists.ListNode l3 = solver.new ListNode(2);
        l3.next = solver.new ListNode(6);

        // Array of list heads
        MergeKSortedLists.ListNode[] lists = new MergeKSortedLists.ListNode[] { l1, l2, l3 };

        // Call the merge function
        MergeKSortedLists.ListNode merged = solver.mergeKListsUsingMinHeap(lists);

        // Print merged list
        printList(merged);
    }

    private static void printList(MergeKSortedLists.ListNode node) {
        while (node != null) {
            System.out.print(node.val);
            if (node.next != null) System.out.print(" -> ");
            node = node.next;
        }
        System.out.println();
    }
}
