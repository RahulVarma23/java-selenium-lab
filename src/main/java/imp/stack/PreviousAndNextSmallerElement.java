package imp.stack;

import java.util.Arrays;
import java.util.Stack;

public class PreviousAndNextSmallerElement {

    public static void main(String[] args) {
        int[] arr = {6,0,8,1, 3}; //pse-> -1 -1 0 0 1  ,  nse-> 0, -1, 1 -1 -1
        System.out.println(Arrays.toString(findPreviousSmallerElements(arr)));
        System.out.println(Arrays.toString(findNextSmallerElements(arr)));
    }

    private static int[] findPreviousSmallerElements(int[] arr) {
        int n = arr.length;
        int[] pse = new int[n];
        Stack<Integer> s = new Stack<>();

        for(int i=0;i<n;i++) {
            while(!s.isEmpty() && s.peek()>=arr[i]) {
                s.pop();
            }

            if(s.isEmpty()) {
                pse[i]=-1;
            }else {
                pse[i]=s.peek();
            }

            s.push(arr[i]);
        }

        return pse;
    }

    // 6,0,8,1,3 ->  nse 0, -1, 1 -1 -1
    private static int[] findNextSmallerElements(int[] arr) {
        int n = arr.length;
        int[] nse = new int[n];
        Stack<Integer> s = new Stack<>();

        for(int i=n-1;i>=0;i--) {

            while(!s.isEmpty() && s.peek()>=arr[i]) {
                s.pop();
            }


            if(s.isEmpty()) {
                nse[i]=-1;
            }else {
                nse[i]=s.peek();
            }

            s.push(arr[i]);
        }

        return nse;
    }
}
