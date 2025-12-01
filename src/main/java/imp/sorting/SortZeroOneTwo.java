package imp.sorting;

import java.util.Arrays;

//Dutch national flag algorihtm
public class SortZeroOneTwo {

    public static void main(String[] args) {
        int[] arr = {2, 0, 1, 2, 1, 0, 1, 2};
        sortColors(arr);
        System.out.println(Arrays.toString(arr));  // Output: [0, 0, 1, 1, 1, 2, 2, 2]
    }

    private static void sortColors(int[] arr) {

        int low =0; int mid =0; int high = arr.length-1;

        while(mid<=high) {
            switch(arr[mid]) {
                case 0 :
                    swap(arr, low, mid );
                    low++;
                    mid++;
                    break;

                case 1:
                    mid++;
                    break;
                case 2:
                    swap(arr, mid, high);
                    high--;
                    break;
            }
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
