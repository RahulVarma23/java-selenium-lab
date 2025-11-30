package mathandgeometry;

public class SquareRoot {

	public static void main(String[] args) {
         System.out.println(mySquareRoot(28));
	}

	private static int mySquareRoot(int x) {
		int root =1;
		
		for(int i=1;i<=x ; i++) {
			if(i*i<=x) {
                root=i;
            }else {
                break;
            }
		}	
		return root;
	}
}
