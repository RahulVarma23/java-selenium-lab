package binarytree.invertbinarytree;

import java.util.*;

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

        Node ans = invertTree(root);

        printLevelOrder(ans);
    }

    private static Node invertTree(Node root) {
        if (root==null) return null;

        Node temp = root.left;

        root.left = invertTree(root.right);
        root.right = invertTree(temp);

        return root;
    }

    private static void printLevelOrder(Node root) {
        if (root == null) return;

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node current = queue.poll();
            System.out.print(current.data + " ");

            if (current.left != null) queue.add(current.left);
            if (current.right != null) queue.add(current.right);
        }
    }
}