package imp.stack;

import java.util.Stack;

public class AsteroidCollision {

    public static void main(String[] args) {
        int [] arr= {4,7,1, 2, -3, -7,17, 15,-16};
        System.out.println(asteroidCollision(arr));
    }
    
    private static Stack<Integer> asteroidCollision(int[] arr) {
        Stack<Integer> s = new Stack<>();
        for(int i=0;i<arr.length;i++) {
            if(arr[i]>0) {          //moving right
                s.push(arr[i]);     //if positive push to stack
            } else {
                while(!s.isEmpty() && s.peek()>0 && s.peek()<Math.abs(arr[i])) {
                    s.pop();         // pop smaller asteroids
                }
                if(!s.isEmpty() && s.peek()==Math.abs(arr[i])) {
                    s.pop();      // equal size asteroids destroy each other
                }else if(s.isEmpty() || s.peek()<0){
                    s.push(arr[i]);
                }
            }
        }
        return s;
    }
}
