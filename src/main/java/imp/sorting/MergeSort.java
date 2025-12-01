package imp.sorting;

import java.util.Arrays;

public class MergeSort {

    public static void main(String[] args) {
        int[] arr = {64, 34, 25, 12, 22, 11, 90};
        int start =0, end = arr.length-1;
        devide(arr, start, end);
        System.out.println(Arrays.toString(arr));
    }

    private static void devide(int[] arr, int start, int end) {
        if(start<end) {
            int mid = start+ (end-start)/2;
            devide(arr, start, mid);
            devide(arr, mid+1, end);
            conquer(arr, start, mid, end);
        }
    }

    private static void conquer(int[] arr, int start, int mid, int end) {
        int [] merged = new int [end-start+1];
        int idx1 = start; // first array index
        int idx2 = mid+1; // second array index
        int x=0; // merged array index

        while(idx1<=mid && idx2<=end) {

            if(arr[idx1]<=arr[idx2]) {
                merged[x++] = arr[idx1++];
            }else {
                merged[x++] = arr[idx2++];
            }
        }

        while(idx1<=mid) {
            merged[x++] = arr[idx1++];
        }

        while(idx2<=end) {
            merged[x++] = arr[idx2++];
        }

        for(int i=0; i<merged.length;i++) {
            arr[start + i] = merged[i];
        }
    }
}
