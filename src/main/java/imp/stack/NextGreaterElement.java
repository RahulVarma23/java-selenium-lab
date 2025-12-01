package imp.stack;

import java.util.Stack;

public class NextGreaterElement {

    public static void main(String[] args) {
        int[] arr = {6,0,8,1, 3}; //-> 8 8 -1 3 -1
        int[] result = findNextGreaterElement(arr);
        for(int num : result) {
            System.out.print(num + " ");
        }
    }

    public static int[] findNextGreaterElement(int[] arr) {
        int n = arr.length;
        int[] nge = new int[n];
        Stack<Integer> s = new Stack<>();

        for(int i=n-1;i>=0;i--) {

            while(!s.isEmpty() &&s.peek()<=arr[i]) {
                s.pop();
            }

            if(s.isEmpty()) {
                nge[i] = -1;
            }else {
                nge[i] = s.peek();
            }

            s.push(arr[i]);
        }


        return nge;
    }

    public static int[] findNextGreaterElements(int[] arr) {
        int n = arr.length;
        int[] nge = new int[n];
        for(int i=0;i<n;i++) {
            nge[i] = -1; // Default value if no greater element is found
            for(int j=i+1;j<n;j++) {
                if(arr[j]>arr[i]) {
                    nge[i] = arr[j];
                    break;
                }
            }
        }
        return nge;
    }
}
