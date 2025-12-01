package imp.binarytree.leftviewbinarytree;

import java.util.ArrayList;
import java.util.List;

public class Node {
    int data;
    Node left, right = null;

    Node(int data) {
        this.data = data;
    }
}

class Solution {

    private static void leftViewTree(Node root) {
        List<Node> list =  new ArrayList<>();
        leftViewTreeUtil(root, list, 0);

        for(Node curr: list) {
            System.out.print(curr.data+" ");
        }
    }

    //we are using preorder mechanism . root -> left -> right
    private static void leftViewTreeUtil(Node root, List<Node> list, int level) {
        // Base case: if the current node is null, just return
        if(root ==null) return;

        // If this is the first node we're visiting at this level,
        // add it to the list — it will be the leftmost node at that level
        if(level == list.size() ) {
            list.add(level, root);
        }

        //recursively go to the left and right child — ensures leftmost nodes are visited first
        leftViewTreeUtil(root.left, list, level+1);
        leftViewTreeUtil(root.right, list, level+1);
    }


    public static void main(String[] args) {
        Node root = new Node(5);
        root.left=new Node(1);
        root.right=new Node(7);
        root.left.left=new Node(2);
        root.left.right=new Node(4);
        root.left.right.left= new Node(3);
        root.left.right.right=new Node(6);

        leftViewTree(root);
    }
}
