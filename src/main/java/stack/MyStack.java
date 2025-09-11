package stack;

import java.util.LinkedList;
import java.util.Queue;

//Implement stack using Queues
public class MyStack {
    Queue<Integer> q = new LinkedList<>();

    public void push(int x) {
        q.add(x);
        int size = q.size();

        // Rotate queue so the new element is at front
        for(int i=0;i<size-1;i++) {
            q.add(q.remove());
        }
    }

    public int pop() {
        if(q.isEmpty()) throw new RuntimeException("Stack is empty");
        return q.remove();
    }

    public int top() {
        if(q.isEmpty()) throw new RuntimeException("Stack is empty");
        return q.peek();
    }

    public boolean empty() {
        return q.isEmpty();
    }

    public static void main(String[] args) {
            MyStack stack = new MyStack();

            stack.push(1);
            stack.push(2);
            stack.push(3);
            stack.push(4);

            System.out.println(stack.top()); // 4
            System.out.println(stack.pop()); // 4
            System.out.println(stack.top()); // 3
    }
}
