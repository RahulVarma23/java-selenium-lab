package linkedlist;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    class Node {

        int key, value;

        Node next, prev;

        Node(int key, int value) {
            this.value = value;
            this.key = key;
        }
    }

        int capacity;
        Map<Integer, Node> map = new HashMap<>();
        Node head, tail;

        public LRUCache (int capacity) {
            this.capacity=capacity;
            head = new Node(-1,-1);
            tail = new Node(-1,-1);
            head.next=tail;
            tail.prev= head;
        }

        public void remove(Node node) {
            Node prevNode = node.prev;   //store prev node
            Node afterNode = node.next;  //store next node

            prevNode.next = afterNode;   //point prev node next to afterNode
            afterNode.prev = prevNode;   //point afterNode prev to prevNode
        }

    public void insertToFront(Node node) {
            Node afterHead = head.next;  //store head next
            head.next = node;   //point head.next to newNode
            node.next = afterHead; //point newNode next to stored head next
            node.prev = head;     //point node prev to head
            afterHead.prev =node; // point afterhead prev to newNode
    }

    public int get(int key) {
            //if key doesnt exist return -1
            if(!map.containsKey(key)) return -1;

            //otherwise get node from key and insert it to front. return node value
           Node node =  map.get(key);
           remove(node);
           insertToFront(node);
           return node.value;
        }

    public void put(int key, int value) {

        // If key exists, remove old node
            if(map.containsKey(key)) {
                Node node = map.get(key);
                remove(node);
                map.remove(key);
            }

        // If at capacity, remove least recently used node
            if(capacity==map.size()) {
                Node lru = tail.prev;
                remove(lru);
                map.remove(lru.key);
            }

           // Insert new node
            Node newNode = new Node(key, value);
            insertToFront(newNode);
            map.put(key, newNode);
    }

    public static void main(String[] args) {
        LRUCache lru = new LRUCache(2);

        lru.put(1, 1); // cache = {1=1}
        lru.put(2, 2); // cache = {2=2, 1=1}
        System.out.println(lru.get(1)); // returns 1, cache = {1=1, 2=2}
        lru.put(3, 3); // evicts key 2, cache = {3=3, 1=1}
        System.out.println(lru.get(2)); // returns -1 (not found)
        lru.put(4, 4); // evicts key 1, cache = {4=4, 3=3}
        System.out.println(lru.get(1)); // returns -1 (not found)
        System.out.println(lru.get(3)); // returns 3
        System.out.println(lru.get(4)); // returns 4
    }
}
