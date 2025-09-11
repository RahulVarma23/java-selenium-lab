package binarytree.topviewbinarytree;

import java.util.*;

public class Node {
    int data;
    Node left, right;

    public Node(int data) {
        this.data = data;
    }
}
class Solution {

    static class Pair {
        Node node;
        int coln;

        public Pair(int coln, Node node) {
            this.node = node;
            this.coln=coln;
        }
    }

    public static List<Integer> topViewTree(Node root) {
        List<Integer> list =  new ArrayList<>();

        Queue <Pair> q = new LinkedList<>();

        Map<Integer, Integer> map = new TreeMap<>();

        q.add(new Pair(0, root));
        while(!q.isEmpty()) {
            Pair cur = q.poll();
            int coln = cur.coln;
            Node node=cur.node;
            if(! map.containsKey(coln)) {
                map.put(coln, node.data);
            }
            if(node.left !=null) {
                q.add(new Pair(coln-1, node.left));
            }
            if(node.right !=null) {
                q.add(new Pair(coln+1, node.right));
            }
        }
        for(Map.Entry<Integer, Integer> entry: map.entrySet()) {
            list.add(entry.getValue());
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

        System.out.println(topViewTree(root));
    }
}
