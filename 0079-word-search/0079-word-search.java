class Solution {
    public boolean exist(char[][] board, String word) {
        int rows = board.length;
        int cols = board[0].length;

        for (int i = 0; i < rows; i++){
            for (int j = 0; j < cols; j++){
                if ( board[i][j] == word.charAt(0) ){
                    if (dfs(0, i, j, board, word)) { 
                        return true;
                    }
                }
            }
        }

        return false;
    }

    public boolean dfs(int index, int row, int col, char[][] board, String word){
        // base case
        if ( index == word.length()){
            return true;
        } else if (row < 0 || col < 0 || row >= board.length || col >= board[0].length ||  board[row][col] != word.charAt(index)){
            return false;
        }

        char temp = board[row][col];
        board[row][col] = '#';

        // other cases
        boolean found = dfs(index + 1, row - 1, col, board, word) || //up
                        dfs(index + 1, row + 1, col, board, word) || //down
                        dfs(index + 1, row, col - 1, board, word) || //left
                        dfs(index + 1, row, col + 1, board, word); //right

        board[row][col] = temp;
        
        return found;
    }
}