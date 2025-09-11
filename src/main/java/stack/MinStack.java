package stack;

import java.util.Stack;

public class MinStack {

    Stack<Integer> s = new Stack<>();
    int minValue;

    public void push(int val) {
        if(s.isEmpty()) {
            s.push(val);    // normal push
            minValue = val; // initialize minValue
        }
        else {
            if(val<minValue) {              // new min value found .
                s.push(2*val -minValue);  // push a modified value formula 2*newMin - oldMin
                minValue=val;          // update the minValue
            }else {
                s.push(val);             // normal push
            }
        }
    }

    public void pop() {
        if (s.isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }

        if(s.peek()<minValue) {            // if the top is less than minValue, it means it's a modified value
            minValue=2*minValue-s.peek(); // retrieve the old minValue using the formula
        }
        s.pop();                         // pop the top element
    }

    public int top() {
        if (s.isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }

        if(s.peek()<minValue) {   //if the top is a modified value
            return minValue;      // if the top is a modified value, return the current minValue
        }
        return s.peek();
    }

    public int getMin() {
        if (s.isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        return minValue;
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin()); // return -3
        minStack.pop();
        System.out.println(minStack.top());    // return 0
        System.out.println(minStack.getMin()); // return -2
    }
}
