package imp.mathandgeometry;

import java.util.Arrays;

public class MatrixTranspose {

    public static void main(String[] args) {
        int matrix [] [] = {{1,0,6},{3,7,2},{2,6,4},{2,9,1}};
        int rows = matrix.length;
        int columns = matrix[0].length;

        int transpose [] [] = new int[columns][rows];

        for(int i=0;i<rows; i++) {
            for(int j=0;j<columns; j++) {
                transpose[j] [i] = matrix[i][j];
            }
        }

        for(int [] arr :transpose ) {
            System.out.println(Arrays.toString(arr));
        }
    }
}
