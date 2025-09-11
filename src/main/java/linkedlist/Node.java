package linkedlist;

import java.util.*;

public class Node {

    int data;
    Node next;
    Node prev;

    public Node(int data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}

class MiddleElement {

    private static Node getMiddleElement(Node head) {
        Node slow = head;
        Node fast = head;

        while(fast!=null && fast.next!=null) {
            slow = slow.next;
            fast= fast.next.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(6);
        head.next.next.next.next.next.next = new Node(7);
        head.next.next.next.next.next.next.next = new Node(8);
        System.out.println(getMiddleElement(head).data);
    }
}

class Cycle {

    private static boolean hasCycle(Node head) {
        if (head == null || head.next == null) {
            return false;
        }
        Node slow = head;
        Node fast = head;

        while(fast!=null && fast.next !=null) {
            slow = slow.next;
            fast = fast.next.next;

           if(slow==fast) {
               return true;
           }
        }
        return false;
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = head;

        System.out.println(hasCycle(head));
    }
}

class Palindrome {

    private static boolean isPolindrome(Node head) {
        if(head==null || head.next==null) {
            return true;
        }

        StringBuilder sb = new StringBuilder();

        while(head != null) {
            sb.append(head.data);
            head = head.next;
        }

        String original = sb.toString();
        String reversed = sb.reverse().toString();

        return original.equals(reversed);
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(2);
        head.next.next.next.next = new Node(1);

        System.out.println(isPolindrome(head));
    }
}

class NodeFromEnd {

    private static int findNthNodeFromEnd(Node head, int n) {
        int i=0;
        Node fast=head;
        Node slow=head;
        while(fast!=null && i<n) {
            fast= fast.next;
            i++;
        }

        while(fast!=null) {
            fast= fast.next;
            slow = slow.next;
        }

        assert slow != null;
        return slow.data;
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        System.out.println(findNthNodeFromEnd(head, 4));
        System.out.println(findNthNodeFromEnd(head, 2));
    }
}

class ReverseLinkedList {
    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        Node ans = reverseLL(head);

        while(ans!=null) {
            System.out.print(ans.data+"->");
            ans = ans.next;
        }
    }

    private static Node reverseLL(Node head) {
        if(head==null || head.next==null) {
            return head;
        }

        Node current = head;
        Node prev = null;
        Node temp;

        while(current !=null) {
            temp = current.next;   //store next node
            current.next = prev;   //reverse the link
            prev = current;        // move prev forward
            current = temp;        //move current forward
        }
        return prev;
    }
}

class  SortLinkedList{

    private static Node sort(Node head) {
        Node temp = head;
        List<Integer> list = new ArrayList<>();

        while(temp !=null) {
            list.add(temp.data);
            temp = temp.next;
        }

        Collections.sort(list);
        temp = head;

        for(int n : list) {
            temp.data = n;
            temp = temp.next;
        }
        return head;
    }

    public static void main(String[] args) {
        Node head = new Node(3);
        head.next = new Node(2);
        head.next.next = new Node(1);
        head.next.next.next = new Node(5);
        head.next.next.next.next = new Node(4);

        Node ans = sort(head);

        while(ans!=null) {
            System.out.print(ans.data+"->");
            ans = ans.next;
        }
    }
}

class PairsWithSum {
    //find pairs with target sum from given sorted doubly linked list
    public static void main(String[] args) {
        // build DLL properly
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.prev = head;

        head.next.next = new Node(3);
        head.next.next.prev = head.next;

        head.next.next.next = new Node(4);
        head.next.next.next.prev = head.next.next;

        head.next.next.next.next = new Node(5);
        head.next.next.next.next.prev = head.next.next.next;

        System.out.println(findPairsWithSumFromSortedLL(head, 5));
    }

    private static Node findTail(Node head) {
        Node tail=head;
        while(tail!=null && tail.next !=null) {
            tail = tail.next;
        }
        return tail;
    }

