package binarytree.maxofbinarytree;

public class Node {
    int data;
    Node left, right = null;

    public Node(int data) {
        this.data=data;
    }
}

class Solution {

    static int max(Node root) {
        if(root==null) return 0;

        int leftMax = max(root.left);
        int rightMax = max(root.right);

        int maxBetnLeftRight = Math.max(leftMax, rightMax);

        return Math.max(root.data, maxBetnLeftRight);
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(7);
        root.left.left = new Node(4);
        root.left.right = new Node(5);

        System.out.println(max(root));
    }
}