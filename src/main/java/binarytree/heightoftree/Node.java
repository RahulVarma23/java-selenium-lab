package binarytree.heightoftree;

class Node {
    int data;
    Node left , right =null;

    public Node(int data) {
        this.data=data;
    }
}

class Solution {

    static int height(Node root) {
        if(root==null) return 0;

       return  Math.max(height(root.left), height(root.right)) +1;
    }

    public static void main(String[] args) {
        Node root = new Node(1);

        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
       // root.left.right.right = new Node(6);

        System.out.println(height(root));
    }
}
