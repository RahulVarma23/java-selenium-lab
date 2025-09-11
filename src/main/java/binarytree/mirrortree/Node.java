package binarytree.mirrortree;

public class Node {
    
    int val;
    Node left, right;
    
    Node(int val) {
        this.val = val;
    }
}

class Solution {

    public static Node mirrorTree(Node root) {
        if(root==null) return null;

        // Recursively mirror left and right subtrees
        Node leftMirror = mirrorTree(root.left);
        Node rightMirror = mirrorTree(root.right);

        // Swap left and right
        root.left = rightMirror;
        root.right = leftMirror;

        return root;
    }

    public static void inOrder(Node root) {
        if(root==null) return ;

        inOrder(root.left);
        System.out.print(root.val+" ");
        inOrder(root.right);
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(7);
        root.left.left = new Node(4);
        root.left.right = new Node(5);

        Node ans = mirrorTree(root);
        inOrder(ans);
    }
}
