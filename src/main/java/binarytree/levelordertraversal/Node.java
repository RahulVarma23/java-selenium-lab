package binarytree.levelordertraversal;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Node {
    int data;
    Node left, right =null;

    Node (int data) {
        this.data=data;
    }
}

class Solution {

    static void levelOrderTraversal(Node root) {
        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()) {
            Node current = q.poll();
            System.out.print(current.data+ " ");

            if(current.left !=null) {
                q.add(current.left);
            }
            if(current.right !=null) {
                q.add(current.right);
            }
        }
    }

    static List<List<Integer>> levelOrderTraversal1(Node root) {

        List<List<Integer>> list = new java.util.ArrayList<>(List.of());
        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()) {
            Node current = q.poll();
            list.add(Arrays.asList(current.data));

            if(current.left !=null) {
                q.add(current.left);
            }
            if(current.right !=null) {
                q.add(current.right);
            }
        }

        return list;
    }



    public static void main(String[] args) {
        Node root = new Node(5);
        root.left=new Node(1);
        root.right=new Node(7);
        root.left.left=new Node(2);
        root.left.right=new Node(4);
        root.left.right.left=new Node(3);
        root.left.right.right=new Node(6);

        levelOrderTraversal(root);
    }
}
