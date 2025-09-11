package binarytree.insertintobinarytree;

class Node {
    int data;
    Node left , right =null;

    public Node(int data) {
        this.data=data;
    }
}

class Solution {

    private static Node insertIntoBST(Node root, int val) {
        if(root ==null) {
            return new Node(val);
        }

        Node cur = root;

        while(true) {
            if(cur.data<=val) {
                if(cur.right !=null) cur = cur.right;
                else {
                    cur.right = new Node(val);
                    break;
                }
            }else {
                if(cur.left!=null) cur = cur.left;
                else {
                    cur.left = new Node(val);
                    break;
                }
            }
        }
        return root;
    }

    public static void main(String[] args) {
        Node root = new Node(5);

        root.left = new Node(3);
        root.right = new Node(9);
        root.left.left = new Node(1);
        root.left.right = new Node(4);
        // root.left.right.right = new Node(6);

        System.out.println(insertIntoBST(root, 6));
    }
}

