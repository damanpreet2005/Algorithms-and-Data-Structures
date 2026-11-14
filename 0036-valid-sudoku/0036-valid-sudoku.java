class Solution {
    public boolean isValidSudoku(char[][] board) {
        boolean[][] rows = new boolean[9][9];
        boolean[][] cols = new boolean[9][9];
        boolean[][] box = new boolean[9][9];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') continue;
                int num = board[i][j] - '1';

                int box_idx = (i / 3) * 3 + (j / 3);
                if(rows[i][num] == true || cols[j][num] == true || box[box_idx][num] == true) return false;

                rows[i][num] = true;
                cols[j][num] = true;
                box[box_idx][num] = true;
            }
        }

        return true;
    }
}