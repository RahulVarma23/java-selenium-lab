package imp.array;

import java.util.Arrays;

public class ShiftZeroToLeft {

	public static void main(String[] args) {		
		int [] arr={2,3,1,1,5,1,8};

        int index = arr.length-1;

        for(int i=arr.length-1;i>=0;i--) {
            if(arr[i] !=0) {
                arr[index--] = arr[i];
            }
        }

        while(index>=0) {
            arr[index--] =0;
        }

		System.out.println(Arrays.toString(arr));
	}
}
