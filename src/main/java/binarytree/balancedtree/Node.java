package binarytree.balancedtree;

public class Node {

    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
    }
}

class Solution {

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left=new Node(2);
        root.right=new Node(5);
        root.left.left=new Node(3);
        root.left.right=new Node(4);
        root.right.left= new Node(6);
        root.right.right=new Node(7);

        System.out.println(balancedTree(root));
    }

    private static boolean balancedTree(Node root) {
        /* A binary tree is balanced if:
        For every node: |height(left) - height(right)| <= 1
        And both subtrees are balanced
         */

        return checkHeight(root) !=-1;
    }

    private static int checkHeight(Node root) {
        if(root==null) {
            return 0;
        }

        int left = checkHeight(root.left);
        if(left==-1) return -1;

        int right = checkHeight(root.right);
        if(right==-1) return -1;

        if(Math.abs(left-right)>1) return -1;

        return 1+Math.max(left, right);
    }
}