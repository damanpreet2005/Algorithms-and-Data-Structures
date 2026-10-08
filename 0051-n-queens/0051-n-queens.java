class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        char[][] board = new char[n][n];
        for(char[] row : board){
            Arrays.fill(row, '.');
        }
        backtrack(0, n, board, result);
        return result;
    }

    public void backtrack( int row, int n, char[][] board, List<List<String>> result){
        // base case
        if (row == board.length) {
            result.add( constructBoard(board) );
            return;
        }

        //other cases
        for (int i = 0; i < n; i++) {
            if( isSafe(row, i, n, board) ){
                board[row][i] = 'Q';
                backtrack(row + 1, n, board, result);
                board[row][i] = '.';
            }
        }
    }

    public boolean isSafe(int row, int col, int n, char[][] board ){
        // verticle up
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 'Q'){
                return false;
            }
        }

        // diagonal left
        for (int i = row - 1, j = col - 1 ; i >= 0 && j >= 0; i--, j-- ){
            if(board[i][j] == 'Q'){
                return false;
            }
        }

        //diagonal right
        for (int i = row - 1, j = col + 1 ; i >= 0 && j < n; i--, j++ ){
            if(board[i][j] == 'Q'){
                return false;
            }
        }

        return true;
    }

    public List<String> constructBoard(char[][] board ){
        List<String> path = new ArrayList<>();
        for(char[] row: board){
            path.add(new String(row)); //array of ind characters are replaced with an array
        }
        return path;
    }
}