package imp.stack;


import java.util.Stack;

//Implement Queues using stack
public class MyQueue {

    Stack<Integer> s1 = new Stack<>();
    Stack<Integer> s2 = new Stack<>();

    public void push(int x) {
        s1.push(x);
    }

    // Removes the element from front of queue
    public int pop() {
        if(isEmpty()) throw new RuntimeException("Queue is empty");
        shiftStacks();
        return s2.pop();
    }

    // Get the front element
    public int peek() {
        if(isEmpty()) throw new RuntimeException("Queue is empty");
        shiftStacks();
        return s2.peek();
    }

    // Return whether the queue is empty
    public boolean isEmpty() {
        return s1.isEmpty() && s2.isEmpty();
    }

    // Helper method to move elements if needed
    private void shiftStacks() {
        if(s2.isEmpty()){
            while(!s1.isEmpty()) {
                s2.push(s1.pop());
            }
        }
    }

    public static void main(String[] args) {
        MyQueue q = new MyQueue();

        q.push(1);
        q.push(2);
        q.push(3);

        System.out.println(q.peek()); // 1
        System.out.println(q.pop());  // 1
        System.out.println(q.peek()); // 2

        q.push(4);
        System.out.println(q.pop());  // 2
    }
}
