package imp.binarytree.traversals;

import java.util.List;

public class Node {

    int data;
    Node left, right =null;

    public Node(int data) {
        this.data=data;
    }
}

class Solution {
    public static void main(String[] args) {
        Node root = new Node(1);

        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

//        List<Integer> preOrderList = new ArrayList<>();
//        collectPreOrder(root, preOrderList);
//        System.out.println("Pre-order traversal list:");
//        System.out.println(preOrderList);

        System.out.println("-----Inorder traversal----");
        inOrder(root);
        System.out.println();
        System.out.println("-----preorder traversal----");
        preOrder(root);
        System.out.println();
        System.out.println("-----postorder traversal----");
        postOrder(root);
    }

    static void inOrder(Node root) {
        if(root==null) return;

        inOrder(root.left);
        System.out.print(root.data+" ");
        inOrder(root.right);
    }

    static void preOrder(Node root) {
        if(root==null) return;

        System.out.print(root.data+" ");
        preOrder(root.left);
        preOrder(root.right);
    }

    static void postOrder(Node root) {
        if(root==null) return;

        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data+" ");
    }

    static void collectPreOrder(Node root, List<Integer> list) {
        if (root == null) return;

        list.add(root.data);
        collectPreOrder(root.left, list);
        collectPreOrder(root.right, list);
    }
}
