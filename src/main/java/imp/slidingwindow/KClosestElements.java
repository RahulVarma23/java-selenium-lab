package imp.slidingwindow;

import java.util.ArrayList;
import java.util.List;

public class KClosestElements {

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        int k = 2;
        int x = 3;
        System.out.println(findKClosestElements(arr, k, x));
    }

    private static List<Integer> findKClosestElements(int[] arr, int k, int x) {
        List<Integer> list = new ArrayList<>();
        int left=0;
        int right=arr.length-1;

        while(right-left+1 > k) {
            if(Math.abs(arr[left]-x)> Math.abs(arr[right]-x)) {
                left++;
            }else {
                right--;
            }
        }

        for(int i=left;i<=right;i++) {
            list.add(arr[i]);
        }
        return list;
    }
}
