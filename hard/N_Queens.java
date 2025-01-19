class Solution {
    public List<List<String>> solveNQueens(int n) {
    //     char[][] board = new char[n][n];
    //     for(int i=0; i<board.length; i++){
    //         for(int j=0; j<board[0].length; j++){
    //             board[i][j] = '.';
    //         }
    //     }
    //     List<List<String>> res = new ArrayList<>();
    //     dfs(0, board, res);
    //     return res;
    // }

    // public void dfs(int col, char[][] board, List<List<String>> res ){
    //     // after reaching end of board add in list
    //     // base case
    //     if(col == board.length){
    //         List<String> subList = new ArrayList<>();
    //             for (int i = 0; i < board.length; i++) {
    //                 subList.add(new String(board[i]));
    //             }
    //         res.add(subList);            
    //         return;
    //     }

    //     for(int row=0; row<board.length; row++){
    //         if(isSafeToPlace(row, col, board)){
    //             // mark as Q as we found suitable place to keep Q without any expectation of attack 
    //             board[row][col] = 'Q';
    //             //explore other possibilites
    //             dfs(col + 1, board, res);
    //             //backtrack and remove queen 
    //             board[row][col] = '.';

    //         }
    //     }
    // }

    // public boolean isSafeToPlace(int row, int col, char[][] board){

    //     int dupRow = row;
    //     int dupCol = col;

    //     // for left upper diagonal checking if any Q is present or not
    //     while(row >= 0 && col >= 0){
    //         if(board[row][col] == 'Q') return false;
    //         row--;
    //         col--;
    //     }

    //     row = dupRow;
    //     col = dupCol;

    //     //for left check if any Q is present or not
    //     while(col >= 0){
    //         if(board[row][col] == 'Q') return false;
    //         col--;
    //     }

    //     row = dupRow;
    //     col = dupCol;

    //     // to check in down left diagonal if any Q is present or not
    //     while(row < board.length && col >= 0){
    //         if(board[row][col] == 'Q') return false;
    //         row++;
    //         col--;
    //     }

    //     return true;

        char[][] board = new char[n][n];
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++){
                board[i][j] = '.';
            }
        }

        List<List<String>> res = new ArrayList<>();
        int[] leftRow = new int[n];
        int[] lowerDiagonal = new int[2*n-1];
        int[] upperDiagonal = new int[2*n-1];

        dfsSolve(0, board, res, leftRow, lowerDiagonal, upperDiagonal);
        return res;
    }

        public void dfsSolve(int col, char[][] board,  List<List<String>> res, int[] leftRow, int[] lowerDiagonal, int[] upperDiagonal){
            // base case
            if(col == board.length){
                List<String> subList = new ArrayList<>();
                for(int i=0; i<board.length; i++){
                    subList.add(new String(board[i]));
                }
                res.add(subList);
                return;
            }

            for(int row=0; row<board.length; row++){
                if(leftRow[row] == 0 && lowerDiagonal[row + col] == 0 && upperDiagonal[(board.length - 1) + (col - row)] == 0){

                    // explore new possibilities
                    board[row][col] = 'Q';
                    leftRow[row] = 1;
                    lowerDiagonal[row + col] = 1;
                    upperDiagonal[(board.length - 1) + (col - row)] = 1;

                    // recursion 
                    dfsSolve(col + 1, board, res, leftRow, lowerDiagonal, upperDiagonal);

                    // backtrack to remove the marked cols 

                    board[row][col] = '.';
                    leftRow[row] = 0;
                    lowerDiagonal[row + col] = 0;
                    upperDiagonal[(board.length - 1) + (col - row)] = 0;


                }
            }
        }
    
}
