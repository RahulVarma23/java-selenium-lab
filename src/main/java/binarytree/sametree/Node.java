package binarytree.sametree;

public class Node {
    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
    }
}

class Solution {

    public static void main(String[] args) {
        Node root1 = new Node(1);
        root1.left=new Node(2);
        root1.right=new Node(5);
        root1.left.left=new Node(3);
        root1.left.right=new Node(4);
        root1.right.left= new Node(6);
        root1.right.right=new Node(7);

        Node root2 = new Node(1);
        root2.left=new Node(2);
        root2.right=new Node(5);
        root2.left.left=new Node(3);
        root2.left.right=new Node(4);
        root2.right.left= new Node(6);
        root2.right.right=new Node(7);

        System.out.println(sameTree(root1, root2));
    }

    private static boolean sameTree(Node p, Node q) {
        /*
        At every node, check:
        If both nodes are null → ✅ same
        If one is null and the other is not → ❌ different
        If values differ → ❌ different Otherwise, recursively compare:Left subtrees,Right subtrees
         */

        if(p==null && q==null) return true;

        if(p==null || q==null) return false;

        if(p.data != q.data) return false;

        return sameTree(p.left, q.left) && sameTree(p.right, q.right);
    }
}