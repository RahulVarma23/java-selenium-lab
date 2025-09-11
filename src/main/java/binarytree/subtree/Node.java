package binarytree.subtree;

public class Node {

    int data;
    Node left, right;

    public Node(int data) {
        this.data = data;
    }
}

class Solution {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);


        Node subRoot = new Node(2);
        subRoot.left = new Node(4);
        subRoot.right = new Node(5);

        System.out.println(isSubTree(root, subRoot));
    }

    private static boolean isSubTree(Node root, Node subRoot) {
        if(root==null) return false;

        if(isSameTree(root, subRoot)) return true;

        return isSubTree(root.left,subRoot) || isSubTree(root.right, subRoot);
    }

    private static boolean isSameTree(Node p , Node q) {
        if(p==null && q==null) return true;

        if(p==null || q==null) return false;

        if(p.data !=q.data) return false;

        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
