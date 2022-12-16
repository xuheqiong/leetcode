package leetcode.P0036_unsolved;

/**
 * TODO
 * 数请你判断一个9 x 9 的数独是否有效。只需要 根据以下规则 ，验证已经填入的数字是否有效即可。
 * <p>
 * 数字1-9在每一行只能出现一次。
 * 数字1-9在每一列只能出现一次。
 * 数字1-9在每一个以粗实线分隔的3x3宫内只能出现一次。（请参考示例图）
 * <p>
 */
public class Solution {

    public static boolean isValidSudoku(char[][] board) {

        for (int row = 0; row < 9; row++) {
            boolean[] colUsed = new boolean[9];
            // 纵坐标
            // 判断是否数字1-9在每一行只能出现一次。
            for (int col = 0; col < 9; col++) {
                if (board[row][col] != '.') {
                    if (colUsed[board[row][col] - '1']) {
                        return false;
                    }
                    colUsed[board[row][col] - '1'] = true;
                }
            }
        }

        // 判断数字1-9在每一列只能出现一次。
        for (int col = 0; col < 9; col++) {
            boolean[] rowUsed = new boolean[9];
            // 横坐标
            for (int row = 0; row < 9; row++) {
                // 判断是否数字1-9在每一行只能出现一次。
                if (board[row][col] != '.') {
                    if (rowUsed[board[row][col] - '1']) {
                        return false;
                    }
                    rowUsed[board[row][col] - '1'] = true;
                }
            }
        }


        int[][] offsetMatrix = new int[][]{
                {0, 0}, {0, 3}, {0, 6},
                {3, 0}, {3, 3}, {3, 6},
                {6, 0}, {6, 3}, {6, 6}};

        for (int i = 0; i < 3; i++) {
            int[] offset = offsetMatrix[i];
            boolean[] cellUsed = new boolean[9];
            for (int j = 0; j < 3; j++) {
            }
        }

        return true;
    }
}