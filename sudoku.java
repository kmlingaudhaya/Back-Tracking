package backTracking;

// solve sudoku by backTracking

public class sudoku {
    public static void main(String[] args) {
        int[][] board = {{5, 3, 0, 0, 7, 0, 0, 0, 0},
                         {6, 0, 0, 1, 9, 5, 0, 0, 0},
                         {0, 9, 8, 0, 0, 0, 0, 6, 0},
                         {8, 0, 0, 0, 6, 0, 0, 0, 3},
                         {4, 0, 0, 8, 0, 3, 0, 0, 1},
                         {7, 0, 0, 0, 2, 0, 0, 0, 6},
                         {0, 6, 0, 0, 0, 0, 2, 8, 0},
                         {0, 0, 0, 4, 1, 9, 0, 0, 5},
                         {0, 0, 0, 0, 8, 0, 0, 7, 9}};
    if (solveSudoku(board, 0, 0)) {
        print(board);
    } else {
        System.out.println("No solution exists");
    }

    }

    public static boolean solveSudoku(int [][] board, int row, int col) {
        //base case
        if(row == 9) {
            return true;
            }

        //recursive step
        int nxtrow = row;
        int nxtcol = col+1;
        if(col+1 == 9){
            nxtcol = 0;
            nxtrow = row + 1;
        }
        // also if a digit is already present in the place, we go to next cell
        if(board[row][col] != 0){
            return solveSudoku(board, nxtrow, nxtcol);
            }

        // we will try placing digits from 1 to 9 in all the cells.
        for(int k = 1 ; k <= 9 ; k++){
            if(isSafe(board, row, col, k)) { 
                board[row][col] = k;
                if(solveSudoku(board, nxtrow, nxtcol)){
                    return true;
                }
                board[row][col] = 0;
            }
        }
        return false;


    }

    // weriting isSafe function  to validate the digits before placing them
    public static boolean isSafe(int [][] board, int row, int col, int num) {
        // checking the row
        for(int i = 0 ; i <= 8 ; i++){
            if(board[row][i] == num){
                return false;
            }
        }   
        //CHECKING THE COLUMN
        for(int i = 0 ; i <= 8 ; i++){
            if(board[i][col] == num){
                return false;
            }
        }
        //CHECKING THE BOX
        int rowStart = (row/3) * 3;
        int colStart = (col/3) * 3;
        for(int i = rowStart ; i < rowStart + 3 ; i++){
            for(int j = colStart ; j < colStart + 3 ; j++){
                if(board[i][j] == num){
                    return false;
                }
            }
        }
        return true;

    
    }

// print function to print the grid
    public static void print(int [][] board){
        for(int i = 0 ; i < 9 ; i++){
            for(int j = 0 ; j < 9 ; j++){
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

}
