package imp.stack;

import java.util.Stack;

public class LargestRectangleInHistogram {

    public static void main(String[] args) {
        int[] arr = {7,1,7,2,2,4}; //-> maxArea =8
        int result = findLargestRectangle(arr);
        System.out.println("Largest rectangle area = "+result);
    }

    private static int findLargestRectangle(int[] arr) {
        int max =0;
        int n = arr.length;
        int [] pse = findPreviousSmallerElements(arr);
        int [] nse = findNextSmallerElements(arr);

        for(int i=0;i<n;i++) {
            int area = arr[i] * (nse[i]-pse[i]-1);
            max = Math.max(max, area);
        }

        return max;
    }

    private static int[] findNextSmallerElements(int[] arr) {
        int n = arr.length;
        int[] nse = new int[n];
        Stack<Integer> s = new Stack<>();

        for(int i=n-1;i>=0;i--) {
            while(!s.isEmpty() && arr[s.peek()]>=arr[i]) {
                s.pop();
            }

            if(s.isEmpty()) {
                nse[i]=n;
            }else {
                nse[i]=s.peek();
            }

            s.push(i);
        }

        return nse;
    }

    private static int[] findPreviousSmallerElements(int[] arr) {
        int n = arr.length;
        int[] pse = new int[n];
        Stack<Integer> s = new Stack<>();

        for(int i=0;i<n;i++) {
            while(!s.isEmpty() && arr[s.peek()]>=arr[i]) {
                s.pop();
            }

            if(s.isEmpty()) {
                pse[i]=-1;
            }else {
                pse[i]=s.peek();
            }

            s.push(i);
        }

        return pse;
    }
}
