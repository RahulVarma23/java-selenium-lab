package imp.array;
import java.util.Arrays;

public class ShiftZeroRight {

	public static void main(String[] args) {
		int [] a={2,3,0,0,5,0,8};

        int i =0; // Pointer to track the position to place the next non-zero number

        //step 1: move all non zero to forward
        for(int n: a) {
            if(n!=0) {
                a[i++]=n;
            }
        }

        //Step 2: Fill the remaining array with zeros
        while(i<a.length) {
            a[i++] = 0;
        }

        System.out.println(Arrays.toString(a));
	}
}
