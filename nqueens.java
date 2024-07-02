package backTracking;

public class nqueens {
    static int solutionCount = 0;
    public static void main(String[] args) {
        int n = 5;
        boolean[][] board = new boolean[n][n];
        if(nQueensSolver(board,0)){
            System.out.println("Solution exists");
            printBoard(board);
            
        } 
        else{
            System.out.println("No solution exists");
            }
        

    }

    public static boolean nQueensSolver(boolean board[] [], int row) {
        //base case
        if (row == board.length) {
            // printBoard(board);
            // solutionCount++;
            return true;
        }
        //recursive case
        for (int j=0; j<board.length; j++) {
            if (isSafe(board, row, j)) {
                board[row][j] = true;
                if(nQueensSolver(board, row+1)){
                    return true;
                }
                board[row][j] = false; // for backtracking step
            }
        }
        return false;


    }

    public static boolean isSafe(boolean board [] [], int row, int col) {
        //check vertically up
        
        for(int i = row - 1; i >= 0; i--) {
            if(board[i][col] == true) {
                return false;
            }
        }
        //check for left diagonal
        for(int i = row - 1, j = col - 1; i >=0 && j>=0 ; i--,j--){
            if(board[i][j] == true) {
                return false;
                }
        }
        //check for right diagonal
        for(int i = row - 1, j = col + 1; i >=0 && j< board.length; i--,j++){
            if(board[i][j] == true) {
                return false;
                }
        }
        return true;
    }

    public static void printBoard(boolean board [][]) {
        System.out.println("-----chessboard------");
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] == true) {
                    System.out.print("Q ");
                    } else {
                        System.out.print("X ");
                        }
                }
                System.out.println();
            }
    
    }
}
