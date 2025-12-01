package imp.binarytree.kthsmallestinbst;

class Node {
    int data;
    Node left , right =null;

    public Node(int data) {
        this.data=data;
    }
}

class Solution {

    static int result = -1;
    static int count = 0;
    public static int kthSmallest(Node root, int k) {
        inOrder(root, k);
        return result;
    }

    //In-order traversal of a BST gives nodes in sorted order
    //During traversal, keep a counter of visited nodes
    //When the counter reaches k, return that node's value.
    private static void inOrder(Node root, int k) {
        if(root==null) return;

        inOrder(root.left, k);

        count++;
        if(count == k) {
            result = root.data;
            return;
        }

        inOrder(root.right, k);
    }

    public static void main(String[] args) {
        Node root = new Node(4);
        root.left = new Node(3);
        root.right = new Node(5);
        root.left.left = new Node(2);

        System.out.println(kthSmallest(root, 4));
    }
}

