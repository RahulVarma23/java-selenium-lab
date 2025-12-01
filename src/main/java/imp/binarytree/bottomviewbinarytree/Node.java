package imp.binarytree.bottomviewbinarytree;

import java.util.*;

public class Node {

    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
    }
}

class Solution {

    static class Pair{
        int hd;
        Node node;

        Pair(int hd, Node node) {
            this.hd = hd;
            this.node = node;
        }
    }

    public static List<Integer> bottomView(Node root) {
        List<Integer> list = new ArrayList<>();
        Queue <Pair> q = new LinkedList<>();
        Map<Integer, Integer> map = new TreeMap<>();
        q.add(new Pair(0, root));

        while(!q.isEmpty()) {
            Pair cur = q.poll();
            int hd = cur.hd;
            Node node = cur.node;

            map.put(hd, node.data);

            if(node.left !=null) {
                q.add(new Pair(hd-1, node.left));
            }

            if(node.right !=null ) {
                q.add(new Pair(hd+1, node.right));
            }
        }
        
        for(Map.Entry<Integer,Integer> e : map.entrySet()) {
            list.add(e.getValue());
        }
        return list;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left=new Node(2);
        root.right=new Node(5);
        root.left.left=new Node(3);
        root.left.right=new Node(4);
        root.right.left= new Node(6);
        root.right.right=new Node(7);

        System.out.println(bottomView(root));
    }
}