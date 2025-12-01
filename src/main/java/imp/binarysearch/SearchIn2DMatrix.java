package imp.binarysearch;

public class SearchIn2DMatrix {

    //TC : O(n+m) why? Because in worst case we may have to traverse all rows and all columns
    private static boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        int m =matrix[0].length;

        int row =0;
        int col = m-1;

        while(row <n && col>=0) {
            if(matrix[row][col]==target) {
                return true;
            }else if(matrix[row][col]>target) {
                col--;
            }else {
                row++;
            }
        }
        return false;
    }
	
	public static void main(String[] args) {
        int [] [] matrix = {
                {1,3,5,7},
                {10,11,16,20},
                {23,30,34,60}
        };
		System.out.println(searchMatrix(matrix, 40));
	}
}
