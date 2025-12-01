package imp.mathandgeometry;

public class SecondLowest {

	public static void secondLowest(int [] arr) {
		int lowest = Integer.MAX_VALUE;
		int secondLowest = Integer.MAX_VALUE;

		for(int i=0;i<arr.length;i++) {
			if(arr[i]< lowest) {
				secondLowest=lowest;
				lowest = arr[i];
			}else if(arr[i]< secondLowest && arr[i] >lowest){
				secondLowest = arr[i];
			}
		}
		System.out.println(secondLowest);
	}

	public static void main(String[] args) {
		int [] num = {1,5,2,3,7,4};
		secondLowest(num);
	}
}
