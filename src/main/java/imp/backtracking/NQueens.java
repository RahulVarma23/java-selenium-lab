package imp.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NQueens {

    public static void main(String[] args) {
        int n = 4;
        NQueens solver = new NQueens();
        List<List<String>> solutions = solver.solveNQueens(n);

        System.out.println("Number of solutions: " + solutions.size());
        for (List<String> sol : solutions) {
            for (String row : sol) {
                System.out.println(row);
            }
            System.out.println();
        }
    }

    //TC = O(N!), SC = O(N)
    //In the first row, you have N choices.
    //In the second row, you have at most N−1 safe choices and so on..
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        char [] [] board = new char[n][n];

        for(char[] row : board) {
            Arrays.fill(row, '.');
        }

        backtrack(result, board, n, 0);
        return result;
    }

    private void backtrack(List<List<String>> result, char[][] board, int n, int row) {
        if (row==n) {
            List<String> list = new ArrayList<>();

            for(char[] r : board) {
                list.add(new String(r));
            }
            result.add(list);
            return;
        }

        for(int col =0; col<n ;col++) {
            if(isSafe(board, row, col, n)) {
                board[row][col] = 'Q';
                backtrack(result, board, n, row+1); //explore
                board[row][col] = '.';  // backtrack
            }
        }
    }

    private boolean isSafe(char[][] board, int row, int col, int n) {
        // check column
        for(int i=row-1; i>=0; i--) {
            if(board[i][col]=='Q') return false;
        }

        // check upper-left diagonal
        for(int i=row-1, j=col-1; i>=0 && j>=0 ; i--, j--) {
            if(board[i][j]=='Q') return false;
        }

        // check upper-right diagonal
        for(int i=row-1,  j=col+1; i>=0 && j<n; i-- , j++ ) {
            if(board[i][j]=='Q') return false;
        }
        return true;
    }
}
