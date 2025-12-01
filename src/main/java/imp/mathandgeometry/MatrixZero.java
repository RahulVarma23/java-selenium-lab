package imp.mathandgeometry;

public class MatrixZero {

    public static void main(String[] args) {
        int [] [] arr = {{1,1,1}, {1,0,1}, {1,1,1}};

        int rows = arr.length;
        int columns = arr[0].length;
        int row = 0;
        int coln = 0;

        for(int i=0;i<rows;i++) {
            for(int j=0;j<columns;j++) {
                if(arr[i][j]==0) {
                    row = i;
                    coln=j;
                }
            }
        }

        for(int i=0; i<rows;i++) {
            for(int j=0;j<columns; j++) {
                if(j==coln) {
                    arr[i][j] =0;
                }
            }
        }

        for(int i=0; i<rows;i++) {
            for(int j=0;j<columns; j++) {
                if(i==row) {
                    arr[i][j] =0;
                }
            }
        }

        for(int i=0; i<rows;i++) {
            for(int j=0;j<columns; j++) {
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }
}
