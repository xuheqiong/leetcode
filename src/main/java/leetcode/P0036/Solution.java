package leetcode.P0036;

/**
 * 数请你判断一个9 x 9 的数独是否有效。只需要 根据以下规则 ，验证已经填入的数字是否有效即可。
 * <p>
 * 数字1-9在每一行只能出现一次。
 * 数字1-9在每一列只能出现一次。
 * 数字1-9在每一个以粗实线分隔的3x3宫内只能出现一次。（请参考示例图）
 * <p>
 */
public class Solution {

    public boolean isValidSudoku(char[][] board) {

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    boolean onlyOnceInRow = isOnlyOnceInRow(board, i, j, board[i][j]);
                    boolean onlyOnceInCol = isOnlyOnceInCol(board, i, j, board[i][j]);
                    boolean onlyOnceInSoduku = isOnlyOnceInSoduku(board, i, j, board[i][j]);

                    if (!onlyOnceInRow || !onlyOnceInCol || !onlyOnceInSoduku) {
                        return false;
                    }
                }
            }
        }

        return true;
    }

    /**
     * 判断是否只在同一行出现一次
     *
     * @param board
     * @param rowNum 行数
     * @param c      字符
     * @return
     */
    private boolean isOnlyOnceInRow(char[][] board, int rowNum, int colNum, char c) {
        for (int col = 0; col < 9; col++) {
            if (board[rowNum][col] == c && col != colNum) {
                return false;
            }
        }

        return true;
    }

    /**
     * 判断是否只在同一列出现一次
     *
     * @param board
     * @param rowNum
     * @param colNum 列数
     * @param c
     * @return
     */
    private boolean isOnlyOnceInCol(char[][] board, int rowNum, int colNum, char c) {

        for (int row = 0; row < 9; row++) {
            if (board[row][colNum] == c && row != rowNum) {
                return false;
            }
        }
        return true;
    }

    /**
     * 判断九宫格内字符只出现一次
     *
     * @param board
     * @param rowNum
     * @param colNum
     * @param c
     * @return
     */
    private boolean isOnlyOnceInSoduku(char[][] board, int rowNum, int colNum, char c) {
        for (int i = 3 * (rowNum / 3); i < 3 * (rowNum / 3) + 3; i++) {
            for (int j = 3 * (colNum / 3); j < 3 * (colNum / 3) + 3; j++) {
                if (board[i][j] == c && !((i == rowNum) && (j == colNum))) {
                    return false;
                }
            }
        }
        return true;
    }


    public static void main(String[] args) {

        Solution solution = new Solution();

        char[][] board = new char[][]{
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};

        System.out.println(solution.isValidSudoku(board));
    }
}