package imp.array;

import java.util.HashSet;
import java.util.Set;

public class ValidSudoku {

    public static void main(String[] args) {
        char[][] board = {
                {'1','2','.','.','3','.','.','.','.'},
                {'4','.','.','5','.','.','.','.','.'},
                {'.','9','1','.','.','.','.','.','3'},
                {'5','.','.','.','6','.','.','.','4'},
                {'.','.','.','8','.','3','.','.','5'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','.','.','.','.','.','2','.','.'},
                {'.','.','.','4','1','9','.','.','8'},
                {'.','.','.','.','8','.','.','7','9'}
        };

        System.out.println(isValidSudoku(board));
    }

    private static boolean isValidSudoku(char[][] board) {
        //rows = 9, cols = 9

        //validate rows
        for (int row = 0; row < 9; row++) {
            Set<Character> set = new HashSet<>();

            for (int col = 0; col < 9; col++) {
                if (board[row][col] != '.') {
                    if (set.contains(board[row][col])) {
                        return false;
                    }
                    set.add(board[row][col]);
                }
            }
        }

        //validate cols
        for (int col = 0; col < 9; col++) {
            Set<Character> set = new HashSet<>();

            for (int row = 0; row < 9; row++) {
                if (board[row][col] != '.') {
                    if (set.contains(board[row][col])) {
                        return false;
                    }
                    set.add(board[row][col]);
                }
            }
        }

        //validate 3x3 sub-boxes

        for(int sr=0; sr<9; sr+=3) {

            int er = sr+2;

            for(int sc=0;sc<9;sc+=3) {

                int ec = sc+2;

                //start row, end row, start col, end col
                if(!isValidBox(board, sr, er, sc, ec)) return false;

            }
        }
        return true;
    }

    private static boolean isValidBox(char[][] board, int sr, int er, int sc, int ec) {
        Set<Character> set = new HashSet<>();

        for(int row=sr; row<=er; row++) {
            for(int col=sc; col<=ec; col++) {
                if(board[row][col] != '.') {
                    if(set.contains(board[row][col])) {
                        return false;
                    } else {
                        set.add(board[row][col]);
                    }
                }
            }
        }
        return true;
    }
}
