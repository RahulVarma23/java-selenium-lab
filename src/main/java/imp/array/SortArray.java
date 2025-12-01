package imp.array;

import java.util.Arrays;

public class SortArray {

	public static void main(String[] args) {

		int a[] = { 1, 4, 8, 6, 5, 2, 9 };

		// using third variable
//     for(int i=0;i<a.length;i++) {
//    	 for(int j=i+1;j<a.length;j++) {
//    		 if(a[i]>a[j]) {
//    			 int temp= a[i];
//    			 a[i]=a[j];
//    			 a[j]=temp;
//    		 }
//    	 }
//     }

		// without third variables

		for (int i = 0; i < a.length; i++) {
			for (int j = i + 1; j < a.length; j++) {
				if (a[i] > a[j]) {
					a[i] = a[i] + a[j];
					a[j] = a[i] - a[j];
					a[i] = a[i] - a[j];
				}
			}
		}
		System.out.println(Arrays.toString(a));
	}
}