    private static List<List<Integer>> findPairsWithSumFromSortedLL(Node head, int target) {
        Node left = head;
        Node right = findTail(head);

        List<List<Integer>> ans = new ArrayList<>();

        while(left.data<right.data) {

            if(left.data + right.data==target) {
                ans.add(Arrays.asList(left.data, right.data));
                left=left.next;
                right = right.prev;
            }else if(left.data + right.data<target) {
                left=left.next;
            }else {
                right=right.prev;
            }
        }
        return ans;
    }
}

class MergeSortedLL {

    //TC -> O(N+M) each node from both list visited once.
    //SC -> O(1)
    private static Node mergeTwoSortedLinkedList(Node l1, Node l2) {

        // Dummy node to serve as the start of the merged list
        Node dummy = new Node(0);
        Node current = dummy;

        // Traverse both lists while neither is exhausted
        while(l1!=null && l2!=null) {
            //// Pick the smaller node and link it to current.next
            if(l1.data<=l2.data) {
                current.next = l1;
                l1=l1.next;
            }else {
                current.next = l2;
                l2=l2.next;
            }
            current = current.next;
        }

        // At this point, one of the lists is null
        //Link the remaining non-null list to the merged result
        if(l1!=null) {
            current.next = l1;
        }else {
            current.next = l2;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(1);
        head.next.next = new Node(3);
        head.next.next.next = new Node(5);
        head.next.next.next.next = new Node(7);

        Node head1 = new Node(2);
        head1.next = new Node(3);
        head1.next.next = new Node(4);
        head1.next.next.next = new Node(4);
        head1.next.next.next.next = new Node(6);

        Node ans = mergeTwoSortedLinkedList(head, head1);

        while(ans!=null) {
            System.out.print(ans.data+"->");
            ans = ans.next;
        }
    }
}

class RotateLinkedList {

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        Node ans = rotate(head, 2);

        while(ans!=null) {
            System.out.print(ans.data+"->");
            ans = ans.next;
        }
    }

    private static Node findNthNode(Node temp, int k) {
        int i = 1;
        while(temp !=null) {
            if(i==k) {
                return temp;
            }
            i++;
            temp = temp.next;
        }
        return temp;
    }

    private static Node rotate(Node head, int k) {
        if(head ==null || head.next==null || k==0) {
            return head;
        }
        int len = 1;
        Node temp = head;
        while(temp.next!=null) {
            temp=temp.next;
            len++;
        }

        if(k%len==0) {
            return head;
        }

        temp.next=head;

        Node newLastNode = findNthNode(head, len-k);

        head = newLastNode.next;
        newLastNode.next=null;

        return head;
    }
}

class RemoveNthNodeFromEnd {

    private static Node removeNodeFromEnd(Node head, int n) {
       //1 2 3 4 5

        int i=0;

       Node fast = head;
       Node slow = head;

       //move fast loop n+1 steps
       while(fast!=null && i<=n) {
           fast = fast.next;
           i++;
       }

       while(fast!=null) {
           fast = fast.next;
           slow = slow.next;
       }

       //slow is at nth -1 node. fast will be at null at the end of 2nd loop
       //skip nth node
        slow.next= slow.next.next;

       return head;
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        Node ans = removeNodeFromEnd(head, 2);

        while(ans!=null) {
            System.out.print(ans.data+"->");
            ans = ans.next;
        }
    }
}

class AddTwoNumbers {
    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);

        Node head1 = new Node(4);
        head1.next = new Node(5);
        head1.next.next = new Node(7);

        Node ans = addTwoNums(head, head1);

        while(ans!=null) {
            System.out.print(ans.data+"->");
            ans = ans.next;
        }
    }

    // [1,2,3] , [4,5,7] -> [5,7,0,1]
    private static Node addTwoNums(Node l1, Node l2) {
        Node dummy = new Node(0);
        Node curr = dummy;

        int carry =0;

        //run the loop if any of the list is not null or carry is greater than 0
        while(l1!=null || l2!=null || carry>0) {
            //if l1 is present then add to sum . if l2 is present then add to sum
            int val1 = (l1!=null) ? l1.data:0;
            int val2 = (l2!=null) ? l2.data:0;
            int sum = val1+val2+carry;

            int digit = sum%10;
            carry = sum/10;

            //add new node with sum digit
            curr.next = new Node(digit);

            //move curr forward
            curr = curr.next;

            //move l1 and l2 forward
            if(l1!=null) l1=l1.next;
            if(l2!=null) l2=l2.next;
        }

//        if(carry>0) {
//            curr.next = new Node(carry);
//        }

        return dummy.next;
    }
}

