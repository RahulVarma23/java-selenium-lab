package binarytree.rightviewbinarytree;

import java.util.ArrayList;
import java.util.List;

public class Node {

    int data;
    Node left, right;

    Node (int data) {
        this.data=data;
    }
}

class Solution {

    //we are using reverse preorder mechanism
    //preorder -> root -> left -> right
    //reverse preorder -> root -> right -> left
    private static void rightViewTreeUtil(Node root, List<Node> list, int level) {
        if(root==null) return;

        //We only add the first node we visit at a level.
        //Since we traverse right first, the first node we see at each level is the rightmost.
        if(level == list.size()) {
            list.add(level, root);
        }

        rightViewTreeUtil(root.right, list, level+1);
        rightViewTreeUtil(root.left, list, level+1);
    }

    private static void rightViewTree(Node root) {
        List<Node> list = new ArrayList<>();
        rightViewTreeUtil(root, list, 0);

        list.forEach(curr -> System.out.print(curr.data+" "));
    }

    public static void main(String[] args) {
        Node root = new Node(5);
        root.left=new Node(1);
        root.right=new Node(7);
        root.left.left=new Node(2);
        root.left.right=new Node(4);
        root.left.right.left= new Node(3);
        root.left.right.right=new Node(6);

        rightViewTree(root);
    }
}
