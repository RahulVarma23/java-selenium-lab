package imp.stack.twopointers;

import java.util.Arrays;

public class MinimumPlatform {
	
	
	static int findNumberOfPlatforms(int [] arr , int [] dep , int n) {
		
		Arrays.sort(arr);
		Arrays.sort(dep);
		int result = 0;int platforms =0;

        int i =0,j=0;// i for arrival , j for departure .
        // we will iterate through both arrays and compare arrival and departure times
		
		while(i<n) {
			if(arr[i]<=dep[j]) {
				platforms++;    // new train arrived before previous one departs
				i++;			// move to next arrival
			}else if(arr[i]>dep[j]) {
				platforms--;    // previous train departs before new one arrives
				j++;
			}			
            result = Math.max(platforms, result);
		}
		return result;
	}

	public static void main(String[] args) {
		int [] arr = {9 , 8 , 5,10,12,18};
		
		int [] dep = {9, 13,19, 11 ,13};
		
		System.out.println(findNumberOfPlatforms(arr,dep,6));
	}

}
