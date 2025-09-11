package binarytree.converttreeintostring;

public class Node {

    Node left, right;
    int val;

    Node(int val) {
        this.val = val;
    }
}

class Solution {

    /* Rules: OUTPUT-> R(L)(R)
    Use parentheses to show child nodes.
    Omit empty right child only if left child is present.
    If left child is missing but right child is present, you must include empty () to preserve structure.
     */
    private static String solve(Node root) {
        if(root==null) {
            return "";
        }

        String result = String.valueOf(root.val);

        String left = solve(root.left);
        String right = solve(root.right);

        //if both are empty then return result
        if(left.isEmpty() && right.isEmpty()) {
            return result;
        }

        //If left child is missing but right child is present, you must include empty () to preserve structure.
        if(left.isEmpty()) {
            return result+"()" + "(" +right+")";
        }

        //Omit empty right child only if left child is present.
        if(right.isEmpty()) {
            return result + "(" +left+")";
        }

        return result + "(" +left+")" + "(" +right+")";
    }

        public static void main(String[] args) {
            Node root = new Node(1);
            root.left=new Node(2);
            root.right=new Node(5);

            root.left.left=new Node(3);
            root.left.right=new Node(4);
            root.right.right=new Node(7);

            System.out.println(solve(root));
        }
}
