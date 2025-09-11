package binarytree.sizeoftree;

public class Node {
    int data ;
    Node left, right = null;

    public Node(int data) {
        this.data=data;
    }
}

class Solution {

    //total no of nodes in tree
    static int size (Node root) {
        if(root==null)
            return 0;

        return size(root.left) + size(root.right) + 1;
    }

    public static void main(String[] args) {
            Node root = new Node(1);

            root.left = new Node(2);
            root.right = new Node(3);
            root.left.left = new Node(4);
            root.left.right = new Node(5);

            System.out.println(size(root));
    }
}