class RemoveDuplicatesFromSortedLL {

    //TC:0(n) , SC: O(1)
    private static Node removedDuplicatesFromSortedLL(Node head) {
        //1 2 2 3
        Node temp = head;

        while(temp !=null && temp.next!=null) {
            if(temp.data == temp.next.data) {
                temp.next=temp.next.next;
            }else {
                temp = temp.next;
            }
        }
        return head;
    }

    private static List <Integer> findDuplicatesFromSortedLL(Node head) {
        //1 2 2 3
        Node temp = head;

        List <Integer> list = new ArrayList<>();

        while(temp !=null && temp.next!=null) {
            if(temp.data == temp.next.data) {
                list.add(temp.data);
                //skip all nodes with duplicates
                int val = temp.data;
                while(temp!=null && temp.data==val) {
                    temp=temp.next;
                }
            }else {
                temp = temp.next;
            }
        }
        return list;
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(2);
        head.next.next.next = new Node(2);
        head.next.next.next.next = new Node(3);
        head.next.next.next.next.next = new Node(3);
        head.next.next.next.next.next.next = new Node(3);

        System.out.println(findDuplicatesFromSortedLL(head));

        Node ans = removedDuplicatesFromSortedLL(head);

        while(ans!=null) {
            System.out.print(ans.data+"->");
            ans = ans.next;
        }
    }
}

class RemoveDuplicatesFromUnsortedLL {

    //TC:O(n), SC:O(n), another approach would be sort list and remove duplicates(TC:O(nlogn), SC: O(logn))
    private static Node removedDuplicatesFromUnSortedLL(Node head) {
        Node temp = head;
        Map<Integer, Boolean> map = new HashMap<>();
        Node prev=null;

        while(temp !=null) {
            if(map.containsKey(temp.data)) {
                prev.next= temp.next;
            }else {
                map.put(temp.data, true);
                prev = temp;
            }
            temp = temp.next;
        }
        return head;
    }

    public static void main(String[] args) {
        Node head = new Node(5);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(2);
        head.next.next.next.next = new Node(3);
        head.next.next.next.next.next = new Node(3);

        Node ans = removedDuplicatesFromUnSortedLL(head);

        while(ans!=null) {
            System.out.print(ans.data+"->");
            ans = ans.next;
        }
    }
}

class ReverseNodesInGroups {

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(6);
        head.next.next.next.next.next.next = new Node(7);

        Node ans = reverseKGroup(head, 3);

        while(ans!=null) {
            System.out.print(ans.data+"->");
            ans = ans.next;
        }
    }

    private static Node reverseKGroup(Node head, int k) {
        Node temp=head;

        Node prevNode = null;
        Node nextNode;

        while(temp!=null) {
            Node kthNode = findKthNode(temp, k); //find kth node from current temp
            if(kthNode==null) break;             //if less than k nodes remaining, no need to reverse

            nextNode = kthNode.next;             //store next node after kth node
            kthNode.next=null;                   //break the link to form a separate list for reversal
            reverse(temp);                       //reverse the k nodes

            if(temp==head) {                    //if first group, then update head
                head=kthNode;
            }else {
                prevNode.next=kthNode;          //link previous group with current reversed group
            }

            temp.next = nextNode;              //link current group with next group

            prevNode=temp;                    //move prevNode to end of current group
            temp=nextNode;                    //move temp to next group
        }
        return head;
    }

    private static Node findKthNode(Node temp, int k) {
        k--;
        while(temp!=null && k>0) {
            temp=temp.next;
            k--;
        }
        return temp;
    }

    private static Node reverse(Node node) {
        Node curr = node;
        Node prev =null;
        Node temp;

        while(curr!=null) {
            temp = curr.next;
            curr.next=prev;
            prev=curr;
            curr=temp;
        }
        return prev;
    }
}